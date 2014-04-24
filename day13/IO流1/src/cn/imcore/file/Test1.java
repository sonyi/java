package cn.imcore.file;

import java.io.File;

public class Test1 {

	public static void main(String[] args) {
//		File f = new File("D:\\java基础\\day13\\temp.txt");
		File f = new File("D:/java基础/day13/temp.txt");
		
		System.out.println(File.separator);
		System.out.println("文件是否存在：" + f.exists());
		System.out.println("文件是否可读：" + f.canRead());
		System.out.println("文件是否可写：" + f.canWrite());
		System.out.println("是否是目录：" + f.isDirectory());
		System.out.println("是否是文件：" + f.isFile());
		System.out.println("文件长度：" + f.length());
		System.out.println("文件名：" + f.getName());
		System.out.println("文件路径：" + f.getPath());	
		System.out.println("上级目录：" + f.getParent());
				
	}
}
