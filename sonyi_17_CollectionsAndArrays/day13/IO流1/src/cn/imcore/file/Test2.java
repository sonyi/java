package cn.imcore.file;

import java.io.File;

public class Test2 {

	public static void main(String[] args) {
		File dir = new File("D:/temp");
		if(!dir.exists()) {//判断目录是否存在
			System.out.println("创建目录");
			dir.mkdir();
		}
		System.out.println(dir.isDirectory());
				
	}
}
