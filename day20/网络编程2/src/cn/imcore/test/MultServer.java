package cn.imcore.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class MultServer {

	public static final int port = 8009;
	private ServerSocket ser = null;
	
	public ArrayList<Socket> userList = new ArrayList();
	
	public MultServer() {
		//1.注册服务
		try {
			ser = new ServerSocket(port);
			System.out.println("=========服务器已开启========");
			while(true) {//可以一直等待
				//2.等待客户连接
				Socket s = ser.accept();
				System.out.println(s);
				userList.add(s);//把客户端存放到容器
				//创建读写线程
				new ReadThread(s).start();
				new WriteThread().start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new MultServer();

	}

	//读线程(接收信息)
	private class ReadThread extends Thread {
		private Socket s;
		ReadThread(Socket s) {
			this.s = s;
		}
		
		public void run() {
			//InputStreamReader 字节流转字符流
			BufferedReader br = null;
			try {
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				String line;
				while((line = br.readLine()) != null) {
					System.out.println(line);
					//转发
					for(Socket ss:userList) {
						if(ss == s) {//取出来的socket是当前客户端
							//不发给自己
						}else {
							getWriter(ss).println(line);
						}
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//
	private class WriteThread extends Thread {
		Scanner input = new Scanner(System.in);
		public void run() {
			System.out.println("当前客户数：" + userList.size());
			String line = input.nextLine();
			//群发-给所有的客户端发信息
			for(int i=0; i<userList.size(); i++) {
				getWriter(userList.get(i)).println("服务器:" + line);
				
			}
		}
	} 
	//
	public PrintWriter getWriter(Socket s) {
		PrintWriter ps = null;
		try {
			ps = new PrintWriter(s.getOutputStream(), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ps;
	}
}
