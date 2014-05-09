package sonyi.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class StartClient {
	public StartClient(Socket s) throws UnknownHostException, IOException{	
		new Thread(new ReceiveClientThread(s)).start();
		
	}
}

class ReceiveClientThread implements Runnable{
	private Socket s;
	public ReceiveClientThread(Socket s) {
		this.s = s;
	}
	public void run() {
		try {
			InputStream isIn = s.getInputStream();
			while(true){		
				byte[] buf = new byte[1024];
				int len = isIn.read(buf);
				String line = new String(buf,0,len);
				//System.out.println("client-----" + line);
				WindowClient.textArea1.append(line + "\r\n");
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}


class SendClient {
	SendClient(Socket s,String message) throws IOException{
		OutputStream osOut = s.getOutputStream();
		osOut.write(message.getBytes());
	}
}	


