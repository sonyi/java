package cn.imcore.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
/**
 * ��Ϸ���� 
 * 1.�رտͻ��� 
 * 2.����
 */
public class NumGameClient {
	Socket ss;
	public NumGameClient() {
		Scanner input = new Scanner(System.in);
		try {
			ss = new Socket("127.0.0.1", 8003);
			//��
			BufferedReader br = new BufferedReader(new InputStreamReader(ss.getInputStream()));
			//д
			PrintWriter pw = new PrintWriter(ss.getOutputStream(), true);
			//
			pw.println("��Ҫ��ʼ�������ˡ�������");//
			
			String line;
			while((line=br.readLine()) != null) {
				System.out.println(line);
				pw.println(input.nextLine());//д����
			}
		} catch (UnknownHostException e) {
			
		} catch (IOException e) {
			
		} finally {
			if(ss != null) {
				try {
					ss.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new NumGameClient();

	}

}
