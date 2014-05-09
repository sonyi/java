package sonyi.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Set;
import java.util.Vector;


public class StartServer implements Runnable{
	private int port;
	public static ArrayList<Socket> userList;
	public static Vector<String> nameSet = null;
	public StartServer(int port) throws IOException{
		this.port = port;		
	}

	public void run() {
		ServerSocket ss = null;
		Socket s = null;
		userList = new ArrayList<Socket>();
		System.out.println("启动服务端");
		try {
			ss = new ServerSocket(port);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		while (true) {
			try {	
				s = ss.accept();
				userList.add(s);
				
//				InputStream isIn = s.getInputStream();
//				byte[] buf = new byte[1024];
//				int len = isIn.read(buf);
//				String line = new String(buf,0,len);
//				nameSet.add(line);
				
				
				String id = s.getInetAddress().getHostName();
				System.out.println(id + "-----------connected");
				System.out.println("当前客户端个数为：" + userList.size());
				
				new Thread(new ReceiveServer(s,userList)).start();	
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
	}
}



class ReceiveServer implements Runnable{
	private Socket socket;
	private ArrayList<Socket> userList;
	public ReceiveServer(Socket s,ArrayList<Socket> userList) {
		this.socket = s;
		this.userList = userList;
	}
	
	public void run() {	
		try {
			InputStream isIn = socket.getInputStream();
			while(true){	
				byte[] buf = new byte[1024];
				int len = isIn.read(buf);
				String line = new String(buf,0,len);
				System.out.println(line);
				WindowServer.textMessage.append(line + "\r\n");
				for(Socket s : userList){
					OutputStream osOut = s.getOutputStream();
					osOut.write((line).getBytes());
				}	
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}

class SendServer {
	SendServer(ArrayList<Socket> userList,String message){
		for(Socket s : userList){
			OutputStream osOut = null;
			try {
				osOut = s.getOutputStream();
				osOut.write((message).getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
	}
}	
