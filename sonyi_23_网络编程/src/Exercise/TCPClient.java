package Exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/*	
分析：客服端：
		既然是操作设备上的数据，那么就可以使用IO技术，并按照IO的操作规律来思考
		源：键盘录入
		目的：网络输出流，而且操作的是文本数据，可以选择字符流
		
		步骤：
			1、建立服务
			2、获取键盘录入
			3、将数据发给服务端
			4、获取服务端返回的大写数据
			5、结束，关闭资源
			都是文本数据，可以使用字符流进行操作，同时提高效率，加入缓冲。
 */
public class TCPClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//建立端口服务
		Socket s = new Socket("192.168.188.1",10005);
		
		//获取键盘输入
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		
		//建立网络输出流
		BufferedWriter bufOut = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		
		//建立网络输入流
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String line = null;
		
		//键盘读取数据，并将数据发送出去，然后接收返回数据
		while ((line = buf.readLine()) != null) {
			if("over".equals(line))
				break;
			//System.out.println(line);
			bufOut.write(line);//读取的数据以换行符接收，但不包括换行符
			//添加换行符，不会导致获取数据的一方读完一行后因为没有读到换行符而认为读取数据未结束，而一直处于等待中
			bufOut.newLine();
			bufOut.flush();//读取的数据都存放于缓冲区，必须刷新后才能将数据发送出去
			System.out.println(bufIn.readLine());//接收返回数据，并将数据打印在控制台上。	
		}		
		buf.close();//关闭键盘输入
		s.close();//关闭客服端
		
	}
}
