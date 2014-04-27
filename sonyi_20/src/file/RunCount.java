package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/*
	目的：记录一个软件的运行次数，并达到一定次数后，给出相应的提示信息
	思路：
		用于记录应用程序运行次数。如果使用次数已经达到，那么给出注册提示
		很容易想到的是计数器，可是该计数器定义在程序中，随着程序的运行而在内存中存在，并进行了自增。
		可是随着该应用程序的退出，该计数器也在内存中消失了。
		下一次再启动该程序，又重新开始从0计数。这样不是我们想要的。
		
		程序即使结束，该计数器的值也存在，下一次程序启动会先加载该计数器的值，并加1后重新存储起来。
		所以要建立一个配置文件，用于记录该软件的使用次数。
		
		该配置文件使用键值对的形式。这样便于阅读数据并操作数据。
		键值对数据是map集合。数据是以文件的形式存储，使用IO技术。
		那么map+io就是properties，配置文件可以实现应用程序的共享。
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
					System.out.println("您好，使用次数已到，拿钱！");
					return ;
				}
			}
			count++;
			prop.setProperty("time", count + "");
			fos = new FileOutputStream(file);
			prop.store(fos, "记录程序使用次数");
				
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
