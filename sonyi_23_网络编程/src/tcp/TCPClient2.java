package tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/*
�ͻ��˲��裺
	1������Socket���񣬲�ָ��Ҫ���ӵ������Ͷ˿ڡ�
	2����ȡSocket���е��������������д�������У�ͨ�����緢�͵�����ˡ�
	3����ȡSocket���е���������������˷��������ݻ�ȡ��������ӡ
	4���رտͷ�����Դ��
*/

class TCPClient2{
	public static void main(String[] args) throws UnknownHostException, IOException{
		//�����ͷ��˵�Socket����ָ��Ŀ�������Ͷ˿�
		Socket s = new Socket("192.168.188.1",10004);
		
		//Ϊ�˷������ݣ�Ӧ�û�ȡSocket���е������
		OutputStream out = s.getOutputStream();
		out.write("����ˣ����".getBytes());
		
		InputStream in = s.getInputStream();
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		System.out.println(new String(buf,0,len));
		
		s.close();
	}
}

