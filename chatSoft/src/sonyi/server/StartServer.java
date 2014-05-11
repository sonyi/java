package sonyi.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;


public class StartServer implements Runnable{
	private int port;
	public static ArrayList<Socket> userList;
	public static Vector<String> userName = null;
	public StartServer(int port) throws IOException{
		this.port = port;		
	}

	@SuppressWarnings("resource")
	public void run() {
		ServerSocket ss = null;
		Socket s = null;
		userList = new ArrayList<Socket>();
		userName = new Vector<String>();
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
				
				String id = s.getInetAddress().getHostName();
				System.out.println(id + "-----------connected");
				System.out.println("当前客户端个数为：" + userList.size());
				//synchronized(this){
					new Thread(new ReceiveServer(s,userList,userName)).start();
				//}
					
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
	}
}



class ReceiveServer implements Runnable{
	private Socket socket;
	private ArrayList<Socket> userList;
	private Vector<String> userName;
	public ReceiveServer(Socket s,ArrayList<Socket> userList,Vector<String> userName) {
		this.socket = s;
		this.userList = userList;
		this.userName = userName;
	}
	
	public void run() {	
		try {
			BufferedReader brIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(true){		
				char info = (char)brIn.read();
				String line = brIn.readLine();
				if(info == '1'){//发送消息
					WindowServer.textMessage.append(line + "\r\n");
					
					System.out.println("userlist-----------" + userList.toString());
					new SendServer(userList, line, 1 + "");
				}
				if(info == '2'){//建立连接
					userName.add(line);
					WindowServer.user.setListData(userName);
					new SendServer(userList, userName,2 + "");
				}
				
				if(info == '3'){//退出连接
					userName.remove(line);
					userList.remove(socket);
					WindowServer.user.setListData(userName);
					
					new SendServer(userList, userName,3 + "");
					socket.close();
					break;
				}
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}


class SendServer {
	SendServer(ArrayList<Socket> userList,Object message,String info) throws IOException{
		String messages = info + message;
		PrintWriter pwOut = null;
		for(Socket s : userList){
			pwOut = new PrintWriter(s.getOutputStream(),true);
			pwOut.println(messages);
		}
	}
}	
