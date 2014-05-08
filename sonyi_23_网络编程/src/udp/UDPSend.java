package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
	����
		ͨ��UDP���䷽ʽ����һ���������ݷ��ͳ�ȥ��
		
	����UDP�ķ��Ͷ�
	
	˼·��
		1������UDPSocket����
		2���ṩ���ݣ��������ݷ�װ�����ݰ��С�
		3��ͨ��Socket����ķ��͹��ܣ������ݰ�����ȥ
		4���ر���Դ��
 */ 
public class UDPSend {

	public static void main(String[] args) throws IOException {
		//1������UDP����ͨ��DatagramSocket����
		DatagramSocket ds = new DatagramSocket(8888);
		
		//2��ȷ�����ݣ�����װ�����ݰ�
		byte[] data = "upd ge men lai le".getBytes();
		DatagramPacket dp = new DatagramPacket(data,
				data.length,InetAddress.getByName("192.168.188.1"),10000);
		
		//ͨ��Socket���񣬽����е����ݰ����ͳ�ȥ��ͨ��send����
		ds.send(dp);
		
		//�ر���Դ
		ds.close();	
	}
}







