package Exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//练习：将文件上传至服务端，并返回是否上传成功。
public class TestServer {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(10006);
		Socket s = ss.accept();
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		PrintWriter pw = new PrintWriter(new FileWriter("TextTCP.txt"),true);
		String line = null;
		while ((line = bufIn.readLine()) != null) {
			pw.println(line);
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		bw.write("上传成功");
		
		bw.close();
		pw.close();
		s.close();
		ss.close();
	}

}
