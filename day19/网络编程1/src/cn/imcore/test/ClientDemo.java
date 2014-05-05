package cn.imcore.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * �ͻ���
 */
public class ClientDemo {

	public ClientDemo() {
		Socket c = null;
		try {
			//1.���ӷ�����
			c = new Socket("127.0.0.1", 8001);
			
			//2.������Ϣ��������
			OutputStream out = c.getOutputStream();
			out.write("��ã���������".getBytes());
			
			//3.���շ��������ص���Ϣ
			InputStream in = c.getInputStream();
			byte[] b = new byte[1024];
			int len;
			while((len = in.read(b)) != -1) {
				System.out.println(new String(b,0,len));
				out.write("��ã����ǿͻ���".getBytes());
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(c != null) {
				try {
					c.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new ClientDemo();

	}

}
