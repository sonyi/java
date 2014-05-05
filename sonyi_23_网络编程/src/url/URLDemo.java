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

public class URLDemo {
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://192.168.188.1:8080/myapp/index.jsp?name=haha&age=32");
		//URL url = new URL("http://www.baidu.com");
		System.out.println("Э������: " + url.getProtocol());
		System.out.println("������: " + url.getHost());
		System.out.println("�˿ں�: " + url.getPort());
		System.out.println("·������: " + url.getPath());
		System.out.println("�ļ���: " + url.getFile());
		System.out.println("��ѯ����: " + url.getQuery());
		
		URLConnection conn = url.openConnection();
		System.out.println(conn);
		System.out.println("������: " + url.getHost());
		
//		int port = getPort();
//		if(port == -1)
//			port = 80;//Ĭ�϶˿�
		
	}
}
