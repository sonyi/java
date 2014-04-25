package ioFileReaderFileWriter;

import java.io.FileWriter;
import java.io.IOException;

/*
	IO异常的处理方式：
		IO异常的基本处理方式：
 */
public class FileWriterDemo2 {
	public static void main(String[] args) {
		FileWriter fWriter = null;//外部声明
		try {
			fWriter= new FileWriter("e:\\demo.txt");
			fWriter.write("avhd");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				if(fWriter != null)
					fWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

	}

}
