package cn.imcore.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
/**
 * 游戏结束  
 * 1.如果客户端结束，那么服务器端也结束
 * 2.客户端要继续的话，重新生成随机数，让客户端继续猜
 * @author user
 *
 */
public class NumGameServer {
	ServerSocket ser = null;
	private int n;
	public NumGameServer() {
		//先生产一个随机数
		Random r = new Random();
		n = r.nextInt(20);
		System.out.println("系统生产的随机数为：" + n);
		
		//1.注册服务
		try {
			ser = new ServerSocket(8003);
			Socket s = ser.accept();//接收客户端请求
			//读
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			//写
			PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
			System.out.println(br.readLine());//先接收客户信息
			pw.println("请输入0-20之间的数字：");
			
			String line;
			while((line=br.readLine()) != null) {
				if(line.equals(String.valueOf(n))) {
					pw.println("恭喜你答对了，游戏结束。");
				} else {
					pw.println("您答错了，请继续猜。。。。。");
				}
			}
		} catch (IOException e) {

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
		new NumGameServer();

	}

}
