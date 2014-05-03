package Exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
	需求：
		建立一个文本转换服务器，客服端给服务端发送文本，服务端会将文本转成大写再返回给客服端。
		而且客服端可以不断的进行文本转换，当客服端输入over时，转换结束。
		
	分析：服务端：
		源：Socket读取流
		目的：Socket输出流
		都是文本，装饰下。
		
	出现现象：
		客服端和服务端都在莫名的等待，这是为什么呢？
		因为客服端和服务端都有阻塞式方法，这些方法没有读取到结束标记，那么就一直等
		而导致两端都在等待。
		
 */
public class TCPServer {
	public static void main(String[] args) throws IOException {
		//建立服务端
		ServerSocket ss = new ServerSocket(10005);
		Socket s = ss.accept();//接收连接端口
		
		//测试是否连接成功
		String id = s.getInetAddress().getHostName();
		System.out.println(id + "..............connected");
		
		//建立网络输入流
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		//建立网络输出流
		BufferedWriter bufOut = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		String line = null;
		//循环获取数据
		while ((line = bufIn.readLine()) != null) {
			System.out.println(line);
			//注：不用判断结束语句，如果客服端循环结束关闭后，该循环也会自动结束
			bufOut.write(line.toUpperCase());//将获取的数据转换成大写并返回
			//添加换行符，不会导致获取数据的一方读完一行后因为没有读到换行符而认为读取数据未结束，而一直处于等待中
			bufOut.newLine();
			bufOut.flush();//读取的数据都存放于缓冲区，必须刷新后才能将数据发送出去
		}
		ss.close();//关闭服务端
	}
}
