package Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UDPSent {
	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while ((line = bf.readLine()) != null) {
			if("over".equals(line))
				break;
			byte[] buf = line.getBytes();
			DatagramPacket dp = new DatagramPacket(buf, buf.length,
					InetAddress.getByName("192.168.1.255"),10001);//地址为广播地址，只要接收端口一样，都能接收到
			ds.send(dp);
		}
		ds.close();
	}
}
