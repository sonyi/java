package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/*
	����
		����һ��Ӧ�ó������ڽ���UDPЭ�鴫������ݲ�����
		
	����UDP�Ľ��նˡ�
		
	˼·��
		1������UDPSocket����ͨ�������һ���˿ڣ���ʵ���Ǹ������������Ӧ�ó��������ֱ�ʶ��
			��������ȷ��Щ���ݹ�����Ӧ�ó�����Դ���
		2������һ�����ݰ�����ΪҪ�洢���յ����ֽ����ݣ���Ϊ���ݰ���������
			���๦�ܿ�����ȡ�ֽ������еĲ�ͬ������Ϣ��
		3��ͨ��Socket�����receive���������յ������ݴ����Ѷ���õ����ݰ��С�
		4��ͨ�����ݰ���������й��ܣ�����Щ��ͬ������ȡ������ӡ�ڿ���̨�ϡ�
		5���ر���Դ��
 */
public class UDPRece {
	public static void main(String[] args) throws IOException {
		//1������UDPSocket���񣬽����˵�
		DatagramSocket ds = new DatagramSocket(10000);
		
		
		//2���������ݰ������ڴ洢���ݡ�
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		
		//3��ͨ�������receive�������յ����ݴ������ݰ���
		ds.receive(dp);//����ʽ����
		
		//4��ͨ�����ݰ��ķ�����ȡ���е�����
		String ip = dp.getAddress().getHostAddress();
		String data = new String(dp.getData(),0,dp.getLength());
		int port = dp.getPort();
		System.out.println(ip + "::" + data + "::" + port);
		
		//5���ر���Դ
		ds.close();
	}

}
