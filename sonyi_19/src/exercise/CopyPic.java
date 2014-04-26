package exercise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
	练习：
		目的:复制一个图片
		思路：
			1、用字节读取流对象和图片相关联
			2、用字节写入流对象创建一个图片文件
			3、通过循环读写，完成数据的存储。
			4、关闭资源
 */
public class CopyPic {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		 
		try {
			fis = new FileInputStream("exercise/01.jpg");
			fos = new FileOutputStream("exercise/02.jpg");
			byte[] buf = new byte[1024];
			while(fis.read(buf) != -1){
				fos.write(buf);
				fos.flush();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{	
			try {
				if (fis != null) 
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			try {
				if(fos != null)
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
