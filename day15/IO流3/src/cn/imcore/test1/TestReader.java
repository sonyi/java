package cn.imcore.test1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class TestReader {

	
	public static void main(String[] args) {
		TestReader t = new TestReader();
		File f = new File("io1.txt");
		t.write(f);
		t.read(f);

	}
	
	public void write(File f){
		Writer w = null;
		try {
			w = new FileWriter(f);
			w.write(98);
			w.write("asdasndnf");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(w != null){
				try {
					w.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	//===========================
	public void read(File f){
		Reader r = null;
		try {
			r = new FileReader(f);
//			int temp;
//			while((temp=r.read()) !=-1){
//				System.out.print(temp);
//			}
			int len;
			char[] c = new char[100];
			while((len=r.read(c)) !=-1){
				System.out.print(new String(c,0,len));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(r != null){
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
