package cn.imcore.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class TestReader {

	public static void main(String[] args) {
		//ÎÄ¼þ->³ÌÐò
		Reader r = null;
		try {
			r = new FileReader("data/temp3.txt");
			
			int temp;
			while((temp = r.read()) != -1) {
				System.out.print((char)temp);
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
