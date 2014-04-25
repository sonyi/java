package cn.imcore.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class TestInputStream {

	public static void main(String[] args) {
		File f = new File("data/file.txt");
		InputStream is = null;//�����������
		try {
			is = new FileInputStream(f);//ʵ����
			//is.read() == -1 ˵�����ļ�β
			int temp = 0;
			//���ֽڵ���ʽ��ȡ�ļ���Ϣ�����ص�ֵ�����ֽڵ���ʽ��ʾ
			while((temp = is.read()) != -1) {//���ļ�����
				System.out.print((char)temp);
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
