package cn.imcore.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
/**
 * 字符输出流
 * @author user
 *
 */
public class TestWriter {

	public static void main(String[] args) {
		//程序->文件
		Writer w = null;
		try {
			w = new FileWriter("data/temp3.txt");//默认不追加，覆盖原来的内容
			char[] c = new char[]{'h','e','l','l','0'};
			
			w.write(98);//b
			w.write(c);
			w.write("大家好");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(w != null) {
				try {
					w.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
