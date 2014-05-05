package sonyi;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExercise {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(20000);
		Socket s = ss.accept();
		String id = s.getInetAddress().getHostName();
		System.out.println(id + "-----------connected");
//		while(true){
			InputStream isIn = s.getInputStream();
			PrintStream psOut = new PrintStream(s.getOutputStream(),true);
			
			byte[] buf = new byte[1024];
			int len = 0;
			
			System.out.println("sever----------------1");
			while((len = isIn.read(buf)) != -1){
				System.out.println(new String(buf,0,len));
				System.out.println("sever----------------2");
			}
			System.out.println("sever----------------3");
			psOut.println(" ’µΩ");
			System.out.println("sever----------------4");
		
//		}
		
	}

}
