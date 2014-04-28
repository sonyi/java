package cn.imcore.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
/**
 * �ַ�������
 * @author user
 *
 */
public class TestReader2 {

	public static void main(String[] args) {
		//�ļ�->����
		Reader r = null;
		try {
			r = new FileReader("data/temp3.txt");
			
			char[] buf = new char[1024];
			int len;
			while((len = r.read(buf)) != -1) {
				System.out.print(new String(buf,0,len));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(r != null) {
				try {
					r.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
