package io;
//�ļ���д�ͻ���
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo3 {
	public static void main(String[] args) {
		FileWriter fWriter = null;
		try {//����һ��trueֵ�������������е��ļ������������ļ���ĩβ������������д��
			fWriter = new FileWriter("demo.txt",true);
			fWriter.write("caljdi");
			fWriter.write("\r\nsieids");//\r��\n������
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				fWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
