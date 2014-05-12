package cn.imcore.talk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MultClient extends Thread{

	private Socket customer;
	private String ip;
	private int port;
	private String name;
	private PrintWriter pw;
	
	public MultClient(String ip, int port, String name) {
		this.ip = ip;
		this.port = port;
		this.name = name;
	}

	public void run() {
		try {
			//连接服务器
			customer = new Socket(ip, port);
			//发送
			pw = new PrintWriter(customer.getOutputStream(), true);
			pw.println(name);
			//创建接收子线程
			new ReadThread(customer).start();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
					if(str.indexOf("user@") != -1) {
						FrameClient.userNames.add(str.split("@")[1]);
						FrameClient.reFresh();
					} else {
						System.out.println(str);
						//写到聊天记录
						writeToHistory(str);
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	//==========发送
	public void sendMsg(String msg) {
		msg = name + ":" + msg;
		//发送到服务器
		pw.println(msg);
		//写到聊天记录
		writeToHistory(msg);
		
	}
	//
	public void writeToHistory(String msg) {
		if("".equals(FrameClient.history.getText())) {
			FrameClient.history.append(msg);
		} else {
			FrameClient.history.append("\n" + msg);
		}
	}
}
