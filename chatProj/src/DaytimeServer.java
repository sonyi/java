import java.net.*; 
import java.io.*; 
public class DaytimeServer 
{ 
	public static final int SERVICE_PORT = 13; 
	public static void main(String args[]) 
	{ 
		try 
		{ 
			// �󶨵�����˿ڣ����ͻ����������TCP daytime�����Ȩ�� 
			ServerSocket server = new ServerSocket(SERVICE_PORT); 
			System.out.println ("Daytime service started"); 
			// ����ѭ�������ܿͻ��� 
			for (;;) 
			{
				// ��ȡ��һ��TCP�ͻ��� 
				Socket nextClient = server.accept(); 
				// ��ʾ����ϸ�� 
				System.out.println("Received request from " + 
					nextClient.getInetAddress()+":"+nextClient.getPort()); 
				//����ȡ���ݣ�ֻ������Ϣд��Ϣ 
				OutputStream out = 	nextClient.getOutputStream(); 
				PrintStream pout = new PrintStream (out); 
				// �ѵ�ǰ������ʾ���û� 
				pout.print(new java.util.Date()); 
				// ���δ���͵��ֽ� 
				out.flush(); 
				// �ر��� 
				out.close(); 
				// �ر����� 
				nextClient.close(); 
			} 
		} 
		catch (BindException be) 
		{ 
			//��ӡ������Ϣ
			System.err.println ("Service already running on port "
             + SERVICE_PORT ); 
		} 
		catch (IOException ioe) 
		{ 
			System.err.println ("I/O error - " + ioe); 
		} 
	} 
} 
