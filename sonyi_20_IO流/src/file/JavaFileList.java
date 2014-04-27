package file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
	Ŀ�ģ�����һ��java�ļ��б��ļ�
	
	˼·��
		1����ָ����Ŀ¼���еݹ�
		2����ȡ�ݹ�������е�java�ļ���·��
		3������Щ·���洢��������
		4���������е�����д�뵽һ���ļ���
		
 */
public class JavaFileList {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File dir = new File("E:/eclipseWorkspace/github/java");
		List<File> list = new ArrayList<File>();
		fileToList(dir, list);
		System.out.println(list.size());
		File file = new File("E:/eclipseWorkspace/github/java/sonyi_20/javaListFile.txt");
		writeToFile(list,file.toString());
	}
	public static void fileToList(File dir, List<File> list){
		//System.out.println(dir.getName());
		File[] files = dir.listFiles();
		for(File file: files){
			if(file.isDirectory()){
				fileToList(file, list);
			}
			else {
				if(file.getName().endsWith(".java"))
					//System.out.println(file.getName());
					list.add(file);
			}
		}
	}
	
	public static void writeToFile(List<File> list,String javaListFile){
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(javaListFile));
			for(File f : list){
				String path = f.getAbsolutePath();
				//System.out.println(path);
				bw.write(path);
				bw.newLine();
				bw.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				if(bw != null)
					bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
