package cn.imcore.file;

import java.io.File;
import java.io.IOException;

public class Test3 {

	public static void main(String[] args) {
		File f = new File("D:/temp/file.txt");//����·��
		if(!f.exists()){//�ж��ļ��Ƿ����
			System.out.println("�ļ������ڣ������ļ�");
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
	}
}
