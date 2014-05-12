package sonyi.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

//��������˽��տͻ��˵��߳�
public class StartServer implements Runnable{
	private int port;
	public static ArrayList<Socket> userList = null;
	public static Vector<String> userName = null;
	public static ServerSocket ss = null;
	public static boolean flag = true;
	
	//����˿ں�
	public StartServer(int port) throws IOException{
		this.port = port;		
	}

	public void run() {
		Socket s = null;
		userList = new ArrayList<Socket>();//�ͻ��˶˿�����
		userName = new Vector<String>();//�û���������
		//System.out.println("���������");
		try {
			ss = new ServerSocket(port);//���������
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		while (flag) {//����ѭ�����ȴ����տͻ���
			try {	
				s = ss.accept();//���տͻ���
				userList.add(s);//���ͻ��˵�socket��ӵ�������
				
				//��ӡ�ͻ�����Ϣ
				String id = s.getInetAddress().getHostName();
				System.out.println(id + "-----------connected");
				System.out.println("��ǰ�ͻ��˸���Ϊ��" + userList.size());
				
				//������ͻ������Ӧ����Ϣ�����߳�
				new Thread(new ReceiveServer(s,userList,userName)).start();
		
			} catch (IOException e) {
				JOptionPane.showMessageDialog(WindowServer.window, "������˳���");
			}	
		}
	}
}

//�������Ϣ�����߳�
class ReceiveServer implements Runnable{
	private Socket socket;
	private ArrayList<Socket> userList;
	private Vector<String> userName;
	
	public ReceiveServer(Socket s,ArrayList<Socket> userList,Vector<String> userName) {
		this.socket = s;
		this.userList = userList;
		this.userName = userName;
	}
	
	public void run() {	
		try {
			//��ȡ��Ϣ��
			BufferedReader brIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(true){		
				char info = (char)brIn.read();//�ȶ�ȡ��Ϣ�������ַ������ж���Ϣ����
				String line = brIn.readLine();//��ȡ��Ϣ������Ϣ����
				
				if(info == '1'){//1�����յ�������Ϣ
					WindowServer.textMessage.append(line + "\r\n");//����Ϣ��ӵ�����������¼��
					//������Ϣ��ʾ����һ�У�Ҳ���ǹ�����������ĩβ����ʾ����һ���������Ϣ
					WindowServer.textMessage.setCaretPosition(WindowServer.textMessage.getText().length());
					new SendServer(userList, line, "1");//����Ϣת�����ͻ���
				}
				
				if(info == '2'){//2�������¿ͻ��˽�������
					userName.add(line);//���¿ͻ����û�����ӵ�������
					WindowServer.user.setListData(userName);//���·�����û��б�
					new SendServer(userList, userName, "2");//���û��б����ַ�������ʽ�����ͻ���
				}
				
				if(info == '3'){//3�������û����˳�����
					userName.remove(line);//�Ƴ����������˳��Ŀͻ����û���
					userList.remove(socket);//�Ƴ����������˳��Ŀͻ��˵�socket
					WindowServer.user.setListData(userName);//���·�����û��б�
					new SendServer(userList, userName, "3");//���û��б����ַ�������ʽ�����ͻ���
					socket.close();//�رոÿͻ��˵�socket
					break;//�����ÿͻ��˶��ڵ���Ϣ�����߳�
				}
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}

//����˷�����Ϣ
class SendServer {
	SendServer(ArrayList<Socket> userList,Object message,String info) throws IOException{
		String messages = info + message;//�����Ϣͷ���
		PrintWriter pwOut = null;
		for(Socket s : userList){//����Ϣ���͸�ÿ���ͻ���
			pwOut = new PrintWriter(s.getOutputStream(),true);
			pwOut.println(messages);
		}
	}
}	
