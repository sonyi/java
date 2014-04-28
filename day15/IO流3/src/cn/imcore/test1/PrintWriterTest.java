package cn.imcore.test1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

public class PrintWriterTest {

	public static void main(String[] args) {
		PrintWriterTest pwt = new PrintWriterTest();
//		File f = new File("io.txt");
//		pwt.write(f);
//		pwt.print1();
		
		//打印字节流的信息
		OutputStream os = pwt.getOutputStream();
		pwt.printMsg(os);
	}
	
	public OutputStream getOutputStream() {
		OutputStream os = null;
		try {
			os = new FileOutputStream("gbk.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return os;
	}
	
	public void printMsg(OutputStream out) {
		PrintWriter pw = new PrintWriter(out, true);
		pw.println("今天天气不错哦");
	}
	
	public void write(File f) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(f);
			pw.print('e');
			pw.println("eeeee");
//			pw.write("eeeeee");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(pw != null) {
				pw.close();
			}
		}
	}
	
	public void print1() {
		
		PrintStream ps = System.out;
		ps.print('人');		
		
	}

}
