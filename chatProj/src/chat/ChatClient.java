package chat;
import java.io.*;
import java.net.*;
import javax.swing.*;
//此类用来处理和服务器的连接
public class ChatClient {
	private boolean connected;//是否连接标志	
	int serverSocketNumber;//连接数目
	String serverAddress;//服务器地址
	private Socket socket;//端口号	
	String Name;//机器名
	private int clientID;	
	ObjectOutputStream out;//输出流
	ObjectInputStream in;//输入流	
	DefaultListModel clientList;	
	private InputListener listener;//监听端口
	ClientInterface window;	
	//对进来的信息进行回应
	class InputListener extends Thread	{
		//提供中断循环的方式
		boolean running = false;		
		public void run() {
			//一直循环直到Listener停止
			while( true ){
				if( running ){
					//测试信息类型并作出相应的反映
					try	{
						Object serverMsg = in.readObject();						
						if( serverMsg instanceof Message ){
							window.showMessage((Message)serverMsg);
						}
						else if( serverMsg instanceof ChatRequest){
							window.openNewTab(((ChatRequest)serverMsg)
									.senderId );
						}
						else if( serverMsg instanceof UpdateList ){
							//如果有新的成员加入
							if(((UpdateList)serverMsg).requestType == true){
							clientList.addElement( ((UpdateList)serverMsg)
									.newClient );
							}
							//当有成员退出
							else {
							window.notifyUserLeft( ((UpdateList)serverMsg)
									.newClient );
                            clientList.removeElement(((UpdateList)serverMsg)
                            		.newClient);
							}
						}
						else if(serverMsg instanceof ServerShutDown) {
							disconnectFromServer( false );//从服务器断开连接
							window.notifyDisconnect();
							JOptionPane.showMessageDialog( window,
							"Server Has Been Shut Down","Connection Error",
							JOptionPane.ERROR_MESSAGE );
						}
						else if(serverMsg instanceof KickedOutNotice){
							disconnectFromServer( false );//从服务器断开连接
							window.notifyDisconnect();//关闭窗口
							JOptionPane.showMessageDialog( window,
								"Server Kicked You   Out","Connection Error",
								JOptionPane.ERROR_MESSAGE );
						}
					}
					catch(ClassNotFoundException cnfe){
						JOptionPane.showMessageDialog( window, 
								"Class of a serialized  object cannot be found.", 
								"Termination Error", JOptionPane.ERROR_MESSAGE );
						shutDown();//退出程序
					}
					catch( InvalidClassException ice ){
						JOptionPane.showMessageDialog(window, 
							"Something is wrong with a class used by " +
							"serialization.", "Termination Error",
                             JOptionPane.ERROR_MESSAGE );
						shutDown();//退出程序
					}
					catch( StreamCorruptedException sce ){
						JOptionPane.showMessageDialog(window,
							"Control information in the stream is " +
							"inconsistent.", "Termination Error",
                           JOptionPane.ERROR_MESSAGE );
						shutDown();
					}
					catch( OptionalDataException ode ){
						JOptionPane.showMessageDialog(window, 
							"Primitive data was found in the stream " +
							"instead of objects.", "Termination Error",
                            JOptionPane.ERROR_MESSAGE );
						shutDown();
					}
					catch( IOException ioe)	{		
					}
				}
			}
		}
	}	
	//将数据从用户端发送到服务器端
	void sendPublicMessage( String userMsg ) 
	   throws IOException {
		Message msg = new Message();//产生新的信息
		msg.audience = true;
		msg.roomNumber = 0;//聊天室号码
		msg.senderId = clientID;
		msg.message = Name + " says > " + userMsg;		
		out.writeObject( msg );//发送信息
		out.flush();//清空信息
	}	
	//只是对于一个用户发送信息
	void sendPrivateMessage(int recipient,
			String userMsg)  throws IOException	{
		Message msg = new Message();
		msg.audience = false;
		msg.recieverId = recipient;
		msg.senderId = clientID;//设定用户号
		msg.message = Name + " says > " + userMsg;		
		out.writeObject( msg );
		out.flush();
	}	
	// 某个用户想与另一个用户单独交谈
	void sendChatRequest( int recieverId )	{
		ChatRequest request = new ChatRequest();//获得聊天请求
		request.recieverId = recieverId;
		request.senderId = clientID;		
		try {
			out.writeObject( request );
		}
		catch( IOException io_e ){}
	}	
	//发送新的配置信息
	void setConfiguration(String newServer, int newPort){
		try	{
			FileWriter configFile = new FileWriter("clientConfig.cfg");
            //设定配置文件
			configFile.write( newServer.trim() + ";" + newPort + ";" );
			configFile.close();//关闭配置文件
		}
		catch( IOException io_e ){
			JOptionPane.showMessageDialog(window,
			"Cannot Save Configuration  File","File Error",
				JOptionPane.ERROR_MESSAGE );
		}
	}	
	//从文件获取配置信息，并保存在变量中
	void getConfiguration()	{
		try	{
			char[] buffer = new char[255];			
			FileReader configFile = new FileReader("clientConfig.cfg");			
			configFile.read( buffer );//从缓冲区中读入信息
			serverAddress = String.copyValueOf( buffer );//获得服务器地址
			String[] temp = serverAddress.split(";");			
			serverAddress = temp[0];
			serverSocketNumber = Integer.parseInt( temp[1] );			
		}
		catch( FileNotFoundException fnf_e ){
			JOptionPane.showMessageDialog( window,
				"Configuration File Not  Found, Using Defaults",
				"Configuration File Missing",
                   JOptionPane.ERROR_MESSAGE );			
			serverSocketNumber = 1665;//设置服务器端口号
			serverAddress = "localhost";
		}
		catch(IOException io_e ){
			JOptionPane.showMessageDialog(window,
					"Error Reading  Configuration File, Using Defaults",
					"Configuration  Error",JOptionPane.ERROR_MESSAGE );			
			serverSocketNumber = 1665; //设置服务器端口号
			serverAddress = "localhost";
		}			
	}	
	//从服务器断开，reason = true 为用户选择，	reason = false 为服务器选择
	synchronized void disconnectFromServer(
			boolean reason){
		try	{
			if( connected )	{
				//停止listener线程
				listener.running = false;				
				if( reason = true) {
					out.writeObject(new LogOut());
					out.flush();
				}				
				out.close();//关闭输出流
				socket.close();//关闭套接字				
				clientList.clear();
				connected = false;
			}
		}
		catch( IOException ex )
		{}
	}	
	//开始连接服务器
	synchronized boolean connectToServer(){
		getConfiguration();		
		try	{
			InetAddress addr = InetAddress.getByName( 
					serverAddress );
             //获得服务器地址
			socket = new Socket(addr,serverSocketNumber);
		}
	catch(UnknownHostException e)	{
	JOptionPane.showMessageDialog(window,
			"Host Not Found,Reconfigure...","Host Lookup Error",
			JOptionPane.ERROR_MESSAGE );
			return false;
		}
		catch( IOException e ){
			JOptionPane.showMessageDialog(window,
				"Server Not Found, Check If  Server Exists...",
					"Socket Error",JOptionPane.ERROR_MESSAGE );
			return false;//返回错误信息
		}		
		try	{
			in = new ObjectInputStream(socket.
					getInputStream());//输入流
			out = new ObjectOutputStream(socket.
					getOutputStream() );//输出流
		}
		catch(IOException e ){
			JOptionPane.showMessageDialog( window,
					"Cannot Create Data Stream, Closing Client...",
					"Data Stream Error",JOptionPane.ERROR_MESSAGE );
			try	{
				socket.close();//关闭套接字
			}
			catch( IOException io_e ){}			
			return false;
		}
		
		if(!handShake())return false;
		listener.running = true;		
		//是第一次连接则开启listener对象
		if( listener.isAlive() == false){
			listener.start();
		}		
		connected = true;
		return true;
	}	
	//设置参数内容
	private boolean handShake()	{
		try	{
			if(((ConnectionNotice)in.readObject()).status){
				out.writeObject( Name );//通过对象序列化发送信息
				if(((ConnectionNotice)in.readObject())
						.status == false)	{
					JOptionPane.showMessageDialog( window,
						"Name Already In Use.  Change Login Name",
						"Nick Error",JOptionPane.ERROR_MESSAGE );
					return false;
				}
				clientList= (DefaultListModel)in.
				   readObject();//获得用户信息列表
				clientID = clientList.getSize()-1;//获得客户端ID号
				return true;
			}
			else{
				JOptionPane.showMessageDialog(window,
				"Maximum User Limit  Reached. Server Rejected" +
				" Connection", "Connection Rejected",
               JOptionPane.ERROR_MESSAGE );
			}
		}
		catch( Exception e ){
        }		
		return false;
	}
	//关闭应用连接
	void shutDown() {
		disconnectFromServer( true );//断开连接
		listener = null;
		System.exit(0);//退出系统
	}	
	ChatClient(){
		connected = false;
		listener = new InputListener();
		window = new ClientInterface(this);
	}	
	public static void main(String args[]) 
		throws IOException{
		new ChatClient();
	}
}
