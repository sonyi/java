package cn.imcore.test;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class TestPrintWriter2 {

	
	public static void main(String[] args) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter("data/bbb"), true);
			pw.print("aaaaaaaaaaaaaa");
			pw.println("bbbbbbbbbbbbb");
			pw.println("cccccccccccccc");
//			pw.write("dddddddddddd");
			pw.printf("%1d %2s %3$tY/%3$tm/%3$te", 100, "hello",new Date());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(pw != null) {
				pw.close();
			}
		}

	}

}
