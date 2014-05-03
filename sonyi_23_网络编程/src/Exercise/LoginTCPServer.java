package Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginTCPServer {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(10008);
		while(true){
			Socket s = ss.accept();
			new Thread(new User(s)).start();
		}
	}

}

class User implements Runnable{
	private Socket s;
	public User(Socket s) {
		this.s = s;
	}
	public void run() {
		try {
			String id = s.getInetAddress().getHostName();
			System.out.println(id + "------------connected");
			//服务端口的连接可以放在循环外
			BufferedReader brIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter pwOut = new PrintWriter(s.getOutputStream(),true);
			BufferedReader brFile = null;	
			for(int i = 0; i < 3; i++){	
				//读取文件的输入流必须每次重新创建，因为上次的输入已经读到末尾，如果不重建，读到的文件将为空
				brFile = new BufferedReader(new FileReader("LoginTCPDemo.txt"));
				String name = brIn.readLine();
				if(name == null)
					break;
				String line = null;
				boolean flag = false;
				while ((line = brFile.readLine()) != null) {
					if(line.equals(name)){
						flag = true;
						break;
					}	
				}
				if(flag){
					System.out.println(name + ": 已经登入");
					pwOut.println("欢迎光临");
					break;
				}
				else {
					System.out.println(name + ": 尝试登入");
					pwOut.println("该用户不存在");
				}	
			}
			System.out.println(id + "server--------close");
			s.close();
			
		} catch (Exception e) {
			throw new RuntimeException("校验失败");
		}	
	}
}