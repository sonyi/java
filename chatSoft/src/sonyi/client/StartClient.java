package sonyi.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
			BufferedReader brIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
			while(true){	
				char info = (char)brIn.read();
				String line = brIn.readLine();
				if(info == '1'){//发送消息
					WindowClient.textArea1.append(line + "\r\n");	
				}
				if(info == '2'){//有新用户加入
					String sub = line.substring(1, line.length()-1);
					String[] data = sub.split(",");
					WindowClient.user.clearSelection();
					WindowClient.user.setListData(data);
				}
				if(info == '3'){//有用户退出
					String sub = line.substring(1, line.length()-1);
					String[] data = sub.split(",");
					WindowClient.user.clearSelection();
					WindowClient.user.setListData(data);
				}
				if(info == '4'){//服务端退出
					s.close();
					break;
				}
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}


class SendClient {
	SendClient(Socket s,Object message,String info) throws IOException{	
		String messages = info + message;
		PrintWriter pwOut = new PrintWriter(s.getOutputStream(),true);
		pwOut.println(messages);
	}
}	


