package io;
//�ܵ��������Խ��������������������һ���γ�һ���ܵ�
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreamDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PipedInputStream in = null;
		PipedOutputStream out = null;
				
			try {
				in = new PipedInputStream();
				out = new PipedOutputStream();
				in.connect(out);      //�������������������
				Read r = new Read(in);
				Write w = new Write(out);
				new Thread(r).start();
				new Thread(w).start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}
}

//������
class Read implements Runnable{
	private PipedInputStream in = null;
	public Read(PipedInputStream in) {
		// TODO Auto-generated constructor stub
		this.in = in;
	}
	public void run() {
		// TODO Auto-generated method stub
		try {
			byte[] buf = new byte[1024];
			System.out.println("��ȡǰ��������û����������");
			
			int len = in.read(buf);
			System.out.println("�������ݡ���������������");
			String s = new String(buf,0,len);
			System.out.println(s);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			try {
				if(in != null)
					in.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

//�����
class Write implements Runnable{
	private PipedOutputStream out = null;
	public Write(PipedOutputStream out) {
		// TODO Auto-generated constructor stub
		this.out = out;
	}
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("����5��");
			Thread.sleep(5000);
			byte[] b = "piped lai le".getBytes();
			out.write(b,0,b.length);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			try {
				if(out != null)
					out.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}
}


