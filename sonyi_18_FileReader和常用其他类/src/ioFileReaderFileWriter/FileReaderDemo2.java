package ioFileReaderFileWriter;

import java.io.IOException;
//ͨ���ַ�������ж�ȡ
import java.io.FileReader;

public class FileReaderDemo2 {
	public static void main(String[] args) {
		
		FileReader fr = null;
		try {
			fr = new FileReader("demo.txt");
			//����һ���ַ����飬���ڴ洢�������ַ�
			//��read(char[])���ص��Ƕ����ַ�����
			char[] buf = new char[3];
		
			while((fr.read(buf)) != -1){
				System.out.println(buf);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		finally{
			if(fr != null)
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
