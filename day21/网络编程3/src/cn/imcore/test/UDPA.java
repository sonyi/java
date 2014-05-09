package cn.imcore.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
/**
 * 服务器端
 * @author user
 *
 */
public class UDPA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//UDP服务
		DatagramSocket ser = null;
		try {
			ser = new DatagramSocket(8000);
			while(true) {
				byte[] buf = new byte[1024];//存放客户端发过来的信息
				//数据包
				DatagramPacket p = new DatagramPacket(buf, 1024);
				ser.receive(p);//接收数据包
				
				String temp = new String(buf,0,p.getLength());
				System.out.println(temp);
				if(temp.equals("bye")) {
					break;
				}
			}
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(ser != null) {
				ser.close();
			}
		}

	}

}
