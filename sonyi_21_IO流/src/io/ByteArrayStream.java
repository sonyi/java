package io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
	���ڲ����ֽ������������
		ByteArrayInputStream:�ڹ����ʱ����Ҫ��������Դ����������Դ��һ���ֽ�����
		ByteArrayOutputStream:�ڹ����ʱ�򣬲��ö�������Ŀ�ģ���Ϊ�ö������Ѿ��ڲ���װ�˿ɱ䳤�ȵ��ֽ�����
			���������Ŀ�ĵء�
		��Ϊ�����������󶼲��������飬��û��ʹ��ϵͳ��Դ�����Բ��ý���close�رա�
		
		���������Ľ���ʱ��
			Դ�豸������(System.in)��Ӳ��(FileStream)���ڴ�(ArrayStream)
			Ŀ���豸������̨(System.out)��Ӳ��(FileStream)���ڴ�(ArrayStream)
			
		�����Ķ�д˼�����������顣
 */
public class ByteArrayStream {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����Դ
		ByteArrayInputStream bis = new ByteArrayInputStream("abdcefg".getBytes());
		
		//����Ŀ��
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		int by = 0;
		while((by = bis.read()) != -1){
			bos.write(by);
		}
		System.out.println(bos.size());
		System.out.println(bos.toString());
		
		//bos.writeTo(new FileOutputStream("a.txt"));
	}
}
