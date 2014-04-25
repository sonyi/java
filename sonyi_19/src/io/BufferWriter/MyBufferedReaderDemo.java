package io.BufferWriter;

import java.io.FileReader;
import java.io.IOException;

/*
	�Զ���һ���࣬����һ�����ܺ�readLineһ�µķ�����
	��ģ��һ��BufferedReader
	
	װ�����ģʽ��
		����Ҫ�����еĶ�����й�����ǿʱ�����Զ����࣬�����ж����룬�������еĹ��ܣ�
		���ṩ��ǿ���ܣ���ô�Զ���ĸ����Ϊװ���ࡣ
	
		װ����ͨ����ͨ�����췽�����ձ�װ�εĶ���
		�����ڱ�װ�εĶ���Ĺ��ܣ��ṩ��ǿ�Ĺ��ܡ�
 */
class MyBufferedReader {
	private FileReader reader;
	MyBufferedReader(FileReader reader){
		this.reader = reader;
	}
	//����һ�ζ�ȡһ�����ݵķ���
	public String myReadLine() throws IOException{
		//����һ����ʱ������ԭBufferReader��װ�����ַ�����
		//Ϊ����ʾ���㣬����һ��StringBuilder��������Ϊ���ջ���Ҫ�����ݱ���ַ���
		StringBuilder sb = new StringBuilder();
		int ch = 0;
		while((ch = reader.read()) != -1){
			if(ch == '\r')
				continue;
			if(ch == '\n')
				return sb.toString();
			else {
				sb.append((char)ch);
			}
		}
		if(sb.length() != 0){//�ж����һ��
			return sb.toString();
		}
		else{
			return null;
		}
	}
	public void myClose() throws IOException{
		reader.close();
	}
}

class MyBufferedReaderDemo{
	public static void main(String[] args){
		FileReader fr = null;
		MyBufferedReader myBuf = null;
		try {
			fr = new FileReader("buf.txt");
			myBuf = new MyBufferedReader(fr);
			String line = null;
			while((line = myBuf.myReadLine()) != null){
				System.out.println(line);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(myBuf != null)
				try {
					myBuf.myClose();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}		
	}
}

