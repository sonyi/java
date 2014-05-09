import java.net.*;
import java.io.*;
import java.util.*;
public class httpServer{
	public static void main(String args[]) {
		//端口信息
		int port;
		ServerSocket server_socket;
		//读取服务器端口号
		try {
			port = Integer.parseInt(args[0]);
		}
		catch (Exception e) {
			//为默认端口
			port = 8888;
		}
		try {
			//监听服务器端口，等待连接请求
			server_socket = new ServerSocket(port);
			System.out.println("httpServer running on port " +
				server_socket.getLocalPort());
			//显示启动信息
			while(true) {
				//服务器接收线程
				Socket socket = server_socket.accept();
				System.out.println("New connection accepted " +
					socket.getInetAddress() +
					":" + socket.getPort());
				//创建分线程
				try {
					httpRequestHandler request =
						new httpRequestHandler(socket);
					Thread thread = new Thread(request);
					//启动线程
					thread.start();
				}
				catch(Exception e) {
					System.out.println(e);//打印错误信息
				}
			}
		}
		catch (IOException e) {
			//打印错误信息
			System.out.println(e);
		}
	}
}
class httpRequestHandler implements Runnable {
	final static String CRLF = "\r\n";
	Socket socket;//套接字获得
	InputStream input;//输入流
	OutputStream output;//输出流
	BufferedReader br;
	//构造方法
	public httpRequestHandler(Socket socket) 
		throws Exception {
		this.socket = socket;
		this.input = socket.getInputStream();//获得输入流
		this.output = socket.getOutputStream();//获得输出流
		this.br = new BufferedReader(new
             InputStreamReader(socket.getInputStream()));
	}
	//实现Runnable 接口的run()方法
	public void run(){
		try {
			processRequest();
		}
		catch(Exception e) {
			//打印错误信息
			System.out.println(e);
		}
	}
	private void processRequest() throws Exception {
		while(true) {
			//读取并显示Web 浏览器提交的请求信息
			String headerLine = br.readLine();
			System.out.println("The client request is " + headerLine);
			if(headerLine.equals(CRLF) || headerLine.equals("")) break;
            //中断程序
			StringTokenizer s = new StringTokenizer(headerLine);
			String temp = s.nextToken();//解析信息			
			if(temp.equals("GET")) {
				String fileName = s.nextToken();
				//fileName = "." + fileName ;
				fileName ="C:/Inetpub/wwwroot"+fileName;
				//打开所请求的文件
				FileInputStream fis = null;
				boolean fileExists = true;				
				try	{				
					fis = new FileInputStream(fileName);//文件输出流					
				}
				catch(FileNotFoundException e) {
					fileExists = false;					
					System.err.println("file not found :"+fileName);
				}
				//完成回应消息
				String serverLine = "Server: a simple java httpServer";
				String statusLine = null;//状态行信息
				String contentTypeLine = null;//内容类型行
				String entityBody = null;
				String contentLengthLine = "error";
				if(fileExists) {
					statusLine = "HTTP/1.0 200 OK" + CRLF ;
					contentTypeLine = "Content-type: " +
						contentType( fileName ) + CRLF ;
					contentLengthLine = "Content-Length: "
						+ (new Integer(fis.available())).toString()
						+ CRLF;
				}
				else {
					statusLine = "HTTP/1.0 404 Not Found" + CRLF ;
					contentTypeLine = "text/html" ;
					entityBody = "<HTML>" +
						"<HEAD><TITLE>404 Not Found</TITLE></HEAD>" +
						"<BODY>404 Not Found" +
						"<br>usage:http://yourHostName:port/"+
						"fileName.html</BODY></HTML>" ;
				}
				// 发送到服务器信息
				output.write(statusLine.getBytes());
				output.write(serverLine.getBytes());
				output.write(contentTypeLine.getBytes());
				output.write(contentLengthLine.getBytes());
				output.write(CRLF.getBytes());
				// 发送信息内容
				if (fileExists)	{
					sendBytes(fis, output) ;//按字节发送信息
					fis.close();//关闭文件
				}
				else {
					output.write(entityBody.getBytes());
				}
			}
		}
		//关闭套接字和流
		try {
			output.close();//关闭输出流
			br.close();
			socket.close();
		}
		catch(Exception e) {}
	}
	private static void sendBytes(FileInputStream fis, 
			OutputStream os) throws Exception {
		// 创建一个 1K buffer
		byte[] buffer = new byte[1024] ;
		int bytes = 0 ;
		// 将文件输出到套接字输出流中
		while ((bytes = fis.read(buffer)) != -1 ) {
			os.write(buffer, 0, bytes);//通过写缓冲的方式
		}
	}
	private static String contentType(String fileName) {
		if (fileName.endsWith(".htm") || 
				fileName.endsWith(".html"))	{
			return "text/html";
		}		
		return "fileName";//返回文件名
	}
}  
