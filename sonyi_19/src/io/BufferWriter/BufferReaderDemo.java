package io.BufferWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;

/*
	�ַ���ȡ������
	�û������ṩһ��һ�ζ�һ�еķ���readLine()���������ı����ݵĻ�ȡ��
	������nullʱ����ʾ�����ļ�ĩβ
	
	readLine������ԭ��
		�����Ƕ�ȡһ�У����Ƕ�ȡ����ַ�����ʵ���ն�����Ӳ����һ��һ����ȡ��
		��������ʹ�õĻ���read����һ�ζ�һ���ķ�����
 */
public class BufferReaderDemo {
	public static void main(String[] args) {
		//����һ����ȡ��������ļ������
		FileReader fr = null;
		try {
			fr = new FileReader("bur.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
