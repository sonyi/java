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
			//��������Ϊargs[0]�ķ������������ӣ�ע��˿ں�Ҫ�����������һ��:4321 
			socket=new Socket("localhost",4321); 
			System.out.println("client ok"); 
			System.out.println("******************** "); 
			System.out.println(""); 
			//��ö�Ӧsocket������/����� 
			Is=socket.getInputStream(); 
			Os=socket.getOutputStream(); 
			//���������� 
			DIS=new DataInputStream(Is); 
			PS=new PrintStream(Os); 
			DataInputStream in = new DataInputStream(System.in); 
			while(true){
				System.out.print("you say:"); 
				s = in.readLine(); //��ȡ�û�������ַ��� 
				PS.println(s); //����ȡ���ַ�������server 
				if(s.trim().equals("BYE"))break; //�����"BYE",���˳� 
				else 
				{ 
					System.out.println(""); 
					System.out.println("please wait server's message..."); 
					System.out.println(""); 
				} 
				s=DIS.readLine(); //�ӷ���������ַ��� 
				System.out.println("server said:"+s); //��ӡ�ַ��� 
				if(s.trim().equals("BYE"))break; //�����"BYE",���˳� 
			} 
			//�ر����� 
			DIS.close(); //�ر����������� 
			PS.close(); //�ر���������� 
			Is.close(); //�ر������� 
			Os.close(); //�ر������ 
			socket.close(); //�ر�socket 
		} 
		catch(Exception e){ 
			System.out.println("Error:"+e); 
		} 
	} 
}
