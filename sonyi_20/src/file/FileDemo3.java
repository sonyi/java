package file;

import java.io.File;

/*
	Ŀ�ģ��г�ָ��Ŀ¼���ļ������ļ��У�������Ŀ¼�е�����
	˼·��
		Ҳ�����г�ָ��Ŀ¼���������ݣ���ΪĿ¼�л���Ŀ¼��ֻҪʹ��ͬһ���г�Ŀ¼���ܵĺ�����ɼ��ɡ�
		���г������г��ֵĻ���Ŀ¼�Ļ����������ٴε��ñ����ܣ�Ҳ���Ǻ��������������
		���ֱ�����ʽ�����߱���ַ���Ϊ�ݹ顣
		
		�ݹ�Ҫע�⣺
			1���޶�����
			2��Ҫע��ݹ�Ĵ��������������ڴ������
 */
public class FileDemo3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File dir = new File("E:/eclipseWorkspace/github/java");
		showDir(dir);
	}
	
	public static void showDir(File dir){
		System.out.println(dir);//��ӡ�ļ�������
		File[] files = dir.listFiles();
		for(int x = 0; x < files.length; x++){
			if(files[x].isDirectory())
				showDir(files[x]);
			else
				System.out.println(files[x]);//��ӡ�ļ�����
		}
	}


}
