package cn.imcore.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * ×ª»»Á÷
 * @author user
 *
 */
public class TestInputStreamReader2 {
    
	public static void main(String[] args) {
		BufferedReader in = null;
		try {
			in = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("data/utf8.txt"),
							"utf-8"));
			String str;
			while((str = in.readLine()) != null) {
				System.out.println(str);
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
