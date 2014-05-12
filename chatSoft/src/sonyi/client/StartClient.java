package sonyi.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

//�����ͻ��˽����߳�
public class StartClient {
	public StartClient(Socket s) throws UnknownHostException, IOException{	
		new Thread(new ReceiveClient(s)).start();
	}
}

//�ͻ��˽����߳�
class ReceiveClient implements Runnable{
	private Socket s;
	public ReceiveClient(Socket s) {
		this.s = s;
	}
	public void run() {
		try {
			//��Ϣ������
			BufferedReader brIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
			while(true){	
				char info = (char)brIn.read();//��ȡ��Ϣ�����ַ����ж���Ϣ����
				String line = brIn.readLine();//��ȡ��Ϣ������
				
				if(info == '1'){//������Ϣ
					WindowClient.textMessage.append(line + "\r\n");	
				}
				
				if(info == '2' || info == '3'){//�����û�������˳���2Ϊ���룬3Ϊ�˳�
					String sub = line.substring(1, line.length()-1);
					String[] data = sub.split(",");
					WindowClient.user.clearSelection();
					WindowClient.user.setListData(data);
				}
				
				if(info == '4'){//������˳�
					WindowClient.link.setText("����");
					WindowClient.exit.setText("���˳�");
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


class SendClient {//�ͻ��˷�����Ϣ��
	SendClient(Socket s,Object message,String info) throws IOException{	
		String messages = info + message;
		PrintWriter pwOut = new PrintWriter(s.getOutputStream(),true);
		pwOut.println(messages);
	}
}	


