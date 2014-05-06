package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(20002);
		Socket s = ss.accept();
		BufferedReader brIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		PrintWriter pwOut = new PrintWriter(s.getOutputStream(),true);
		
		while(true){
			int i = (int) (Math.random()*10 + 1);
			String line = null;
			while(true){
				line = brIn.readLine();
				if((i + "").equals(line)){
					pwOut.println("�¶��ˣ���������");
					break;
				}else {
					pwOut.println("�´��ˣ����������룡");
				}
			}
			line = brIn.readLine();
			if("no".equals(line)){
				break;
			}	
		}	
		s.close();
		ss.close();
	}
}
