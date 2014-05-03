package net;

import java.net.Inet4Address;
import java.net.UnknownHostException;
/*
	IP��ַ��InetAdress
		1���������豸�ı�ʶ��
		2�����׼��䣬������������
		3�����ػػ���ַ��127.0.0.1����������localhost.
	
	�˿ںţ�
		1�����ڱ�ʶ���̵��߼���ַ����ͬ���̵ı�ʶ��
		2����Ч�˿ڣ�0-65535������0-1024ϵͳʹ�û����˿�
		
	����Э��:
		1��ͨ�ŵĹ���
		2������Э�飺TCP,UDP
			UCP��(����������)(���磺���졢��Ƶ���顢���湲���)
				1�������ݼ�Դ��Ŀ�ķ�װ�����ݰ��У�����Ҫ�������ӡ�
				2��ÿ�����ݵĴ�С������64k�ڡ�(���ݱ����)
				3���������ӣ��ǲ��ɿ�Э�顣
				4������Ҫ�������ӣ��ٶȿ졣
			TCP��(��������)(���磺����)
				1���������ӣ��γɴ������ݵ�ͨ����
				2���������н��д����ݴ��䡣
				3��ͨ����������������ӣ��ǿɿ�Э�顣
				4�����뽨�����ӣ�Ч�ʻ��Ե͡�
				
	Socket:
		1��Socket����Ϊ����������ṩ��һ�ֻ��ơ�
		2��ͨ�ŵ����˶���Socket��
		3������ͨ����ʵ����Socket���ͨ�š�
		4������������Socket��ͨ��IO���䡣
		
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
