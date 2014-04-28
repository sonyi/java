package cn.imcore.test1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestBuffered {


	 
	public static void main(String[] args) {
		TestBuffered T = new TestBuffered();
		File f = new File("io2.txt"); 
	    T.write(f);
	    T.read(f);
	    

	}
	
	public void write(File f){
		BufferedOutputStream BOS = null;
		try {
			BOS = new BufferedOutputStream(new FileOutputStream(f));
			
		    BOS.write(52);
		    BOS.write('s');
		    BOS.write("sd".getBytes());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(BOS!=null){
				try {
					BOS.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void read(File f)  {
		BufferedInputStream BIS = null;
		try {
			BIS = new BufferedInputStream(new FileInputStream(f));
//			int temp;
//			while((temp = BIS.read())!=-1){
//				System.out.print(temp);
//			}
			
			int len;
			byte[] b = new byte[100];
			while((len =BIS.read(b))!=-1){
				System.out.print(new String(b,0,len));
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(BIS!=null){
				try {
					BIS.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
