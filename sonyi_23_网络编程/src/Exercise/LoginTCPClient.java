package Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/*
	��ϰ��
		�ͻ���ͨ�����������û���������˶�����û�������У�顣
		������û������ڣ��ڷ������ʾxxx���ѵ��룬�����û�����ʾxxx����ӭ����
		������û������ڣ��ڷ������ʾxxx�����Ե��룬���ڿͻ�����ʾxxx�����û�������
		���͵������Ρ�
 */
public class LoginTCPClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s = new Socket("192.168.188.1",10008);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pwOut = new PrintWriter(s.getOutputStream(),true);
		BufferedReader bfIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		for(int i = 0; i < 3 ; i++){
			String name = br.readLine();
			if(name == null)
				break;
			pwOut.println(name);
			String line = bfIn.readLine();
			System.out.println(name + ":" + line);
			if(line.contains("��ӭ"))
				break;
		}
		br.close();
		s.close();	
	}
}





