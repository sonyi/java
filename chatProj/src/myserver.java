import java.net.*; 
import java.io.*;
public class myserver { 
	public static void main(String args[]) {
		//�������׽���
		ServerSocket server; 
		//�ͻ����׽���
		Socket socket; 
		String s; 
		InputStream Is;//������
		OutputStream Os;//�����
		DataInputStream DIS; 
		PrintStream PS; 
		try { 
			//�ڶ˿�4321ע����� 
			server=new ServerSocket(4321); 
			socket=server.accept();//��������,�ȴ����� 
			System.out.println("server ok"); 
			System.out.println("***************** "); 
			System.out.println(""); 
			//��ö�ӦSocket������/����� 
			Is = socket.getInputStream(); 
			Os = socket.getOutputStream(); 
			//���������� 
			DIS = new DataInputStream(Is); 
			PS = new PrintStream(Os);
			//����������
			DataInputStream in = new DataInputStream(System.in); 
			while(true){ 
				System.out.println("");
				//��ӡ��ʾ��Ϣ
				System.out.println("please wait client's message..."); 
				System.out.println(""); 
				s=DIS.readLine(); //�����client�������ַ��� 
				System.out.println("client said:"+s); //��ӡ�ַ��� 
				if(s.trim().equals("BYE"))break; //�����"BYE",���˳� 
				System.out.print("you say:"); 
				s=in.readLine(); //��ȡ�û�������ַ��� 
				PS.println(s); //����ȡ���ַ�������client 
				if(s.trim().equals("BYE"))break; //�����"BYE",���˳� 
			} 
			//�ر����� 
			DIS.close(); //�ر����������� 
			PS.close(); //�ر���������� 
			Is.close(); //�ر������� 
			Os.close(); //�ر������ 
			socket.close(); //�ر�sockey 
		} 
		catch(Exception e){ 
			System.out.println("Error:"+e); 
		} 
	} 
} 
