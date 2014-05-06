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
		//1.ע�����
		try {
			ser = new ServerSocket(port);
			System.out.println("=========�������ѿ���========");
			while(true) {//����һֱ�ȴ�
				//2.�ȴ��ͻ�����
				Socket s = ser.accept();
				System.out.println(s);
				userList.add(s);//�ѿͻ��˴�ŵ�����
				//������д�߳�
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

	//���߳�(������Ϣ)
	private class ReadThread extends Thread {
		private Socket s;
		ReadThread(Socket s) {
			this.s = s;
		}
		
		public void run() {
			//InputStreamReader �ֽ���ת�ַ���
			BufferedReader br = null;
			try {
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				String line;
				while((line = br.readLine()) != null) {
					System.out.println(line);
					//ת��
					for(Socket ss:userList) {
						if(ss == s) {//ȡ������socket�ǵ�ǰ�ͻ���
							//�������Լ�
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
			System.out.println("��ǰ�ͻ�����" + userList.size());
			String line = input.nextLine();
			//Ⱥ��-�����еĿͻ��˷���Ϣ
			for(int i=0; i<userList.size(); i++) {
				getWriter(userList.get(i)).println("������:" + line);
				
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
