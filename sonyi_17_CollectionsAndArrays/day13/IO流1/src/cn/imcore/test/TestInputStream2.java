package cn.imcore.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class TestInputStream2 {

	public static void main(String[] args) {
		File f = new File("data/file.txt");
		InputStream is = null;//声明对象变量
		try {
			is = new FileInputStream(f);//实例化
			//is.read() == -1 说明到文件尾
			byte[] buf = new byte[100];
//			int len = is.read(buf);
//			System.out.println(len);//打印的是读取的内容长度
//			System.out.println(new String(buf,0,len));//打印读取的内容
			int len;
			while((len=is.read(buf)) != -1) {
				System.out.println(new String(buf,0,len));
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
