package cn.imcore.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MultClient {
	private Socket ct = null;
	private String cName;
	Scanner input = new Scanner(System.in);
	
	public MultClient() {
		//������IP,�������˿ں�
		try {
			//1.���ӷ�����
			ct = new Socket("127.0.0.1", 8009);
			System.out.println("�������û�����");
			cName = input.nextLine();
			System.out.println("======����������======");
			//2.������д�߳�
			new ReadThread(ct).start();
			new WriteThread(ct).start();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new MultClient();

	}

	//���߳�
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
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		//
		private class WriteThread extends Thread {
			Socket s;
			Scanner input = new Scanner(System.in);
			
			WriteThread(Socket s) {
				this.s = s;
			}
			
			public void run() {
				while(true) {//
					getWriter(s).println(cName + ":" + input.nextLine());
				}
			}
			
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
		//
}
