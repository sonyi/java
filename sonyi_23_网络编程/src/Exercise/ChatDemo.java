package Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*
	目的：
		编写一个聊天程序。有收数据的部分和发数据的部分。这两个部分需要同时执行。
		那就需要用到多线程技术，一个线程控制收，一个线程控制发。
		
		因为收和发动作不是一致的，所以要定义两个run方法。而且这两个方法要封装到不同的类中。
			
 */
public class ChatDemo {
	public static void main(String[] args) {
		try {
			DatagramSocket sendSocket = new DatagramSocket();
			DatagramSocket receiveSocket = new DatagramSocket(10002);
			new Thread(new Send(sendSocket)).start();
			new Thread(new Receive(receiveSocket)).start();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}

class Receive implements Runnable{
	DatagramSocket ds = null;
	public Receive(DatagramSocket ds) {
		this.ds = ds;
	}
	public void run() {
		while (true) {
			byte[] buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf, buf.length);
			try {
				ds.receive(dp);
				String id = dp.getAddress().getHostName();
				String data = new String(dp.getData(),0,dp.getLength());
				System.out.println(id + "--------" + data);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Send implements Runnable{
	private DatagramSocket ds = null;
	public Send(DatagramSocket ds) {
		this.ds = ds;
	}
	public void run() {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		try {
			while ((line = bf.readLine()) != null) {
				if("over".equals(line))
					break;
				byte[] buf = line.getBytes();
				DatagramPacket dp = new DatagramPacket(buf, buf.length,InetAddress.getByName("192.168.1.255"),10002);
				ds.send(dp);		
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			ds.close();
		}
	}
}