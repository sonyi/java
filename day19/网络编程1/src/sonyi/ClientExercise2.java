package sonyi;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientExercise2 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s = new Socket("192.168.1.106",20001);
		
		
		new Thread(new ReadThread(s)).start();
		new Thread(new WriteClientThread(s)).start();	
	}
}

class WriteClientThread implements Runnable{
	private Socket s;
	WriteClientThread(Socket s){
		this.s = s;
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
				
				OutputStream osOut = s.getOutputStream();
				osOut.write(("¿Í»§¶ËËµ£º" + line).getBytes());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}	
}
