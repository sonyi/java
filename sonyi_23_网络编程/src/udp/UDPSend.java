package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
	需求：
		通过UDP传输方式，将一段文字数据发送出去。
		
	定义UDP的发送端
	
	思路：
		1、建立UDPSocket服务。
		2、提供数据，并将数据封装到数据包中。
		3、通过Socket服务的发送功能，将数据包发出去
		4、关闭资源。
 */ 
public class UDPSend {

	public static void main(String[] args) throws IOException {
		//1、创建UDP服务，通过DatagramSocket对象
		DatagramSocket ds = new DatagramSocket(8888);
		
		//2、确定数据，并封装成数据包
		byte[] data = "upd ge men lai le".getBytes();
		DatagramPacket dp = new DatagramPacket(data,
				data.length,InetAddress.getByName("192.168.188.1"),10000);
		
		//通过Socket服务，将已有的数据包发送出去，通过send方法
		ds.send(dp);
		
		//关闭资源
		ds.close();	
	}
}







