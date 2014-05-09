import java.net.*;
import java.io.*;
import java.util.*;
public class httpServer{
	public static void main(String args[]) {
		//�˿���Ϣ
		int port;
		ServerSocket server_socket;
		//��ȡ�������˿ں�
		try {
			port = Integer.parseInt(args[0]);
		}
		catch (Exception e) {
			//ΪĬ�϶˿�
			port = 8888;
		}
		try {
			//�����������˿ڣ��ȴ���������
			server_socket = new ServerSocket(port);
			System.out.println("httpServer running on port " +
				server_socket.getLocalPort());
			//��ʾ������Ϣ
			while(true) {
				//�����������߳�
				Socket socket = server_socket.accept();
				System.out.println("New connection accepted " +
					socket.getInetAddress() +
					":" + socket.getPort());
				//�������߳�
				try {
					httpRequestHandler request =
						new httpRequestHandler(socket);
					Thread thread = new Thread(request);
					//�����߳�
					thread.start();
				}
				catch(Exception e) {
					System.out.println(e);//��ӡ������Ϣ
				}
			}
		}
		catch (IOException e) {
			//��ӡ������Ϣ
			System.out.println(e);
		}
	}
}
class httpRequestHandler implements Runnable {
	final static String CRLF = "\r\n";
	Socket socket;//�׽��ֻ��
	InputStream input;//������
	OutputStream output;//�����
	BufferedReader br;
	//���췽��
	public httpRequestHandler(Socket socket) 
		throws Exception {
		this.socket = socket;
		this.input = socket.getInputStream();//���������
		this.output = socket.getOutputStream();//��������
		this.br = new BufferedReader(new
             InputStreamReader(socket.getInputStream()));
	}
	//ʵ��Runnable �ӿڵ�run()����
	public void run(){
		try {
			processRequest();
		}
		catch(Exception e) {
			//��ӡ������Ϣ
			System.out.println(e);
		}
	}
	private void processRequest() throws Exception {
		while(true) {
			//��ȡ����ʾWeb ������ύ��������Ϣ
			String headerLine = br.readLine();
			System.out.println("The client request is " + headerLine);
			if(headerLine.equals(CRLF) || headerLine.equals("")) break;
            //�жϳ���
			StringTokenizer s = new StringTokenizer(headerLine);
			String temp = s.nextToken();//������Ϣ			
			if(temp.equals("GET")) {
				String fileName = s.nextToken();
				//fileName = "." + fileName ;
				fileName ="C:/Inetpub/wwwroot"+fileName;
				//����������ļ�
				FileInputStream fis = null;
				boolean fileExists = true;				
				try	{				
					fis = new FileInputStream(fileName);//�ļ������					
				}
				catch(FileNotFoundException e) {
					fileExists = false;					
					System.err.println("file not found :"+fileName);
				}
				//��ɻ�Ӧ��Ϣ
				String serverLine = "Server: a simple java httpServer";
				String statusLine = null;//״̬����Ϣ
				String contentTypeLine = null;//����������
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
				// ���͵���������Ϣ
				output.write(statusLine.getBytes());
				output.write(serverLine.getBytes());
				output.write(contentTypeLine.getBytes());
				output.write(contentLengthLine.getBytes());
				output.write(CRLF.getBytes());
				// ������Ϣ����
				if (fileExists)	{
					sendBytes(fis, output) ;//���ֽڷ�����Ϣ
					fis.close();//�ر��ļ�
				}
				else {
					output.write(entityBody.getBytes());
				}
			}
		}
		//�ر��׽��ֺ���
		try {
			output.close();//�ر������
			br.close();
			socket.close();
		}
		catch(Exception e) {}
	}
	private static void sendBytes(FileInputStream fis, 
			OutputStream os) throws Exception {
		// ����һ�� 1K buffer
		byte[] buffer = new byte[1024] ;
		int bytes = 0 ;
		// ���ļ�������׽����������
		while ((bytes = fis.read(buffer)) != -1 ) {
			os.write(buffer, 0, bytes);//ͨ��д����ķ�ʽ
		}
	}
	private static String contentType(String fileName) {
		if (fileName.endsWith(".htm") || 
				fileName.endsWith(".html"))	{
			return "text/html";
		}		
		return "fileName";//�����ļ���
	}
}  
