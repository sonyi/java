package cn.imcore.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
/**
 * ��Ϸ����  
 * 1.����ͻ��˽�������ô��������Ҳ����
 * 2.�ͻ���Ҫ�����Ļ�������������������ÿͻ��˼�����
 * @author user
 *
 */
public class NumGameServer {
	ServerSocket ser = null;
	private int n;
	public NumGameServer() {
		//������һ�������
		Random r = new Random();
		n = r.nextInt(20);
		System.out.println("ϵͳ�����������Ϊ��" + n);
		
		//1.ע�����
		try {
			ser = new ServerSocket(8003);
			Socket s = ser.accept();//���տͻ�������
			//��
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			//д
			PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
			System.out.println(br.readLine());//�Ƚ��տͻ���Ϣ
			pw.println("������0-20֮������֣�");
			
			String line;
			while((line=br.readLine()) != null) {
				if(line.equals(String.valueOf(n))) {
					pw.println("��ϲ�����ˣ���Ϸ������");
				} else {
					pw.println("������ˣ�������¡���������");
				}
			}
		} catch (IOException e) {

		} finally {
			if(ser != null) {
				try {
					ser.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		new NumGameServer();

	}

}
