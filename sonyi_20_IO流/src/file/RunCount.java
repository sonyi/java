package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/*
	Ŀ�ģ���¼һ����������д��������ﵽһ�������󣬸�����Ӧ����ʾ��Ϣ
	˼·��
		���ڼ�¼Ӧ�ó������д��������ʹ�ô����Ѿ��ﵽ����ô����ע����ʾ
		�������뵽���Ǽ����������Ǹü����������ڳ����У����ų�������ж����ڴ��д��ڣ���������������
		�������Ÿ�Ӧ�ó�����˳����ü�����Ҳ���ڴ�����ʧ�ˡ�
		��һ���������ó��������¿�ʼ��0��������������������Ҫ�ġ�
		
		����ʹ�������ü�������ֵҲ���ڣ���һ�γ����������ȼ��ظü�������ֵ������1�����´洢������
		����Ҫ����һ�������ļ������ڼ�¼�������ʹ�ô�����
		
		�������ļ�ʹ�ü�ֵ�Ե���ʽ�����������Ķ����ݲ��������ݡ�
		��ֵ��������map���ϡ����������ļ�����ʽ�洢��ʹ��IO������
		��ômap+io����properties�������ļ�����ʵ��Ӧ�ó���Ĺ���
 */
public class RunCount {
	public static void main(String[] args) {
		Properties prop = new Properties();
		FileInputStream fis = null;
		FileOutputStream fos = null;
		File file = new File("count.ini");	
		try {
			if(!file.exists())
			file.createNewFile();
			fis = new FileInputStream(file);
			prop.load(fis);
			int count = 0;
			String value = prop.getProperty("time");
			if(value != null){
				count = Integer.parseInt(value);	
				if(count >= 5){
					System.out.println("���ã�ʹ�ô����ѵ�����Ǯ��");
					return ;
				}
			}
			count++;
			prop.setProperty("time", count + "");
			fos = new FileOutputStream(file);
			prop.store(fos, "��¼����ʹ�ô���");
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				if(fis != null)
					fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(fos != null)
					fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
