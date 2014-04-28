package cn.imcore.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TestBufferedWriter {

	
	public static void main(String[] args) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("data/temp1.txt"));
			bw.write("qqqqqqqqq");
			bw.write(13);//  \r �س�
			bw.write(10);//  \n ����
			bw.write("qqqqqqqqq");
			bw.newLine();
			bw.write("qqqqqqqqq");
			bw.newLine();
			bw.write("qqqqqqqqq");
			bw.newLine();
			bw.write("qqqqqqqqq");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
