package ioFileReaderFileWriter;

import java.io.IOException;
//通过字符数组进行读取
import java.io.FileReader;

public class FileReaderDemo2 {
	public static void main(String[] args) {
		
		FileReader fr = null;
		try {
			fr = new FileReader("demo.txt");
			//定义一个字符数组，用于存储读到的字符
			//该read(char[])返回的是读到字符个数
			char[] buf = new char[3];
		
			while((fr.read(buf)) != -1){
				System.out.println(buf);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		finally{
			if(fr != null)
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
