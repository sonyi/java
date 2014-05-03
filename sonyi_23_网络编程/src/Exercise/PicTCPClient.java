package Exercise;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/*
	目的：上传一张图片
	客户端：
		步骤：
			1、建立服务端点。
			2、读取客户端已有的图片数据
			3、通过Socket输出流将数据发送给服务端
			4、读取服务端的反馈信息。
			5、关闭资源
 */
public class PicTCPClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s = new Socket("192.168.188.1",10007);
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("1.jpg"));
		BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream());
		byte[] buf = new byte[1024];
		System.out.println("Client--------0");
		while ((bis.read(buf)) != -1) {
			bos.write(buf,0,buf.length);
			bos.flush();
		}
		
		//告诉服务端数据已经写完
		s.shutdownOutput();
		System.out.println("Client--------1");

		BufferedReader b = new BufferedReader(new InputStreamReader(s.getInputStream()));
		System.out.println(b.readLine());
		System.out.println("Client--------3");
		bis.close();
		s.close();
	}
}
