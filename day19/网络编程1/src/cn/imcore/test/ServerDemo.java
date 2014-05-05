package cn.imcore.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * ��������
 * һ��һ��ģʽ
 * @author user
 *
 */
public class ServerDemo {

	public ServerDemo() {
		//1.��ע�����
		ServerSocket ser = null;
		try {
			ser = new ServerSocket(8001);
			
			//2.�ȴ��ͻ�����
			Socket s = ser.accept(); //s ���ǵ�ǰ�ͻ��˵����ö���
			System.out.println(s);//��ӡ�ͻ���
			
			//4.������Ϣ���ͻ���
			OutputStream out = s.getOutputStream();
			
			
			//3.���տͻ�����Ϣ
			InputStream in = s.getInputStream();
			byte[] b = new byte[1024];
			int len;
			while((len = in.read(b)) != -1) {
				System.out.println(new String(b,0,len));
				out.write("��ã����Ƿ�������".getBytes());
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		new ServerDemo();

	}

}
