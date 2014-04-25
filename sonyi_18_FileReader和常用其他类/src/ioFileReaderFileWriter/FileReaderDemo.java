package ioFileReaderFileWriter;

//通过字符进行读取
import java.io.IOException;
import java.io.FileReader;

public class FileReaderDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建一个文件读取流对象，和指定名称的文件相关联
		//要保证该文件是已经存在的，如果不存在，会发生异常FileNotFoundException
		FileReader fr = null;
		try {
			fr = new FileReader("demo.txt");
				
			//调用读取流对象的read方法。一次只读一个字符
			int ch =0;
			while((ch = fr.read()) != -1){
				System.out.println((char)ch);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(fr != null)
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}		
	}
}
