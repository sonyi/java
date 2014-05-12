package cn.imcore.talk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import cn.imcore.talk.MultClient.ReadThread;

public class MultServer extends Thread{
	private ServerSocket server;
	private int port;

	public MultServer(int port) {
		this.port = port;
	}

	//线程体
	public void run() {
		try {
			server = new ServerSocket(port);
			System.out.println("服务器已经启动。。。。");
			
			while(true) {
				//等待客户连接
				Socket ss = server.accept();
				//把客户放到容器
				BufferedReader br = new BufferedReader(new InputStreamReader(ss.getInputStream()));
				String name = br.readLine();
				FrameSever.userList.add(ss);
	//			System.out.println(name);
				FrameSever.userNames.add(name);
				FrameSever.reFresh();//刷新
				//发送客户端名称到其他客户端
				sendToClients(null, "user@"+FrameSever.userNames);
				//创建接收子线程
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
	
	//内容写到聊天记录
	public void writeToTextArea(String msg) {
		if("".equals(FrameSever.history.getText())) {
			FrameSever.history.append(msg);
		} else {
			FrameSever.history.append("\n" + msg);
		}
	}
	//================接收子线程
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
						if("88".equals(str)) {
							//把当前用户从用户列表中除去
							
						}
						//转发客户信息
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
		//===========群发
		
		public void sendToClients(Socket ss, String msg) {
			
			//发送给客户端
			for(int i=0; i<FrameSever.userList.size(); i++) {
				//用户的Socket
				Socket user = FrameSever.userList.get(i);
				if(user != ss) {//不能转发给自己
					try {
						//发送信息
						new PrintWriter(user.getOutputStream(), true).println(msg);
					} catch (IOException e) {
						
					}
				}
			}
			//写到自己当前的聊天记录
			if(msg.indexOf("user@") != -1){
				//
			} else {
				writeToTextArea(msg);
			}
		}
		
		public void close() {
			for(int i=0; i<FrameSever.userList.size(); i++) {
				try {
					FrameSever.userList.get(i).close();
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
