package cn.imcore.prac;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Test1 {

	public static void main(String[] args) {
		//��ΰ�temp1.txt�����ݸ��Ƶ�temp2.txt?
		//1.���������ļ�
		File f1 = new File("data/temp1.txt");//Դ�ļ�
		File f2 = new File("data/temp2.txt");//Ŀ���ļ�
		
		//2.�����������������������
		InputStream is = null;
		OutputStream os = null;
		
		try {
			is = new FileInputStream(f1);//���ļ�-����
			os = new FileOutputStream(f2);//�ӳ���-�ļ�
			
			int temp;
			while((temp = is.read()) != -1) {
				os.write(temp);//������д���ļ�
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
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

}
