package cn.imcore.file;

import java.io.File;

public class Test2 {

	public static void main(String[] args) {
		File dir = new File("D:/temp");
		if(!dir.exists()) {//�ж�Ŀ¼�Ƿ����
			System.out.println("����Ŀ¼");
			dir.mkdir();
		}
		System.out.println(dir.isDirectory());
				
	}
}
