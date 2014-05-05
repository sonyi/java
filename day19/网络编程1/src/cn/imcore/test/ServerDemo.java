package cn.imcore.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 服务器端
 * 一问一答模式
 * @author user
 *
 */
public class ServerDemo {

	public ServerDemo() {
		//1.先注册服务
		ServerSocket ser = null;
		try {
			ser = new ServerSocket(8001);
			
			//2.等待客户连接
			Socket s = ser.accept(); //s 就是当前客户端的引用对象
			System.out.println(s);//打印客户端
			
			//4.发送信息给客户端
			OutputStream out = s.getOutputStream();
			
			
			//3.接收客户端信息
			InputStream in = s.getInputStream();
			byte[] b = new byte[1024];
			int len;
			while((len = in.read(b)) != -1) {
				System.out.println(new String(b,0,len));
				out.write("你好，我是服务器。".getBytes());
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(ser != null) {
				try {
					ser.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new ServerDemo();

	}

}
