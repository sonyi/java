package tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/*
�ͻ��ˣ�
	ͨ������Socket���󣬷����ڸö�����ʱ���Ϳ���ȥ����ָ��������
	��ΪTCP���������ӵģ������ڽ���Socket����ʱ����Ҫ�з���˵Ĵ��ڣ�
	�����ӳɹ����γ�ͨ·���ڸ�ͨ���������ݵĴ��䡣
	
���裺
	1������Socket���񣬲�ָ��Ҫ���ӵ������Ͷ˿ڡ�
	
*/

class TCPClient{
	public static void main(String[] args) throws UnknownHostException, IOException{
		//�����ͷ��˵�Socket����ָ��Ŀ�������Ͷ˿�
		Socket s = new Socket("192.168.188.1",10003);
		
		//Ϊ�˷������ݣ�Ӧ�û�ȡSocket���е������
		OutputStream out = s.getOutputStream();
		out.write("TCP ge men lai le".getBytes());
		s.close();
	}
}

