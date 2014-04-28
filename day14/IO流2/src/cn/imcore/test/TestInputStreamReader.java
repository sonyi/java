package cn.imcore.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * ×ª»»Á÷
 * @author user
 *
 */
public class TestInputStreamReader {

	public static void main(String[] args) {
		BufferedReader in
		   = new BufferedReader(new InputStreamReader(System.in));

		String str;
		try {
			while((str=in.readLine()) != null) {
				System.out.println("print:" + str);
				if("88".equals(str)) break;
			}
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
