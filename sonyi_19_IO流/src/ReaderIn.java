import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
	��ȡ����¼��
		System.out:��Ӧ���Ǳ�׼������豸������̨
		System.in:��Ӧ���Ǳ�׼�����豸������
		
	����
		ͨ������¼�����ݣ���¼��һ�����ݺ󣬾ͽ��������ݽ��д�ӡ��
		���¼���������over����ôֹͣ¼��
		
	�������Ļ������ɣ�
		��ʹ��ľ���������ܶ࣬��֪��������һ����
		ͨ��������ȷ����ɣ�
			1����ȷԴ��Ŀ�ġ�
				Դ����������InputStream   Reader
				Ŀ�ģ�������� OutputStream   Writer.
			2�������������Ƿ��Ǵ��ı���
				�ǣ��ַ���
				���ǣ��ֽ���
			3������ϵ��ȷ������ȷҪʹ���ĸ�����Ķ���
				ͨ���豸���������֣�
					Դ�豸���ڴ棬���̣�Ӳ��
					Ŀ���豸���ڴ棬Ӳ�̣�����̨
 */
public class ReaderIn {
	public static void main(String[] args) {
		BufferedReader br = null;
		BufferedWriter bw = null;	
		try {
			//���̵����д��
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			String line = null;
			while ((line = br.readLine()) != null) {
				if("over".equals(line))
					break;
				bw.write(line.toUpperCase());
				bw.newLine();
				bw.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				if(br != null)
					br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(bw != null)
					bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
