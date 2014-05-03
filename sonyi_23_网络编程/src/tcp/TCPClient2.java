package tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/*
客户端步骤：
	1、创建Socket服务，并指定要连接的主机和端口。
	2、获取Socket流中的输出流，将数据写到该流中，通过网络发送到服务端。
	3、获取Socket流中的输入流，将服务端反馈的数据获取到，并打印
	4、关闭客服端资源。
*/

class TCPClient2{
	public static void main(String[] args) throws UnknownHostException, IOException{
		//创建客服端的Socket服务，指定目的主机和端口
		Socket s = new Socket("192.168.188.1",10004);
		
		//为了发送数据，应该获取Socket流中的输出流
		OutputStream out = s.getOutputStream();
		out.write("服务端，你好".getBytes());
		
		InputStream in = s.getInputStream();
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		System.out.println(new String(buf,0,len));
		
		s.close();
	}
}

