package Exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
	����
		����һ���ı�ת�����������ͷ��˸�����˷����ı�������˻Ὣ�ı�ת�ɴ�д�ٷ��ظ��ͷ��ˡ�
		���ҿͷ��˿��Բ��ϵĽ����ı�ת�������ͷ�������overʱ��ת��������
		
	����������ˣ�
		Դ��Socket��ȡ��
		Ŀ�ģ�Socket�����
		�����ı���װ���¡�
		
	��������
		�ͷ��˺ͷ���˶���Ī���ĵȴ�������Ϊʲô�أ�
		��Ϊ�ͷ��˺ͷ���˶�������ʽ��������Щ����û�ж�ȡ��������ǣ���ô��һֱ��
		���������˶��ڵȴ���
		
 */
public class TCPServer {
	public static void main(String[] args) throws IOException {
		//���������
		ServerSocket ss = new ServerSocket(10005);
		Socket s = ss.accept();//�������Ӷ˿�
		
		//�����Ƿ����ӳɹ�
		String id = s.getInetAddress().getHostName();
		System.out.println(id + "..............connected");
		
		//��������������
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		//�������������
		BufferedWriter bufOut = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		String line = null;
		//ѭ����ȡ����
		while ((line = bufIn.readLine()) != null) {
			System.out.println(line);
			//ע�������жϽ�����䣬����ͷ���ѭ�������رպ󣬸�ѭ��Ҳ���Զ�����
			bufOut.write(line.toUpperCase());//����ȡ������ת���ɴ�д������
			//��ӻ��з������ᵼ�»�ȡ���ݵ�һ������һ�к���Ϊû�ж������з�����Ϊ��ȡ����δ��������һֱ���ڵȴ���
			bufOut.newLine();
			bufOut.flush();//��ȡ�����ݶ�����ڻ�����������ˢ�º���ܽ����ݷ��ͳ�ȥ
		}
		ss.close();//�رշ����
	}
}
