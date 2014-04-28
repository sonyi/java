package io;

import java.io.RandomAccessFile;
/*
	RandowAccessFile：(可以实现多线程对文件的同时操作。比如下载)随机访问文件
		该类不算是IO体系中子类，而是直接继承自Object。
		但是它是IO包中成员，因为它具备读和写功能，内部封装了一个数组，
		而且通过指针对数组的元素进行操作，可以通过getFilePointer获取指针位置。
		同时可以通过seek改变指针的位置。
	
		其实完成读写的原理就是内部封装了字节输入流和输出流。
		通过构造函数可以看出，该类自能操作文件。
		而且操作文件还有模式:
			只读r，读写rw等。
			如果模式为只读，不会创建文件，会去读取一个已存在的文件，如果该文件不存在，则会出现异常
			如果模式为读写，那么该对象的构造函数要操作的文件如果不存在，会自动创建，如果存在，不会覆盖
	
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
		//调整对象中指针，可以随意设置
		//raf.seek(8);//访问第二个对象了
		
		//跳过指定的字节数
		raf.skipBytes(8);//只能往后调，不能往回调
		byte[] buf = new byte[4];
		raf.read(buf);
		String name = new String(buf);
		int age = raf.readInt();
		System.out.println("name = " + name + ",age = " + age);
		raf.close();
		
	}
	
	public static void writeFile_2() throws Exception{
		RandomAccessFile raf = new RandomAccessFile("ran.txt", "rw");
		//raf.seek(8*3);//跳到指定位置
		raf.write("周期".getBytes());
		raf.writeInt(103);
		raf.close();
	}
	
	public static void writeFile() throws Exception{
		RandomAccessFile raf = new RandomAccessFile("ran.txt", "rw");
		raf.write("李四".getBytes());
		raf.writeInt(97);
		raf.write("王五".getBytes());
		raf.writeInt(98);
		raf.close();
	}
}
