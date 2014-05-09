import java.net.*; 
import java.io.*;
public class myserver { 
	public static void main(String args[]) {
		//服务器套节字
		ServerSocket server; 
		//客户端套接字
		Socket socket; 
		String s; 
		InputStream Is;//输入流
		OutputStream Os;//输出流
		DataInputStream DIS; 
		PrintStream PS; 
		try { 
			//在端口4321注册服务 
			server=new ServerSocket(4321); 
			socket=server.accept();//监听窗口,等待连接 
			System.out.println("server ok"); 
			System.out.println("***************** "); 
			System.out.println(""); 
			//获得对应Socket的输入/输出流 
			Is = socket.getInputStream(); 
			Os = socket.getOutputStream(); 
			//建立数据流 
			DIS = new DataInputStream(Is); 
			PS = new PrintStream(Os);
			//建立输入流
			DataInputStream in = new DataInputStream(System.in); 
			while(true){ 
				System.out.println("");
				//打印显示信息
				System.out.println("please wait client's message..."); 
				System.out.println(""); 
				s=DIS.readLine(); //读入从client传来的字符串 
				System.out.println("client said:"+s); //打印字符串 
				if(s.trim().equals("BYE"))break; //如果是"BYE",就退出 
				System.out.print("you say:"); 
				s=in.readLine(); //读取用户输入的字符串 
				PS.println(s); //将读取得字符串传给client 
				if(s.trim().equals("BYE"))break; //如果是"BYE",就退出 
			} 
			//关闭连接 
			DIS.close(); //关闭数据输入流 
			PS.close(); //关闭数据输出流 
			Is.close(); //关闭输入流 
			Os.close(); //关闭输出流 
			socket.close(); //关闭sockey 
		} 
		catch(Exception e){ 
			System.out.println("Error:"+e); 
		} 
	} 
} 
