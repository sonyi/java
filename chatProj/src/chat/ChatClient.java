package chat;
import java.io.*;
import java.net.*;
import javax.swing.*;
//������������ͷ�����������
public class ChatClient {
	private boolean connected;//�Ƿ����ӱ�־	
	int serverSocketNumber;//������Ŀ
	String serverAddress;//��������ַ
	private Socket socket;//�˿ں�	
	String Name;//������
	private int clientID;	
	ObjectOutputStream out;//�����
	ObjectInputStream in;//������	
	DefaultListModel clientList;	
	private InputListener listener;//�����˿�
	ClientInterface window;	
	//�Խ�������Ϣ���л�Ӧ
	class InputListener extends Thread	{
		//�ṩ�ж�ѭ���ķ�ʽ
		boolean running = false;		
		public void run() {
			//һֱѭ��ֱ��Listenerֹͣ
			while( true ){
				if( running ){
					//������Ϣ���Ͳ�������Ӧ�ķ�ӳ
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
							//������µĳ�Ա����
							if(((UpdateList)serverMsg).requestType == true){
							clientList.addElement( ((UpdateList)serverMsg)
									.newClient );
							}
							//���г�Ա�˳�
							else {
							window.notifyUserLeft( ((UpdateList)serverMsg)
									.newClient );
                            clientList.removeElement(((UpdateList)serverMsg)
                            		.newClient);
							}
						}
						else if(serverMsg instanceof ServerShutDown) {
							disconnectFromServer( false );//�ӷ������Ͽ�����
							window.notifyDisconnect();
							JOptionPane.showMessageDialog( window,
							"Server Has Been Shut Down","Connection Error",
							JOptionPane.ERROR_MESSAGE );
						}
						else if(serverMsg instanceof KickedOutNotice){
							disconnectFromServer( false );//�ӷ������Ͽ�����
							window.notifyDisconnect();//�رմ���
							JOptionPane.showMessageDialog( window,
								"Server Kicked You   Out","Connection Error",
								JOptionPane.ERROR_MESSAGE );
						}
					}
					catch(ClassNotFoundException cnfe){
						JOptionPane.showMessageDialog( window, 
								"Class of a serialized  object cannot be found.", 
								"Termination Error", JOptionPane.ERROR_MESSAGE );
						shutDown();//�˳�����
					}
					catch( InvalidClassException ice ){
						JOptionPane.showMessageDialog(window, 
							"Something is wrong with a class used by " +
							"serialization.", "Termination Error",
                             JOptionPane.ERROR_MESSAGE );
						shutDown();//�˳�����
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
	//�����ݴ��û��˷��͵���������
	void sendPublicMessage( String userMsg ) 
	   throws IOException {
		Message msg = new Message();//�����µ���Ϣ
		msg.audience = true;
		msg.roomNumber = 0;//�����Һ���
		msg.senderId = clientID;
		msg.message = Name + " says > " + userMsg;		
		out.writeObject( msg );//������Ϣ
		out.flush();//�����Ϣ
	}	
	//ֻ�Ƕ���һ���û�������Ϣ
	void sendPrivateMessage(int recipient,
			String userMsg)  throws IOException	{
		Message msg = new Message();
		msg.audience = false;
		msg.recieverId = recipient;
		msg.senderId = clientID;//�趨�û���
		msg.message = Name + " says > " + userMsg;		
		out.writeObject( msg );
		out.flush();
	}	
	// ĳ���û�������һ���û�������̸
	void sendChatRequest( int recieverId )	{
		ChatRequest request = new ChatRequest();//�����������
		request.recieverId = recieverId;
		request.senderId = clientID;		
		try {
			out.writeObject( request );
		}
		catch( IOException io_e ){}
	}	
	//�����µ�������Ϣ
	void setConfiguration(String newServer, int newPort){
		try	{
			FileWriter configFile = new FileWriter("clientConfig.cfg");
            //�趨�����ļ�
			configFile.write( newServer.trim() + ";" + newPort + ";" );
			configFile.close();//�ر������ļ�
		}
		catch( IOException io_e ){
			JOptionPane.showMessageDialog(window,
			"Cannot Save Configuration  File","File Error",
				JOptionPane.ERROR_MESSAGE );
		}
	}	
	//���ļ���ȡ������Ϣ���������ڱ�����
	void getConfiguration()	{
		try	{
			char[] buffer = new char[255];			
			FileReader configFile = new FileReader("clientConfig.cfg");			
			configFile.read( buffer );//�ӻ������ж�����Ϣ
			serverAddress = String.copyValueOf( buffer );//��÷�������ַ
			String[] temp = serverAddress.split(";");			
			serverAddress = temp[0];
			serverSocketNumber = Integer.parseInt( temp[1] );			
		}
		catch( FileNotFoundException fnf_e ){
			JOptionPane.showMessageDialog( window,
				"Configuration File Not  Found, Using Defaults",
				"Configuration File Missing",
                   JOptionPane.ERROR_MESSAGE );			
			serverSocketNumber = 1665;//���÷������˿ں�
			serverAddress = "localhost";
		}
		catch(IOException io_e ){
			JOptionPane.showMessageDialog(window,
					"Error Reading  Configuration File, Using Defaults",
					"Configuration  Error",JOptionPane.ERROR_MESSAGE );			
			serverSocketNumber = 1665; //���÷������˿ں�
			serverAddress = "localhost";
		}			
	}	
	//�ӷ������Ͽ���reason = true Ϊ�û�ѡ��	reason = false Ϊ������ѡ��
	synchronized void disconnectFromServer(
			boolean reason){
		try	{
			if( connected )	{
				//ֹͣlistener�߳�
				listener.running = false;				
				if( reason = true) {
					out.writeObject(new LogOut());
					out.flush();
				}				
				out.close();//�ر������
				socket.close();//�ر��׽���				
				clientList.clear();
				connected = false;
			}
		}
		catch( IOException ex )
		{}
	}	
	//��ʼ���ӷ�����
	synchronized boolean connectToServer(){
		getConfiguration();		
		try	{
			InetAddress addr = InetAddress.getByName( 
					serverAddress );
             //��÷�������ַ
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
			return false;//���ش�����Ϣ
		}		
		try	{
			in = new ObjectInputStream(socket.
					getInputStream());//������
			out = new ObjectOutputStream(socket.
					getOutputStream() );//�����
		}
		catch(IOException e ){
			JOptionPane.showMessageDialog( window,
					"Cannot Create Data Stream, Closing Client...",
					"Data Stream Error",JOptionPane.ERROR_MESSAGE );
			try	{
				socket.close();//�ر��׽���
			}
			catch( IOException io_e ){}			
			return false;
		}
		
		if(!handShake())return false;
		listener.running = true;		
		//�ǵ�һ����������listener����
		if( listener.isAlive() == false){
			listener.start();
		}		
		connected = true;
		return true;
	}	
	//���ò�������
	private boolean handShake()	{
		try	{
			if(((ConnectionNotice)in.readObject()).status){
				out.writeObject( Name );//ͨ���������л�������Ϣ
				if(((ConnectionNotice)in.readObject())
						.status == false)	{
					JOptionPane.showMessageDialog( window,
						"Name Already In Use.  Change Login Name",
						"Nick Error",JOptionPane.ERROR_MESSAGE );
					return false;
				}
				clientList= (DefaultListModel)in.
				   readObject();//����û���Ϣ�б�
				clientID = clientList.getSize()-1;//��ÿͻ���ID��
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
	//�ر�Ӧ������
	void shutDown() {
		disconnectFromServer( true );//�Ͽ�����
		listener = null;
		System.exit(0);//�˳�ϵͳ
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
