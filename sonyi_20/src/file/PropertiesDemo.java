package file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/*
	Properties��hashtable�����ࡣҲ����˵���߱�map���ϵ��ص㡣����������洢�ļ�ֵ�Զ����ַ�����
	
	Properties�Ǽ��Ϻ�IO�������ϵļ���������
	
	�ö�����ص㣺�������ڼ�ֵ����ʽ�������ļ�����ô�ڼ�������ʱ����Ҫ�����й̶���ʽ:��-ֵ
 */
public class PropertiesDemo {
	public static void main(String[] args) {
		//setAndGet();
		//method_1();
		loadDemo();

	}
	
	public static void loadDemo(){
		Properties prop = new Properties();
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("info.txt");
			prop.load(fis);//�����е����ݼ��ص�������
			
			//System.out.println(prop);
			prop.setProperty("wangwu", "15");//ֻ���ڴ����޸�
			prop.list(System.out);
			
			//�����ڴ����޸ĺ����Ϣ�洢��Ӳ�̵��ļ���
			fos = new FileOutputStream("info.txt");
			prop.store(fos, "heheh");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//��ʾ����ν����е����ݴ洢��������
	//��Ҫ��info.txt�м�ֵ�����ݴ洢�������н��в���
	/*
	 	˼·��
	 		1����һ������info.txt�ļ������
	 		2����ȡһ�����ݣ�������������"="�����и�
	 		3���Ⱥ������Ϊ�����ұ���Ϊֵ�����뵽properties�����м��ɡ�
	 */
	
	public static void method_1(){
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("info.txt"));
			String line = null;
			Properties prop = new Properties();
			while((line = br.readLine()) != null){
				//System.out.println(line);
				String[] arr = line.split("=");
				prop.setProperty(arr[0], arr[1]);
			}
			System.out.println(prop);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				if(br != null)
					br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	
	
	//���úͻ�ȡԪ��
	public static void setAndGet(){
		Properties prop = new Properties();
		prop.setProperty("zhangsan", "30");
		prop.setProperty("lisi", "39");
		System.out.println(prop);
		
		String value = prop.getProperty("lisi");
		System.out.println(value);
		prop.setProperty("lisi", 89 + "");
		
		Set<String> name = prop.stringPropertyNames();
		for(String s : name){
			System.out.println(s + ": " + prop.getProperty(s));
		}
				
	}

}
