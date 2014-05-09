package chat;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
//��������������������
public class ChatServer {
	int serverPort;
	int serverLimit;
	ServerSocket server;	
	int onlineUsers;	
	//���е��û�����
	Vector<ChatHandler> handlers;	
	ServerInterface window;
	//ÿһ���û���
	public class ChatHandler implements Runnable{
		protected ClientInfo clientInfo = new ClientInfo();		
		protected Socket socket;
		protected ObjectInputStream in;
		protected ObjectOutputStream out;		
		//ָ�������������û����߳�
		protected Thread listener;
		public ChatHandler(int clientID, Socket socket)	{
			clientInfo.clientId = clientID;
			this.socket = socket;
			//onlineUsers = 0;
		}		
		//���ò���
		protected boolean handShake(){
			try	{
				clientInfo.clientName = (String)in.readObject();
				if( window.clientList.size()>0 &&
						window.clientList.indexOf( 
								clientInfo.clientName )
						!= -1 ){
					try	{
						ConnectionNotice status = new 
						ConnectionNotice();
						status.status = false;
						out.writeObject( status );
						out.flush();
						socket.close();
						return false;
					}
					catch( IOException w ){}
				}				
				try	{
					ConnectionNotice status = new ConnectionNotice();
					status.status = true;
					out.writeObject( status );
				}
				catch( IOException w){}				
				//���û������б��У������б��ظ��û�
				window.clientList.addElement(clientInfo.clientName);
				out.writeObject(window.clientList);				
				//֪ͨ���б���û������û�����
				//������Ӧ��Э�鲢�㲥
				UpdateList newClient = new UpdateList();
				newClient.requestType = true;
				newClient.newClient = clientInfo.clientName;
				broadcast( newClient );				
				onlineUsers++;
			}
			catch( Exception e ){}
			return true;
		}
		
