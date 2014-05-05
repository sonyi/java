package sonyi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientExercise {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1",20000);
		
		
		PrintStream psOut = new PrintStream(socket.getOutputStream(),true);
		
		InputStream isIn = socket.getInputStream();
			
		
		while(true){
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String line = br.readLine();
			if("over".equals(line))
				break;
	
			psOut.println(line);
			socket.shutdownOutput();
			
		
			byte[] buf = new byte[1024];
			int len = 0;
			while((len = isIn.read(buf)) != -1){
				System.out.println(new String(buf,0,len));
			}
			br.close();
		}
	}
}

