package Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TextClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s = new Socket("192.168.188.1",10006);
		BufferedReader buf = new BufferedReader(new FileReader("ChatDemo.java"));
		PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
		String line = null;
		while ((line = buf.readLine()) != null) {
			pw.println(line);
		}
		s.shutdownOutput();//�ͷ���������������������ѷ���˽������գ���ֹ�ȴ����룬��������
		
		BufferedReader b = new BufferedReader(new InputStreamReader(s.getInputStream()));
		System.out.println(b.readLine());
		
		buf.close();
		b.close();
		s.close();
	}

}
