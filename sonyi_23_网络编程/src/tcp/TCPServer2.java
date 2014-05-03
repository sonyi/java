package tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
演示：TCP的传输，建立客服端和服务端的互访。

需求：客服端给服务端发送数据，服务端接到数据后，给客服端反馈信息

	
服务端：
	1、建立服务端的Socket服务，ServerSocket();并监听一个端口
	2、获取连接过来的客服端对象。
		通过ServerSocket的accept方法，没有连接就会等，
		所以这个方法是阻塞式的。
	3、客服端如果发过来数据，那么服务端要使用对应的客服端对象，
		并获取到该客服端对象的读取流来读取发过来的数据，并打印在控制台。
	4、关闭服务端(可选操作).
*/

class TCPServer2{
public static void main(String[] args) throws IOException, InterruptedException{
	//建立服务端Socket服务，并监听一个端口
	ServerSocket ss = new ServerSocket(10004);
	
	//通过accept方法获取连接过来的客服端对象。
	Socket s = ss.accept();
	
	String ip = s.getInetAddress().getHostName();
	System.out.println(ip + "......connected");
	
	//获取客服端发过来的数据，那么要使用客服端对象的读取来读取数据
	InputStream in = s.getInputStream();
	byte[] buf = new byte[1024];
	int len = in.read(buf);
	System.out.println(new String(buf,0,len));
	
	OutputStream out = s.getOutputStream();
	Thread.sleep(2000);
	out.write("哥们收到，你也好".getBytes());
	
	//关闭客服端
	s.close();
	ss.close();//关闭服务端(可选操作)
}
}
