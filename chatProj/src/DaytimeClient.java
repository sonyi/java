import java.net.*;
import java.io.*;
public class DaytimeClient {
	public static void main(String[] args) {
		String hostname;
		if (args.length > 0) {
			hostname = args[0];
		}
		else {
			//�˵�ַΪ��ȡ��ȷʱ��ĵ�ַ
			hostname = "localhost";
		}
		try {
			Socket theSocket = new Socket(hostname, 13);//����׽���
			 //�õ�������
			InputStream timeStream = theSocket.getInputStream();           
			StringBuffer time = new StringBuffer();
			int c;
			while ((c = timeStream.read( )) != -1) time.append((char) c);
			String timeString = time.toString().trim( );//�õ�ʱ����Ϣ
			System.out.println("It is " + timeString + " at " + hostname);
		}
		catch (UnknownHostException e) {
			System.err.println(e);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
}