package io.BufferWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
	缓冲区的出现是为了提高流的操作效率而出现的
	所以在创建缓冲区之前，必须要先有流对象。
	bf.newLine();//该缓冲区提供了一个跨平台的换行符
 */
public class BufferWriterDemo {
	public static void main(String[] args) {
		//创建一个字符写入流对象
		FileWriter fw = null;
		BufferedWriter bf = null;
		try {
			fw = new FileWriter("buf.txt");
			
			//为了提高字符写入流效率，加入缓冲技术
			//只要将需要被提高效率的流对象作为参数传递给缓冲区的构造函数即可。
			bf = new BufferedWriter(fw);
			
			bf.write("abdcd");
			bf.newLine();//该缓冲区提供了一个跨平台的换行符
			bf.write("sbuidi");
			
			//记住，只要用到缓冲区，就要记得刷新
			bf.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			//其实关闭缓冲区，就是在关闭缓冲区中的流对象
			if(bf != null)
				try {
					bf.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			//可以省略
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
