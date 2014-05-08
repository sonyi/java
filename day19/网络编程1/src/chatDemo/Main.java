package chatDemo;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;



public class Main {
	public static void main(String[] args) {
		
		Socket s = null;
		try {
			s = new Socket("127.0.0.1",20001);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		new FrameDemo(s);
	}
}
