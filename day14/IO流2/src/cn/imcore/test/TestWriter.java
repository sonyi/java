package cn.imcore.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
/**
 * �ַ������
 * @author user
 *
 */
public class TestWriter {

	public static void main(String[] args) {
		//����->�ļ�
		Writer w = null;
		try {
			w = new FileWriter("data/temp3.txt");//Ĭ�ϲ�׷�ӣ�����ԭ��������
			char[] c = new char[]{'h','e','l','l','0'};
			
			w.write(98);//b
			w.write(c);
			w.write("��Һ�");
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
