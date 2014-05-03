package tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/*
客户端：
	通过查阅Socket对象，发现在该对象建立时，就可以去连接指定主机。
	因为TCP是面向连接的，所以在建立Socket服务时，就要有服务端的存在，
	并连接成功，形成通路后，在该通道进行数据的传输。
	
步骤：
	1、创建Socket服务，并指定要连接的主机和端口。
	
*/

class TCPClient{
	public static void main(String[] args) throws UnknownHostException, IOException{
		//创建客服端的Socket服务，指定目的主机和端口
		Socket s = new Socket("192.168.188.1",10003);
		
		//为了发送数据，应该获取Socket流中的输出流
		OutputStream out = s.getOutputStream();
		out.write("TCP ge men lai le".getBytes());
		s.close();
	}
}

