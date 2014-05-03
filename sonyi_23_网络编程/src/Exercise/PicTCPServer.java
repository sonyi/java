package Exercise;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
/*
	����ˣ�
		���������и������ԣ���A�ͻ����������Ժ󣬱�����˻�ȡ����
			�����ִ�о������̣���ʱB�ͻ������ӣ�ֻ�ܵȴ���
			��Ϊ����˻�û�д�����A�ͻ��˵����󣬻���ѭ������ִ���´�
			accept������������ʱ��ȡ����B�ͻ��˶���
			
			��ôΪ�˿����ö���ͻ���ͬʱ�������ʷ���ˣ��������þ���
			��ÿ���ͻ��˷�װ��һ���������߳��У��������Ϳ���ͬʱ������
			�ͻ�������
			
	��ζ����̣߳�
		ֻҪ��ȷ��ÿ���ͻ���Ҫ�ڷ����ִ�еĴ��뼴�ɣ����ô������
		run�����С�
 */
public class PicTCPServer {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(10007);
		while(true){
			Socket s = ss.accept();
			new Thread(new PicThread(s)).start();
		}
	}
}

class PicThread implements Runnable{
	private Socket s;
	public PicThread(Socket s) {
		this.s = s;
	}
	public void run() {
		int count = 1;
		String id = s.getInetAddress().getHostName();
		try {
			
			System.out.println(id + "-----------connected");
			BufferedInputStream bis = new BufferedInputStream(s.getInputStream());
			File file = new File(id + ".jpg");
			while(file.exists())
				file = new File(id + "(" + (count++) + ").jpg");
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
			byte[] buf = new byte[1024];
			int len = 0;
			System.out.println("Serve------1");
			while ((len = bis.read(buf)) != -1) {
				bos.write(buf,0,len);
				bos.flush();
			}
			System.out.println("Serve------2");
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			bw.write("ͼƬ�ϴ��ɹ�");
			System.out.println("Serve------3");
			
			bw.close();//�ر���Դ����Ҫ��������رգ�������Ϣ���ڻ�������û�з��ͳ�ȥ���ͻ��˽������쳣
			bos.close();
			
		} catch (Exception e) {
			throw new RuntimeException(id + "�ϴ�ʧ��");
		}
	}
	
}

/*
public class PicTCPServer {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(10007);
		Socket s = ss.accept();
		String id = s.getInetAddress().getHostName();
		System.out.println(id + "-----------connected");
		BufferedInputStream bis = new BufferedInputStream(s.getInputStream());
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("2.jpg"));
		byte[] buf = new byte[1024];
		int len = 0;
		System.out.println("Serve------1");
		while ((len = bis.read(buf)) != -1) {
			bos.write(buf,0,len);
			bos.flush();
		}
		System.out.println("Serve------2");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		bw.write("ͼƬ�ϴ��ɹ�");
		System.out.println("Serve------3");
		
		bw.close();//�ر���Դ����Ҫ��������رգ�������Ϣ���ڻ�������û�з��ͳ�ȥ���ͻ��˽������쳣
		bos.close();
		ss.close();
	}
}
*/
