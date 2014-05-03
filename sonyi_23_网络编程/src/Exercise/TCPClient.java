package Exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/*	
�������ͷ��ˣ�
		��Ȼ�ǲ����豸�ϵ����ݣ���ô�Ϳ���ʹ��IO������������IO�Ĳ���������˼��
		Դ������¼��
		Ŀ�ģ���������������Ҳ��������ı����ݣ�����ѡ���ַ���
		
		���裺
			1����������
			2����ȡ����¼��
			3�������ݷ��������
			4����ȡ����˷��صĴ�д����
			5���������ر���Դ
			�����ı����ݣ�����ʹ���ַ������в�����ͬʱ���Ч�ʣ����뻺�塣
 */
public class TCPClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//�����˿ڷ���
		Socket s = new Socket("192.168.188.1",10005);
		
		//��ȡ��������
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		
		//�������������
		BufferedWriter bufOut = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		
		//��������������
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String line = null;
		
		//���̶�ȡ���ݣ��������ݷ��ͳ�ȥ��Ȼ����շ�������
		while ((line = buf.readLine()) != null) {
			if("over".equals(line))
				break;
			//System.out.println(line);
			bufOut.write(line);//��ȡ�������Ի��з����գ������������з�
			//��ӻ��з������ᵼ�»�ȡ���ݵ�һ������һ�к���Ϊû�ж������з�����Ϊ��ȡ����δ��������һֱ���ڵȴ���
			bufOut.newLine();
			bufOut.flush();//��ȡ�����ݶ�����ڻ�����������ˢ�º���ܽ����ݷ��ͳ�ȥ
			System.out.println(bufIn.readLine());//���շ������ݣ��������ݴ�ӡ�ڿ���̨�ϡ�	
		}		
		buf.close();//�رռ�������
		s.close();//�رտͷ���
		
	}
}
