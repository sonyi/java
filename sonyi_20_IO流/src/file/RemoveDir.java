package file;

import java.io.File;

/*
	Ŀ�ģ�
		ɾ��һ�������ݵ�Ŀ¼��
		ɾ��ԭ��
			��windows�У�ɾ��Ŀ¼������������ɾ����
			��Ȼ�Ǵ�������ɾ��������Ҫ�õ��ݹ顣
		
 */
public class RemoveDir {
	public static void main(String[] args) {
		File dir = new File("e:/delete");
		removeDir(dir);

	}
	public static void removeDir(File dir){
		File[] files = dir.listFiles();
		for(int x = 0; x < files.length; x++){
			if(files[x].isDirectory())
				removeDir(files[x]);
			else 
				System.out.println(files[x].toString() + "::" + files[x].delete());		
		}
		System.out.println(dir + ":: dir ::" + dir.delete());
	}

}
