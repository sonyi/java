package url;
/*
	
	String getFile() 获取此 URL 的文件名。
	String getHost() 获取此 URL 的主机名（如果适用）。
	String getPath() 获取此 URL 的路径部分。
	int getPort() 获取此 URL 的端口号。
	String getProtocol() 获取此 URL 的协议名称。
	String getQuery()获取此 URL 的查询部分。

 */
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class URLDemo {
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://192.168.188.1:8080/myapp/index.jsp?name=haha&age=32");
		//URL url = new URL("http://www.baidu.com");
		System.out.println("协议名称: " + url.getProtocol());
		System.out.println("主机名: " + url.getHost());
		System.out.println("端口号: " + url.getPort());
		System.out.println("路径部分: " + url.getPath());
		System.out.println("文件名: " + url.getFile());
		System.out.println("查询部分: " + url.getQuery());
		
		URLConnection conn = url.openConnection();
		System.out.println(conn);
		System.out.println("主机名: " + url.getHost());
		
//		int port = getPort();
//		if(port == -1)
//			port = 80;//默认端口
		
	}
}
