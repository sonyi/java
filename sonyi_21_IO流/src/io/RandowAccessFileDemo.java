package io;

import java.io.RandomAccessFile;
/*
	RandowAccessFile��(����ʵ�ֶ��̶߳��ļ���ͬʱ��������������)��������ļ�
		���಻����IO��ϵ�����࣬����ֱ�Ӽ̳���Object��
		��������IO���г�Ա����Ϊ���߱�����д���ܣ��ڲ���װ��һ�����飬
		����ͨ��ָ��������Ԫ�ؽ��в���������ͨ��getFilePointer��ȡָ��λ�á�
		ͬʱ����ͨ��seek�ı�ָ���λ�á�
	
		��ʵ��ɶ�д��ԭ������ڲ���װ���ֽ����������������
		ͨ�����캯�����Կ������������ܲ����ļ���
		���Ҳ����ļ�����ģʽ:
			ֻ��r����дrw�ȡ�
			���ģʽΪֻ�������ᴴ���ļ�����ȥ��ȡһ���Ѵ��ڵ��ļ���������ļ������ڣ��������쳣
			���ģʽΪ��д����ô�ö���Ĺ��캯��Ҫ�������ļ���������ڣ����Զ�������������ڣ����Ḳ��
	
 */
public class RandowAccessFileDemo {
	public static void main(String[] args){
		try {
			//writeFile();
			//readFile();
			writeFile_2();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void readFile() throws Exception{
		RandomAccessFile raf = new RandomAccessFile("ran.txt", "r");
		//����������ָ�룬������������
		//raf.seek(8);//���ʵڶ���������
		
		//����ָ�����ֽ���
		raf.skipBytes(8);//ֻ����������������ص�
		byte[] buf = new byte[4];
		raf.read(buf);
		String name = new String(buf);
		int age = raf.readInt();
		System.out.println("name = " + name + ",age = " + age);
		raf.close();
		
	}
	
	public static void writeFile_2() throws Exception{
		RandomAccessFile raf = new RandomAccessFile("ran.txt", "rw");
		//raf.seek(8*3);//����ָ��λ��
		raf.write("����".getBytes());
		raf.writeInt(103);
		raf.close();
	}
	
	public static void writeFile() throws Exception{
		RandomAccessFile raf = new RandomAccessFile("ran.txt", "rw");
		raf.write("����".getBytes());
		raf.writeInt(97);
		raf.write("����".getBytes());
		raf.writeInt(98);
		raf.close();
	}
}
