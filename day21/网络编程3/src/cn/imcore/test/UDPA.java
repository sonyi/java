package cn.imcore.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
/**
 * ��������
 * @author user
 *
 */
public class UDPA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//UDP����
		DatagramSocket ser = null;
		try {
			ser = new DatagramSocket(8000);
			while(true) {
				byte[] buf = new byte[1024];//��ſͻ��˷���������Ϣ
				//���ݰ�
				DatagramPacket p = new DatagramPacket(buf, 1024);
				ser.receive(p);//�������ݰ�
				
				String temp = new String(buf,0,p.getLength());
				System.out.println(temp);
				if(temp.equals("bye")) {
					break;
				}
			}
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(ser != null) {
				ser.close();
			}
		}

	}

}
