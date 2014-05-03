package tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
��ʾ������˽��տͷ�������ݣ�����ӡ�ڿ���̨��
	
����ˣ�
	1����������˵�Socket����ServerSocket();������һ���˿�
	2����ȡ���ӹ����Ŀͷ��˶���
		ͨ��ServerSocket��accept������û�����Ӿͻ�ȣ�
		�����������������ʽ�ġ�
	3���ͷ���������������ݣ���ô�����Ҫʹ�ö�Ӧ�Ŀͷ��˶���
		����ȡ���ÿͷ��˶���Ķ�ȡ������ȡ�����������ݣ�����ӡ�ڿ���̨��
	4���رշ����(��ѡ����).
*/

class TCPServer{
public static void main(String[] args) throws IOException{
	//���������Socket���񣬲�����һ���˿�
	ServerSocket ss = new ServerSocket(10003);
	
	//ͨ��accept������ȡ���ӹ����Ŀͷ��˶���
	Socket s = ss.accept();
	
	String ip = s.getInetAddress().getHostName();
	System.out.println(ip + "......connected");
	
	//��ȡ�ͷ��˷����������ݣ���ôҪʹ�ÿͷ��˶���Ķ�ȡ����ȡ����
	InputStream in = s.getInputStream();
	byte[] buf = new byte[1024];
	int len = in.read(buf);
	System.out.println(new String(buf,0,len));
	
	//�رտͷ���
	s.close();
	ss.close();//�رշ����(��ѡ����)
}
}
