package io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
	基本数据类型流对象：
		DataInputStream与DataOutputStream:
			可以用于操作基本数据类型的数据的流对象
 */
public class DataStreamDemo {
	public static void main(String[] args) {
//		writeData();
//		readData();
		 writeUTFDemo();
		 readUTFDemo();
	}
	
	public static void readUTFDemo(){
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(new FileInputStream("utfdata.txt"));
			String s = dis.readUTF();
			System.out.println(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				if(dis != null)
					dis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void writeUTFDemo(){
		DataOutputStream dos = null;
		try {
			dos = new DataOutputStream(new FileOutputStream("utfdata.txt"));
			dos.writeUTF("你好");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				if(dos != null)
					dos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void readData(){
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(new FileInputStream("data.txt"));
			int num = dis.readInt();
			boolean b = dis.readBoolean();
			double d = dis.readDouble();
			
			System.out.println("num = " + num);
			System.out.println("b = " + b);
			System.out.println("d = " + d);			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				if(dis != null)
					dis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void writeData(){
		DataOutputStream dos = null;
		try {
			dos = new DataOutputStream(new FileOutputStream("data.txt"));
			dos.writeInt(124);
			dos.writeBoolean(true);
			dos.writeDouble(9887.123);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				if(dos != null)
					dos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
