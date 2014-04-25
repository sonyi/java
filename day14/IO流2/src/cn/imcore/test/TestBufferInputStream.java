package cn.imcore.test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class TestBufferInputStream {

	public static void main(String[] args) {
		
		BufferedInputStream bis = null;
		InputStream is = null;
		try {
			is = new FileInputStream("data/temp1.txt");
			bis = new BufferedInputStream(is);//套接在字节流上
//			bis.read();
			byte[] buf = new byte[100];
			int len;
			while((len=bis.read(buf)) != -1) {//从缓冲区读到程序中
				System.out.print(new String(buf,0,len));
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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
