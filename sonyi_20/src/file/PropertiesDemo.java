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
	Properties是hashtable的子类。也就是说它具备map集合的特点。而且它里面存储的键值对都是字符串。
	
	Properties是集合和IO技术相结合的集合容器。
	
	该对象的特点：可以用于键值对形式的配置文件，那么在加载数据时，需要数据有固定格式:键-值
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
			prop.load(fis);//将流中的数据加载到集合中
			
			//System.out.println(prop);
			prop.setProperty("wangwu", "15");//只在内存中修改
			prop.list(System.out);
			
			//将在内存中修改后的信息存储到硬盘的文件内
			fos = new FileOutputStream("info.txt");
			prop.store(fos, "heheh");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//演示：如何将流中的数据存储到集合中
	//想要将info.txt中键值对数据存储到集合中进行操作
	/*
	 	思路：
	 		1、用一个流和info.txt文件相关联
	 		2、读取一行数据，将该行数据用"="进行切割
	 		3、等号左边作为键，右边作为值，存入到properties集合中即可。
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
	
	
	//设置和获取元素
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
