package cn.imcore.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TestInOut {

	
	public static void main(String[] args) {
		TestInOut t = new TestInOut();
		
		File f = new File("data/out.txt");
		t.writeFile(f);//����д���ļ�
		t.readFile(f);//���ݶ���������
	}
	
	//�ӳ����а�����д���ļ�
	public void writeFile(File f) {
		String str = "123456789abcdefg123456789abcdefg";
		OutputStream os = null;
		try {
			os = new FileOutputStream(f);
			os.write(str.getBytes());//�ַ���ת�ֽ�����
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(os != null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	//���ļ��а����ݶ���������
	public void readFile(File f) {
		InputStream is = null;
		try {
			is = new FileInputStream(f);
			byte[] b = new byte[1024];
			int len;
			while((len=is.read(b)) != -1) {
				System.out.println(new String(b,0,len));
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
