package io.BufferWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;

/*
	字符读取缓冲区
	该缓冲区提供一个一次读一行的方法readLine()，方便于文本数据的获取。
	当返回null时，表示读到文件末尾
	
	readLine方法的原理：
		无论是读取一行，或是读取多个字符，其实最终都是在硬盘上一个一个读取，
		所以最终使用的还是read方法一次读一个的方法。
 */
public class BufferReaderDemo {
	public static void main(String[] args) {
		//创建一个读取流对象和文件相关联
		FileReader fr = null;
		try {
			fr = new FileReader("bur.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
