package io.BufferWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
	�������ĳ�����Ϊ��������Ĳ���Ч�ʶ����ֵ�
	�����ڴ���������֮ǰ������Ҫ����������
	bf.newLine();//�û������ṩ��һ����ƽ̨�Ļ��з�
 */
public class BufferWriterDemo {
	public static void main(String[] args) {
		//����һ���ַ�д��������
		FileWriter fw = null;
		BufferedWriter bf = null;
		try {
			fw = new FileWriter("buf.txt");
			
			//Ϊ������ַ�д����Ч�ʣ����뻺�弼��
			//ֻҪ����Ҫ�����Ч�ʵ���������Ϊ�������ݸ��������Ĺ��캯�����ɡ�
			bf = new BufferedWriter(fw);
			
			bf.write("abdcd");
			bf.newLine();//�û������ṩ��һ����ƽ̨�Ļ��з�
			bf.write("sbuidi");
			
			//��ס��ֻҪ�õ�����������Ҫ�ǵ�ˢ��
			bf.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			//��ʵ�رջ������������ڹرջ������е�������
			if(bf != null)
				try {
					bf.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			//����ʡ��
//			if(fw != null)
//				try {
//					fw.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
		}
	}
}
