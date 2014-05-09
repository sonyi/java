package cn.imcore.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
/**
 * 客户端
 * @author user
 *
 */
public class UDPB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket ct = null;
		try {
			ct = new DatagramSocket();
			while(true) {
				//要发送的数据
				String temp = read.readLine();
				byte[] buf = temp.getBytes();
				//数据包
				DatagramPacket p = new DatagramPacket(buf, buf.length, InetAddress.getByName("127.0.0.1"),8000);
				ct.send(p);//发送数据包
				if(temp.equals("bye")) {
					break;
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(ct != null) {
				ct.close();
			}
		}

	}

}
