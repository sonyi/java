package cn.imcore.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
/**
 * 游戏结束 
 * 1.关闭客户端 
 * 2.继续
 */
public class NumGameClient {
	Socket ss;
	public NumGameClient() {
		Scanner input = new Scanner(System.in);
		try {
			ss = new Socket("127.0.0.1", 8003);
			//读
			BufferedReader br = new BufferedReader(new InputStreamReader(ss.getInputStream()));
			//写
			PrintWriter pw = new PrintWriter(ss.getOutputStream(), true);
			//
			pw.println("我要开始猜数字了。。。。");//
			
			String line;
			while((line=br.readLine()) != null) {
				System.out.println(line);
				pw.println(input.nextLine());//写数字
			}
		} catch (UnknownHostException e) {
			
		} catch (IOException e) {
			
		} finally {
			if(ss != null) {
				try {
					ss.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new NumGameClient();

	}

}
