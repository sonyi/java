package file;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	��ӡ����
		�����ṩ�˴�ӡ�ķ��������Խ������������͵����ݶ�ԭ����ӡ
		
	�ֽڴ�ӡ��:
		PrintStream:
			���캯������ֱ�ӽ��ܵĲ������ͣ�
				1��file����:File
				2���ַ���·����String
				3���ֽ��������OutputStream
				
	�ֽڴ�ӡ����
		PrintWriter:
			���캯������ֱ�ӽ��ܵĲ������ͣ�
				1��file����:File
				2���ַ���·����String
				3���ֽ��������OutputStream
				4���ַ��������Writer
 */
public class PrintStreamDemo {
	public static void main(String[] args) {
		BufferedReader br = null;
		br = new BufferedReader(new InputStreamReader(System.in));

	}
}
