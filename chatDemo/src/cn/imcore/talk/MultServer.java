package cn.imcore.talk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;

import cn.imcore.talk.MultClient.ReadThread;

public class MultServer extends Thread{
	private ServerSocket server;
	private int port;

	public MultServer(int port) {
		this.port = port;
	}

	//�߳���
	public void run() {
		try {
			server = new ServerSocket(port);
			System.out.println("�������Ѿ�������������");
			
			while(true) {
				//�ȴ��ͻ�����
				Socket ss = server.accept();
				//�ѿͻ��ŵ�����
				BufferedReader br = new BufferedReader(new InputStreamReader(ss.getInputStream()));
				String name = br.readLine();
//				FrameSever.userList.add(ss);
				FrameSever.userList.add(new User(ss, name));
	//			System.out.println(name);
				FrameSever.userNames.add(name);
				FrameSever.reFresh();//ˢ��
				//���Ϳͻ������Ƶ������ͻ���
				sendToClients(null, "user@"+FrameSever.userNames);
				//�����������߳�
				new ReadThread(ss).start();
			}
		} catch (IOException e) {
			if(server != null) {
				try {
					server.close();
				} catch (IOException e1) {
					
				}
			}
		}
	}
	
	//����д�������¼
	public void writeToTextArea(String msg) {
		if("".equals(FrameSever.history.getText())) {
			FrameSever.history.append(msg);
		} else {
			FrameSever.history.append("\n" + msg);
		}
	}
	//================�������߳�
		class ReadThread extends Thread {
			private Socket ss;
			private BufferedReader read;
			
			ReadThread(Socket ss) {
				this.ss = ss;
			}
			
			public void run() {
				try {
					read = new BufferedReader(new InputStreamReader(ss.getInputStream()));
					String str;
					while((str=read.readLine()) != null) {
						System.out.println(str);
						if("88".equals(str.substring(str.indexOf(":")+1, str.length()))) {
							//�ѵ�ǰ�û����û��б��г�ȥ
							Iterator it = FrameSever.userList.iterator();
							FrameSever.userNames.clear();
							while(it.hasNext()) {
								User user = (User) it.next();
								if(user.getCus() == ss) {
									it.remove();//ɾ����ǰ�û�
								} else {
									FrameSever.userNames.add(user.getName());
									
								}
							}
							System.out.println(FrameSever.userNames);
							FrameSever.reFresh();//ˢ��
							//���Ϳͻ������Ƶ������ͻ���
							sendToClients(null, "user@"+FrameSever.userNames);
						}
						//ת���ͻ���Ϣ
						sendToClients(ss, str);
						
					}
				} catch (IOException e) {
					try {
						read.close();
					} catch (IOException e1) {
						
					}
				}
			}
			
		}
		//===========Ⱥ��
		
		public void sendToClients(Socket ss, String msg) {
			
			//���͸��ͻ���
			for(int i=0; i<FrameSever.userList.size(); i++) {
				//�û���Socket
//				Socket user = FrameSever.userList.get(i);
				User user = FrameSever.userList.get(i);
				
				if(user.getCus() != ss) {//����ת�����Լ�
					try {
						//������Ϣ
						new PrintWriter(user.getCus().getOutputStream(), true).println(msg);
					} catch (IOException e) {
						
					}
				}
			}
			//д���Լ���ǰ�������¼
			if(msg.indexOf("user@") != -1){
				//
			} else {
				writeToTextArea(msg);
			}
		}
		
		public void close() {
			for(int i=0; i<FrameSever.userList.size(); i++) {
				try {
					User user = FrameSever.userList.get(i);
					user.getCus().close();
				} catch (IOException e) {
					
				}
			}
			FrameSever.userList.clear();
			try {
				server.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
}
