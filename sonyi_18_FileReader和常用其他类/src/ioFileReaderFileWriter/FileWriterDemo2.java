package ioFileReaderFileWriter;

import java.io.FileWriter;
import java.io.IOException;

/*
	IO�쳣�Ĵ���ʽ��
		IO�쳣�Ļ�������ʽ��
 */
public class FileWriterDemo2 {
	public static void main(String[] args) {
		FileWriter fWriter = null;//�ⲿ����
		try {
			fWriter= new FileWriter("e:\\demo.txt");
			fWriter.write("avhd");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				if(fWriter != null)
					fWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

	}

}
