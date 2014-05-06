package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s = new Socket("192.168.1.106",20002);
		PrintWriter pwOut = new PrintWriter(s.getOutputStream(),true);
		BufferedReader brIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		Scanner scanner = new Scanner(System.in);
		String line = null;
		System.out.println("��ӭ�����������Ϸ�����һ��1-10��������");
		while(true){
			line = null;
			while(true){		
				line = scanner.nextLine();//���ռ�������
				pwOut.println(line);//���ͼ������������
				String receive = brIn.readLine();//���շ������Ϣ
				System.out.println(receive);
				if(receive.contains("�¶���")){
					break;
				}	
			}
			System.out.println("�Ƿ������Ϸ?������Ϸ���䣺yes���˳���Ϸ�����룺no");
			line = scanner.nextLine();
			pwOut.println(line);
			if("no".equals(line)){
				break;
			}else {
				System.out.println("���¿�ʼ��Ϸ��������һ��1-10��������");
			}
		}	
		s.close();
		scanner.close();
	}
}
