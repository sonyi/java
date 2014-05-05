package cn.imcore.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * 客户端
 */
public class ClientDemo {

	public ClientDemo() {
		Socket c = null;
		try {
			//1.连接服务器
			c = new Socket("127.0.0.1", 8001);
			
			//2.发送信息给服务器
			OutputStream out = c.getOutputStream();
			out.write("你好，服务器。".getBytes());
			
			//3.接收服务器返回的信息
			InputStream in = c.getInputStream();
			byte[] b = new byte[1024];
			int len;
			while((len = in.read(b)) != -1) {
				System.out.println(new String(b,0,len));
				out.write("你好，我是客户端".getBytes());
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(c != null) {
				try {
					c.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new ClientDemo();

	}

}
