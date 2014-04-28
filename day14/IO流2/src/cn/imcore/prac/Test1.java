package cn.imcore.prac;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Test1 {

	public static void main(String[] args) {
		//如何把temp1.txt的内容复制到temp2.txt?
		//1.打开这两个文件
		File f1 = new File("data/temp1.txt");//源文件
		File f2 = new File("data/temp2.txt");//目标文件
		
		//2.创建流（输入流和输出流）
		InputStream is = null;
		OutputStream os = null;
		
		try {
			is = new FileInputStream(f1);//从文件-程序
			os = new FileOutputStream(f2);//从程序-文件
			
			int temp;
			while((temp = is.read()) != -1) {
				os.write(temp);//把内容写到文件
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(os != null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		

	}

}
