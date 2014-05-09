import java.net.*; 
import java.io.*; 
public class myclient { 
	public static void main(String args[]) { 	
		Socket socket; 
		String s = "yxfsoft@263.net"; 
		String len; 
		InputStream Is; 
		OutputStream Os; 
		DataInputStream DIS; 
		PrintStream PS; 
		try { 
			//向主机名为args[0]的服务器申请连接，注意端口号要与服务器保持一致:4321 
			socket=new Socket("localhost",4321); 
			System.out.println("client ok"); 
			System.out.println("******************** "); 
			System.out.println(""); 
			//获得对应socket的输入/输出流 
			Is=socket.getInputStream(); 
			Os=socket.getOutputStream(); 
			//建立数据流 
			DIS=new DataInputStream(Is); 
			PS=new PrintStream(Os); 
			DataInputStream in = new DataInputStream(System.in); 
			while(true){
				System.out.print("you say:"); 
				s = in.readLine(); //读取用户输入的字符串 
				PS.println(s); //将读取得字符串传给server 
				if(s.trim().equals("BYE"))break; //如果是"BYE",就退出 
				else 
				{ 
					System.out.println(""); 
					System.out.println("please wait server's message..."); 
					System.out.println(""); 
				} 
				s=DIS.readLine(); //从服务器获得字符串 
				System.out.println("server said:"+s); //打印字符串 
				if(s.trim().equals("BYE"))break; //如果是"BYE",就退出 
			} 
			//关闭连接 
			DIS.close(); //关闭数据输入流 
			PS.close(); //关闭数据输出流 
			Is.close(); //关闭输入流 
			Os.close(); //关闭输出流 
			socket.close(); //关闭socket 
		} 
		catch(Exception e){ 
			System.out.println("Error:"+e); 
		} 
	} 
}
