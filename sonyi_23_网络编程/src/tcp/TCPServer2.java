package tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
��ʾ��TCP�Ĵ��䣬�����ͷ��˺ͷ���˵Ļ��á�

���󣺿ͷ��˸�����˷������ݣ�����˽ӵ����ݺ󣬸��ͷ��˷�����Ϣ

	
����ˣ�
	1����������˵�Socket����ServerSocket();������һ���˿�
	2����ȡ���ӹ����Ŀͷ��˶���
		ͨ��ServerSocket��accept������û�����Ӿͻ�ȣ�
		�����������������ʽ�ġ�
	3���ͷ���������������ݣ���ô�����Ҫʹ�ö�Ӧ�Ŀͷ��˶���
		����ȡ���ÿͷ��˶���Ķ�ȡ������ȡ�����������ݣ�����ӡ�ڿ���̨��
	4���رշ����(��ѡ����).
*/

class TCPServer2{
public static void main(String[] args) throws IOException, InterruptedException{
	//���������Socket���񣬲�����һ���˿�
	ServerSocket ss = new ServerSocket(10004);
	
	//ͨ��accept������ȡ���ӹ����Ŀͷ��˶���
	Socket s = ss.accept();
	
	String ip = s.getInetAddress().getHostName();
	System.out.println(ip + "......connected");
	
	//��ȡ�ͷ��˷����������ݣ���ôҪʹ�ÿͷ��˶���Ķ�ȡ����ȡ����
	InputStream in = s.getInputStream();
	byte[] buf = new byte[1024];
	int len = in.read(buf);
	System.out.println(new String(buf,0,len));
	
	OutputStream out = s.getOutputStream();
	Thread.sleep(2000);
	out.write("�����յ�����Ҳ��".getBytes());
	
	//�رտͷ���
	s.close();
	ss.close();//�رշ����(��ѡ����)
}
}
