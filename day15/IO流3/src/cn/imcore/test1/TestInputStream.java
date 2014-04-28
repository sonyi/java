package cn.imcore.test1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * 字节流
 * @author user
 *
 */
public class TestInputStream {

	public static void main(String[] args) {
		TestInputStream t = new TestInputStream();
		File f = new File("io.txt");
		t.write(f);
		t.read(f);
	}

	public void write(File f) {
		OutputStream os = null;
		try {
			os = new FileOutputStream(f);
			os.write(65);
			os.write("lfdkjfdsljf".getBytes());//字符串转字节数组
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
	
	public void read(File f) {
		InputStream is = null;
		try {
			is = new FileInputStream(f);
//			int temp; 
//			while((temp=is.read()) != -1) {
//				System.out.print(temp);
//			}
			int len;
			byte[] buf = new byte[100];
			while((len=is.read(buf)) != -1) {
				System.out.print(new String(buf,0,len));
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
