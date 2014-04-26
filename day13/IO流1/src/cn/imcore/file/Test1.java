package cn.imcore.file;
/*
	File类常见方法：
		1、创建：
			boolean createNewFile();在指定位置创建文件，如果该文件已经存在，
				则不创建，返回false。这个和输出流不一样，输出流对象一建立创建
				文件，而文件已经存在，会覆盖
			boolean mkdir();创建一级文件夹目录
			boolean mkdirs();创建多级文件夹目录		
		2、删除：
			boolean delete();删除失败时返回false
			void deleteOnExit();在程序退出时删除指定文件
		3、判断：
			canExecute();是否可执行
			canRead();是否可读
			canWrite();是否可写
			compareTo(File pathname);比较路径名
			exists();文件是否存在(在判断文件是否是目录或文件时，必须先要判断
				该文件对象封装的内容是否存在)
			boolean isDirectory();是否是目录
			boolean isFile();是否是文件
			boolean isHidden();是否是隐藏文件
			boolean isAbsolute();判断是否是绝对路径
		4、获取信息：
			getName();获取文件名
			getPath();获取文件路径
			getParent();该方法返回的是绝对路径中的父目录，如果获取的是相对路径，返回null
				如果相对路径中有上一层目录，那么该目录就是返回结果
			
			String getAbsolutePath();返回绝对路径字符串
			long lastModified();返回最后修改时间
			long length();返回文件长度
			boolean renameTo(File dest);重新命名文件名
 */
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
