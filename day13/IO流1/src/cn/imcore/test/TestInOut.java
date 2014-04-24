package cn.imcore.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TestInOut {

	
	public static void main(String[] args) {
		TestInOut t = new TestInOut();
		
		File f = new File("data/out.txt");
		t.writeFile(f);//内容写到文件
		t.readFile(f);//内容读到程序里
	}
	
	//从程序当中把内容写到文件
	public void writeFile(File f) {
		String str = "123456789abcdefg123456789abcdefg";
		OutputStream os = null;
		try {
			os = new FileOutputStream(f);
			os.write(str.getBytes());//字符串转字节数组
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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

	//从文件中把内容读到程序里
	public void readFile(File f) {
		InputStream is = null;
		try {
			is = new FileInputStream(f);
			byte[] b = new byte[1024];
			int len;
			while((len=is.read(b)) != -1) {
				System.out.println(new String(b,0,len));
			}
		} catch (FileNotFoundException e) {
			
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
		}
	}
	
}
