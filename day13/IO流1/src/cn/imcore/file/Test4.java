package cn.imcore.file;

import java.io.File;
import java.io.IOException;

public class Test4 {

	public static void main(String[] args) {
		File f = new File("data/file.txt");//相对路径
		if(!f.exists()){//判断文件是否存在
			System.out.println("文件不存在，创建文件");
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
	}
}
