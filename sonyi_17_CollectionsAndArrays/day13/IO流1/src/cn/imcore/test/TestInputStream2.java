package cn.imcore.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class TestInputStream2 {

	public static void main(String[] args) {
		File f = new File("data/file.txt");
		InputStream is = null;//�����������
		try {
			is = new FileInputStream(f);//ʵ����
			//is.read() == -1 ˵�����ļ�β
			byte[] buf = new byte[100];
//			int len = is.read(buf);
//			System.out.println(len);//��ӡ���Ƕ�ȡ�����ݳ���
//			System.out.println(new String(buf,0,len));//��ӡ��ȡ������
			int len;
			while((len=is.read(buf)) != -1) {
				System.out.println(new String(buf,0,len));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(is!=null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//�ر��ļ�
			}
		}
	}
}
