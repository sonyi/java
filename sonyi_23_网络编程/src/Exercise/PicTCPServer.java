package Exercise;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
/*
	服务端：
		这个服务端有个局限性，当A客户端连接上以后，被服务端获取到，
			服务端执行具体流程，这时B客户端连接，只能等待。
			因为服务端还没有处理完A客户端的请求，还有循环回来执行下次
			accept方法，所以暂时获取不到B客户端对象。
			
			那么为了可以让多个客户端同时并发访问服务端，服务端最好就是
			将每个客户端封装到一个单独的线程中，这样，就可以同时处理多个
			客户端请求。
			
	如何定义线程：
		只要明确了每个客户端要在服务端执行的代码即可，将该代码存入
		run方法中。
 */
public class PicTCPServer {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(10007);
		while(true){
			Socket s = ss.accept();
			new Thread(new PicThread(s)).start();
		}
	}
}

class PicThread implements Runnable{
	private Socket s;
	public PicThread(Socket s) {
		this.s = s;
	}
	public void run() {
		int count = 1;
		String id = s.getInetAddress().getHostName();
		try {
			
			System.out.println(id + "-----------connected");
			BufferedInputStream bis = new BufferedInputStream(s.getInputStream());
			File file = new File(id + ".jpg");
			while(file.exists())
				file = new File(id + "(" + (count++) + ").jpg");
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
			byte[] buf = new byte[1024];
			int len = 0;
			System.out.println("Serve------1");
			while ((len = bis.read(buf)) != -1) {
				bos.write(buf,0,len);
				bos.flush();
			}
			System.out.println("Serve------2");
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			bw.write("图片上传成功");
			System.out.println("Serve------3");
			
			bw.close();//关闭资源很重要，如果不关闭，提醒信息还在缓冲区，没有发送出去，客户端将出现异常
			bos.close();
			
		} catch (Exception e) {
			throw new RuntimeException(id + "上传失败");
		}
	}
	
}

/*
public class PicTCPServer {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(10007);
		Socket s = ss.accept();
		String id = s.getInetAddress().getHostName();
		System.out.println(id + "-----------connected");
		BufferedInputStream bis = new BufferedInputStream(s.getInputStream());
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("2.jpg"));
		byte[] buf = new byte[1024];
		int len = 0;
		System.out.println("Serve------1");
		while ((len = bis.read(buf)) != -1) {
			bos.write(buf,0,len);
			bos.flush();
		}
		System.out.println("Serve------2");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		bw.write("图片上传成功");
		System.out.println("Serve------3");
		
		bw.close();//关闭资源很重要，如果不关闭，提醒信息还在缓冲区，没有发送出去，客户端将出现异常
		bos.close();
		ss.close();
	}
}
*/
