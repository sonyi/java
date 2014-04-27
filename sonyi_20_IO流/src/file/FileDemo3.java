package file;

import java.io.File;

/*
	目的：列出指定目录下文件或者文件夹，包含子目录中的内容
	思路：
		也就是列出指定目录下所有内容，因为目录中还有目录，只要使用同一个列出目录功能的函数完成即可。
		在列出过程中出现的还是目录的话，还可以再次调用本功能，也就是函数自身调用自身。
		这种表现形式，或者编程手法成为递归。
		
		递归要注意：
			1、限定条件
			2、要注意递归的次数，尽量避免内存溢出。
 */
public class FileDemo3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File dir = new File("E:/eclipseWorkspace/github/java");
		showDir(dir);
	}
	
	public static void showDir(File dir){
		System.out.println(dir);//打印文件夹名称
		File[] files = dir.listFiles();
		for(int x = 0; x < files.length; x++){
			if(files[x].isDirectory())
				showDir(files[x]);
			else
				System.out.println(files[x]);//打印文件名称
		}
	}


}
