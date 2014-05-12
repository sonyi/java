package sonyi.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

//启动客户端接收线程
public class StartClient {
	public StartClient(Socket s) throws UnknownHostException, IOException{	
		new Thread(new ReceiveClient(s)).start();
	}
}

//客户端接收线程
class ReceiveClient implements Runnable{
	private Socket s;
	public ReceiveClient(Socket s) {
		this.s = s;
	}
	public void run() {
		try {
			//信息接收流
			BufferedReader brIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
			while(true){	
				char info = (char)brIn.read();//读取信息流首字符，判断信息类型
				String line = brIn.readLine();//读取信息流内容
				
				if(info == '1'){//发送消息
					WindowClient.textMessage.append(line + "\r\n");	
				}
				
				if(info == '2' || info == '3'){//有新用户加入或退出，2为加入，3为退出
					String sub = line.substring(1, line.length()-1);
					String[] data = sub.split(",");
					WindowClient.user.clearSelection();
					WindowClient.user.setListData(data);
				}
				
				if(info == '4'){//服务端退出
					WindowClient.link.setText("连接");
					WindowClient.exit.setText("已退出");
					WindowClient.socket.close();
					WindowClient.socket = null;
					break;
				}
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}


class SendClient {//客户端发送信息类
	SendClient(Socket s,Object message,String info) throws IOException{	
		String messages = info + message;
		PrintWriter pwOut = new PrintWriter(s.getOutputStream(),true);
		pwOut.println(messages);
	}
}	


