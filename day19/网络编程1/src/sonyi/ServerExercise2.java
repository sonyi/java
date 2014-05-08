package sonyi;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ServerExercise2 {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(20001);
		ArrayList<Socket> userList = new ArrayList<Socket>();
		//new Thread(new WriteServerThread(userList)).start();
		while (true) {
			Socket s = ss.accept();
			userList.add(s);
			String id = s.getInetAddress().getHostName();
			System.out.println(id + "-----------connected");
			System.out.println("当前客户端个数为：" + userList.size());
			new Thread(new ReadThread(s,userList)).start();	
		}
					
	}
}

class ReadThread implements Runnable{
	private Socket socket;
	private ArrayList<Socket> userList;
	public ReadThread(Socket s,ArrayList<Socket> userList) {
		this.socket = s;
		this.userList = userList;
	}
	
	@Override
	public void run() {	
		try {
			InputStream isIn = socket.getInputStream();
			while(true){	
				byte[] buf = new byte[1024];
				int len = isIn.read(buf);
				String line = new String(buf,0,len);
				System.out.println(line);
				
				for(Socket s : userList){
//					if(socket==s)
//						continue;
					OutputStream osOut = s.getOutputStream();
					osOut.write((line).getBytes());
				}
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}



class WriteServerThread implements Runnable{
	private ArrayList<Socket> userList;
	WriteServerThread(ArrayList<Socket> userList){
		this.userList = userList;
	}
	
	@Override
	public void run() {
		try {
			while(true){
				Scanner input = new Scanner(System.in);
				String line = input.nextLine();
				if ("over".equals(line)) {
					System.exit(0);
				}
				
				for(int i = 0; i < userList.size(); i++){
					OutputStream osOut = userList.get(i).getOutputStream();
					osOut.write(("服务端说：" + line).getBytes());
				}	
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}	
}