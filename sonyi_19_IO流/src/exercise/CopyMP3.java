package exercise;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
	练习：
		复制MP3文件，通过缓冲区
		
 */
public class CopyMP3 {
	public static void main(String[] args) {
		//方式一：
		long start = System.currentTimeMillis();
		copy_1();
		long end = System.currentTimeMillis();
		System.out.println((end - start) + "毫秒");

	}
	
	//方式一：通过字节流的缓冲区完成复制
	public static void copy_1(){
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		 
		try {
			bis = new BufferedInputStream(new FileInputStream("exercise/01.mp3"));
			bos = new BufferedOutputStream(new FileOutputStream("exercise/02.mp3"));
			int len = 0;
			byte[] buf = new byte[1024];
			while((len = bis.read(buf)) != -1){
				//System.out.println(new String(buf));
				bos.write(buf,0,len);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				if(bis != null)
					bis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(bos != null)
					bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
}
