package cn.imcore.file;
/*
	File�ೣ��������
		1��������
			boolean createNewFile();��ָ��λ�ô����ļ���������ļ��Ѿ����ڣ�
				�򲻴���������false��������������һ�������������һ��������
				�ļ������ļ��Ѿ����ڣ��Ḳ��
			boolean mkdir();����һ���ļ���Ŀ¼
			boolean mkdirs();�����༶�ļ���Ŀ¼		
		2��ɾ����
			boolean delete();ɾ��ʧ��ʱ����false
			void deleteOnExit();�ڳ����˳�ʱɾ��ָ���ļ�
		3���жϣ�
			canExecute();�Ƿ��ִ��
			canRead();�Ƿ�ɶ�
			canWrite();�Ƿ��д
			compareTo(File pathname);�Ƚ�·����
			exists();�ļ��Ƿ����(���ж��ļ��Ƿ���Ŀ¼���ļ�ʱ��������Ҫ�ж�
				���ļ������װ�������Ƿ����)
			boolean isDirectory();�Ƿ���Ŀ¼
			boolean isFile();�Ƿ����ļ�
			boolean isHidden();�Ƿ��������ļ�
			boolean isAbsolute();�ж��Ƿ��Ǿ���·��
		4����ȡ��Ϣ��
			getName();��ȡ�ļ���
			getPath();��ȡ�ļ�·��
			getParent();�÷������ص��Ǿ���·���еĸ�Ŀ¼�������ȡ�������·��������null
				������·��������һ��Ŀ¼����ô��Ŀ¼���Ƿ��ؽ��
			
			String getAbsolutePath();���ؾ���·���ַ���
			long lastModified();��������޸�ʱ��
			long length();�����ļ�����
			boolean renameTo(File dest);���������ļ���
 */
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
