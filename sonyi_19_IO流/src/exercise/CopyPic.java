package exercise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
	��ϰ��
		Ŀ��:����һ��ͼƬ
		˼·��
			1�����ֽڶ�ȡ�������ͼƬ�����
			2�����ֽ�д�������󴴽�һ��ͼƬ�ļ�
			3��ͨ��ѭ����д��������ݵĴ洢��
			4���ر���Դ
 */
public class CopyPic {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		 
		try {
			fis = new FileInputStream("exercise/01.jpg");
			fos = new FileOutputStream("exercise/02.jpg");
			byte[] buf = new byte[1024];
			while(fis.read(buf) != -1){
				fos.write(buf);
				fos.flush();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{	
			try {
				if (fis != null) 
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			try {
				if(fos != null)
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
