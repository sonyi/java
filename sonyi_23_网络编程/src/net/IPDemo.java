package net;

import java.net.Inet4Address;
import java.net.UnknownHostException;
/*
	IP地址：InetAdress
		1、网络中设备的标识。
		2、不易记忆，可用主机名。
		3、本地回环地址：127.0.0.1。主机名：localhost.
	
	端口号：
		1、用于标识进程的逻辑地址，不同进程的标识。
		2、有效端口：0-65535，其中0-1024系统使用或保留端口
		
	传输协议:
		1、通信的规则
		2、常见协议：TCP,UDP
			UCP：(面向无连接)(比如：聊天、视频会议、桌面共享等)
				1、将数据及源和目的封装成数据包中，不需要建立连接。
				2、每个数据的大小限制在64k内。(数据被封包)
				3、因无连接，是不可靠协议。
				4、不需要建立连接，速度快。
			TCP：(面向连接)(比如：下载)
				1、建立连接，形成传输数据的通道。
				2、在连接中进行大数据传输。
				3、通过三次握手完成连接，是可靠协议。
				4、必须建立连接，效率会稍低。
				
	Socket:
		1、Socket就是为了网络服务提供的一种机制。
		2、通信的两端都是Socket。
		3、网络通信其实就是Socket间的通信。
		4、数据在两个Socket间通过IO传输。
		
 */

public class IPDemo {
	public static void main(String[] args) throws UnknownHostException {
		Inet4Address i = (Inet4Address) Inet4Address.getLocalHost();
		System.out.println(i.toString());
		System.out.println("name: " + i.getHostName());
		System.out.println("address: " + i.getHostAddress());
		
		Inet4Address ia = (Inet4Address) Inet4Address.getByName("192.168.188.1");
		System.out.println("name: " + ia.getHostName());
		System.out.println("address: " + ia.getHostAddress());
		
		Inet4Address ib = (Inet4Address) Inet4Address.getByName("www.baidu.com");
		System.out.println("name: " + ib.getHostName());
		System.out.println("address: " + ib.getHostAddress());
		
	}

}
