package Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/*
	练习：
		客户端通过键盘输入用户名，服务端对这个用户名进行校验。
		如果该用户名存在，在服务端显示xxx，已登入，并在用户端显示xxx，欢迎光临
		如果该用户不存在，在服务端显示xxx，尝试登入，并在客户端显示xxx，该用户不存在
		最多就登入三次。
 */
public class LoginTCPClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s = new Socket("192.168.188.1",10008);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pwOut = new PrintWriter(s.getOutputStream(),true);
		BufferedReader bfIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		for(int i = 0; i < 3 ; i++){
			String name = br.readLine();
			if(name == null)
				break;
			pwOut.println(name);
			String line = bfIn.readLine();
			System.out.println(name + ":" + line);
			if(line.contains("欢迎"))
				break;
		}
		br.close();
		s.close();	
	}
}





