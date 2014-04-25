package io;

import java.io.FileWriter;
import java.io.IOException;

/*
	IO�����û��ࣺ
		�ֽ����ĳ�����ࣺ
			InputStream, OutputStream
		�ַ����ĳ�����ࣺ
			Reader, Writer
		ע:�����ĸ��������������������ƶ������丸��������Ϊ�������ĺ�׺��
			eg��InputStream������FileInputStream.
				Reader������FileReader.
	
	��ѧϰ�ַ������ص㣺
		��ȻIO�������ڲ������ݵģ���ô���ݵ����������ʽ�ǣ��ļ�
		��Ҫ����Ӳ���ϴ���һ���ļ���д��һЩ�������ݡ�
			�ҵ�һ��ר�����ڲ����ļ���write�����FileWriter��
			��׺���Ǹ�������ǰ׺���Ǹ�������ĵĹ��ܡ�
 */
public class FileWriteDemo {
	public static void main(String[] args) throws IOException {
		//����һ��FileWriter���󡣸ö���һ����ʼ���ͱ���Ҫ��ȷ���������ļ�
		//���Ҹ��ļ��ᱻ������ָ��Ŀ¼�£������Ŀ¼������ͬ���ļ�����������
		//��ʵ�ò����������ȷ����Ҫ��ŵ�Ŀ�ĵء�
		FileWriter fWriter = new FileWriter("demo.txt");
		
		//����write���������ַ���д�뵽����
		fWriter.write("abdc");
		
		//ˢ���������еĻ����е����ݡ�
		//������ˢ��Ŀ�ĵ��С�
		//fWriter.flush();

		//�ر�����Դ�����ǹر�֮ǰ��ˢ��һ���ڲ��Ļ����е����ݣ�������ˢ��Ŀ�ĵ���
		//��flush()������flushˢ�º������Լ���ʹ�ã�closeˢ�º󣬻Ὣ���رա�
		fWriter.close();
		
		
	}

}
