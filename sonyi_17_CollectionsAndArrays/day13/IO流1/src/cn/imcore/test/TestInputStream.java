package cn.imcore.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class TestInputStream {

	public static void main(String[] args) {
		File f = new File("data/file.txt");
		InputStream is = null;//声明对象变量
		try {
			is = new FileInputStream(f);//实例化
			//is.read() == -1 说明到文件尾
			int temp = 0;
			//按字节的形式读取文件信息，返回的值是以字节的形式显示
			while((temp = is.read()) != -1) {//读文件内容
				System.out.print((char)temp);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(is!=null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//关闭文件
			}
		}
	}
}
