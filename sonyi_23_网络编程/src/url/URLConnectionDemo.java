package url;
/*
	
	String getFile() ��ȡ�� URL ���ļ�����
	String getHost() ��ȡ�� URL ����������������ã���
	String getPath() ��ȡ�� URL ��·�����֡�
	int getPort() ��ȡ�� URL �Ķ˿ںš�
	String getProtocol() ��ȡ�� URL ��Э�����ơ�
	String getQuery()��ȡ�� URL �Ĳ�ѯ���֡�

 */
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionDemo {
	public static void main(String[] args) throws IOException {
		//URL url = new URL("http://192.168.188.1:8080/myapp/index.jsp");
		URL url = new URL("http://www.baidu.com");
		URLConnection conn = url.openConnection();
		System.out.println(conn);
		
		System.out.println("������: " + url.getHost());
	}
}
