package Exercise;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/*
	Ŀ�ģ��ϴ�һ��ͼƬ
	�ͻ��ˣ�
		���裺
			1����������˵㡣
			2����ȡ�ͻ������е�ͼƬ����
			3��ͨ��Socket����������ݷ��͸������
			4����ȡ����˵ķ�����Ϣ��
			5���ر���Դ
 */
public class PicTCPClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s = new Socket("192.168.188.1",10007);
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("1.jpg"));
		BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream());
		byte[] buf = new byte[1024];
		System.out.println("Client--------0");
		while ((bis.read(buf)) != -1) {
			bos.write(buf,0,buf.length);
			bos.flush();
		}
		
		//���߷���������Ѿ�д��
		s.shutdownOutput();
		System.out.println("Client--------1");

		BufferedReader b = new BufferedReader(new InputStreamReader(s.getInputStream()));
		System.out.println(b.readLine());
		System.out.println("Client--------3");
		bis.close();
		s.close();
	}
}
