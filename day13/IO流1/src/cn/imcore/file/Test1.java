package cn.imcore.file;

import java.io.File;

public class Test1 {

	public static void main(String[] args) {
//		File f = new File("D:\\java����\\day13\\temp.txt");
		File f = new File("D:/java����/day13/temp.txt");
		
		System.out.println(File.separator);
		System.out.println("�ļ��Ƿ���ڣ�" + f.exists());
		System.out.println("�ļ��Ƿ�ɶ���" + f.canRead());
		System.out.println("�ļ��Ƿ��д��" + f.canWrite());
		System.out.println("�Ƿ���Ŀ¼��" + f.isDirectory());
		System.out.println("�Ƿ����ļ���" + f.isFile());
		System.out.println("�ļ����ȣ�" + f.length());
		System.out.println("�ļ�����" + f.getName());
		System.out.println("�ļ�·����" + f.getPath());	
		System.out.println("�ϼ�Ŀ¼��" + f.getParent());
				
	}
}
