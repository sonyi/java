package io;
//文件续写和换行
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo3 {
	public static void main(String[] args) {
		FileWriter fWriter = null;
		try {//传递一个true值，代表不覆盖已有的文件，并在已有文件的末尾处进行数据续写。
			fWriter = new FileWriter("demo.txt",true);
			fWriter.write("caljdi");
			fWriter.write("\r\nsieids");//\r与\n代表换行
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				fWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
