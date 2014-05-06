package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s = new Socket("192.168.1.106",20002);
		PrintWriter pwOut = new PrintWriter(s.getOutputStream(),true);
		BufferedReader brIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		Scanner scanner = new Scanner(System.in);
		String line = null;
		System.out.println("欢迎进入猜数字游戏，请猜一个1-10的整数！");
		while(true){
			line = null;
			while(true){		
				line = scanner.nextLine();//接收键盘输入
				pwOut.println(line);//发送键盘输入的内容
				String receive = brIn.readLine();//接收服务端信息
				System.out.println(receive);
				if(receive.contains("猜对了")){
					break;
				}	
			}
			System.out.println("是否继续游戏?继续游戏请输：yes，退出游戏请输入：no");
			line = scanner.nextLine();
			pwOut.println(line);
			if("no".equals(line)){
				break;
			}else {
				System.out.println("重新开始游戏，请输入一个1-10的整数！");
			}
		}	
		s.close();
		scanner.close();
	}
}