		public synchronized void start(){
			if (listener == null){
				try	{
					out = new ObjectOutputStream(
							socket.getOutputStream() );
					in = new ObjectInputStream(
							socket.getInputStream());					
					ConnectionNotice status = new ConnectionNotice();					
					if ( onlineUsers >= serverLimit ){
						/*server.window.taMessages.append(
						onlineUsers+" " + 
						ChatHandler client = (ChatHandler)
						handlers.elementAt( onlineUsers-1 );*/
						try	{
							status.status = false;
							out.writeObject( status );
							out.flush();
							socket.close();
							return;
						}
						catch(IOException w){}
					}					
					try{
						status.status = true;
						out.writeObject(status);
					}
					catch( IOException w ){}					
					if( !handShake() )
						return;					
					//�����µ��̣߳������� ���߳�
					listener = new Thread( this );
					listener.start();
				}				
				catch( IOException ignored ){}
			}
		}		
		public synchronized void stop()	{
			if ( listener != null )	{
				try	{
					listener.interrupt();
					listener = null;					
					//֪ͨ���б���û����û����뿪
					handlers.removeElement( this );
					window.clientList.removeElement(
							clientInfo.clientName );
					UpdateList newClient = new UpdateList();
					newClient.requestType = false;
					newClient.newClient = clientInfo.clientName;
					broadcast( newClient );					
					//�ر��׽��֣�����ʾ�ڴ�����
					out.close();
					socket.close();
					window.taMessages.append(
						"Connection to client " + 
						clientInfo.clientId + 
						" closed...\n" );
				}
				catch( IOException io_ex ){
					JOptionPane.showMessageDialog( window, 
					"Error closing connection to client",
					"Termination Error", 
						JOptionPane.ERROR_MESSAGE );
				}
			}//if
		}//func		
	public void run(){
		try	{
			handlers.addElement( this );				
				//�����ɴ˿ͻ�������������
			while ( true )	{
				try	{
					Object clientMsg = in.readObject();						
					if( clientMsg instanceof Message )	{
						//����ǹ�����Ϣ������й㲥
						if(((Message)clientMsg).audience
								== true ){
							broadcast( clientMsg );
						}
						else {//˽����Ϣ
						//ȷ�����ն�
								//1) ��ý��ն˵�ID
								//2) �����Ӧ������
								//3) ͨ�������������Ϣ
						((ChatHandler)(handlers.elementAt((
							(Message)clientMsg).recieverId))).out.
								writeObject(clientMsg);
						}
					}
					else if( clientMsg instanceof ChatRequest )	{
					//֪ͨ��Ӧ�Ľ��նˣ����û�Ҫ����һ���Ի�
					((ChatHandler)(handlers.elementAt((
						(ChatRequest)clientMsg).recieverId))).out.
							writeObject(clientMsg);
					}
					else if( clientMsg instanceof LogOut ){
						onlineUsers--;
						break;
					}
					else{
						//���յ�δ������Ϣ
						System.out.println( clientMsg );
					}
				}
					catch( ClassNotFoundException cnfe ){
						JOptionPane.showMessageDialog(window, 
							"Class of a serialized object " +
							"cannot be found.",
							"Termination Error", JOptionPane
							.ERROR_MESSAGE );
						break;
					}
					catch( InvalidClassException ice ){
						JOptionPane.showMessageDialog(window, 
							"Something is wrong with a class " +
							"used by serialization.",
							"Termination Error", JOptionPane.
							ERROR_MESSAGE );
						break;
					}
					catch( StreamCorruptedException sce ){
						JOptionPane.showMessageDialog(window, 
							"Control information in the stream " +
							"is inconsistent.",
							"Termination Error", JOptionPane.
							ERROR_MESSAGE );
						break;
					}
					catch( OptionalDataException ode ){
						JOptionPane.showMessageDialog(window,
							"Primitive data was found in the " +
							"stream instead of objects.", 
							"Termination Error", JOptionPane.
							ERROR_MESSAGE );
						break;
					}
					catch( IOException ioe)	{
						//JOptionPane.showMessageDialog( null, 
						//"Any of the usual Input/Output related
						//exceptions.", "Termination Error", 
						//JOptionPane.ERROR_MESSAGE );
						break;
					}
				}
			}
			catch ( Exception ignored )	{}
			finally	{
				stop();
			}
		}	
		//�㲥��Ϣ�����е��û�
		protected void broadcast( Object clientMsg ){
			//������Ҫ������
			synchronized ( handlers ){
				Enumeration<ChatHandler> enums = 
					handlers.elements();				
				//Loop through all the clients
				while(enums.hasMoreElements()){
					ChatHandler handler = (ChatHandler)
					   enums.nextElement();
					try	{
						handler.out.writeObject( clientMsg );
						out.flush();
					}
					catch ( IOException ex ){
						handler.stop();
					}
				}
			}
		}	
	}
	//�������Կͻ��˵���������
	protected void listenForClients(ServerSocket server){
		window.taMessages.append
		("Listening For Connections...\n\n" );
		int clientID = 0;		
		while ( true ){
			try	{
				//�����׽��֡�
				Socket client = server.accept();
				ChatHandler handler = new ChatHandler(
					++clientID, client );
				window.taMessages.append("Connection accepted: "+
						clientID + "\n" );
				handler.start();
			}
			catch( IOException io_ex ){
				JOptionPane.showMessageDialog(window,
					"Cannot Setup Connection","Client " +
							"Connection Error",
						JOptionPane.ERROR_MESSAGE );
			}
		}
	}	
	protected void shutDown(){
		Enumeration<ChatHandler> enums = handlers.elements();
		ServerShutDown shutdown = new ServerShutDown();		
		synchronized(handlers){
			//�ر����е�����
			while (enums.hasMoreElements())	{
				try	{
				 ((ChatHandler)(handlers.firstElement()))
					.out.writeObject(shutdown);
				}
				catch( Exception e ){}				
				((ChatHandler)(handlers.firstElement())).stop();
			}
		}
		System.exit(0);
	}	
	//���µ�������Ϣ����
	protected  synchronized void setConfiguration(int newPort,
		int newLimit )	{
		try	{
			FileWriter configFile = new FileWriter(
					"serverConfig.cfg");
			//configFile.write( newPort );
			configFile.write(newPort + ";"+ newLimit+";" );
			//configFile.write( newLimit );
			configFile.close();
			serverLimit = newLimit;
		}
		catch( IOException io_e ){
			JOptionPane.showMessageDialog(
				window,"Cannot Save Configuration File",
				"File Error",JOptionPane.ERROR_MESSAGE );
		}
	}	
	protected synchronized void getConfiguration(){
		try	{
			char[] buffer = new char[15];			
			FileReader configFile = new FileReader(
					"serverConfig.cfg");
			configFile.read(buffer);			
			//String[] temp = ( String.copyValueOf( buffer ) )
			//.split(";");
			String value = String.copyValueOf( buffer );
			String[] temp = value.split(";");			
			//system.out.println(temp[0]);
			//system.out.println(temp[1]);
			//serverPort = Integer.parseInt( temp[0] );
			serverPort = Integer.parseInt(temp[0]);
			//configFile.read( buffer );
			serverLimit = Integer.parseInt(temp[1]);		
			configFile.close();
		}
		catch( FileNotFoundException fnf_e ){
			JOptionPane.showMessageDialog(null,
			"Configuration File Not Found, Using Defaults",
				"Configuration File Missing",JOptionPane.
				ERROR_MESSAGE);
			serverPort = 1665;
			serverLimit = 20;
		}
		catch( IOException io_e ){
			JOptionPane.showMessageDialog(null,
			"Error Reading Configuration File, Using Defaults",
				"Configuration Error",JOptionPane.ERROR_MESSAGE );			
			serverPort = 1665;
			serverLimit = 20;
		}			
	}
	ChatServer(){
		getConfiguration();
		onlineUsers=0;
		try	{
			//���������ﶨ���׽�����
			server = new ServerSocket(serverPort);
			handlers = new Vector<ChatHandler>();
			window = new ServerInterface(this);
			listenForClients(server);
		}
		catch(IOException io_e){
			JOptionPane.showMessageDialog(null,
			"Cannot Start Server","ServerSocket Error",
				JOptionPane.ERROR_MESSAGE );
			System.exit(0);
		}
		finally	{
			try	{
				if( server != null )
					server.close();
			}
			catch( IOException e ){}	
		}
	}
	public static void main( String[] args ) 
	   throws IOException {
		new ChatServer();
	}	
}
