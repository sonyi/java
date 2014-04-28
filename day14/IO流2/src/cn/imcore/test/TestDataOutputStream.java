package cn.imcore.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestDataOutputStream {

	
	public static void main(String[] args) {
		File f = new File("data/aaa.dmp");
		writeFile(f);//数据写入文件
		readFile(f);//读取文件
	}

	public static void readFile(File f) {
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(new FileInputStream(f));
			System.out.println(dis.readBoolean());//读的顺序与写的顺序要一样
			System.out.println(dis.readDouble());
			System.out.println(dis.readUTF());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(dis != null) {
				try {
					dis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	//
	public static void writeFile(File f) {
		DataOutputStream dos = null;
		try {
			dos = new DataOutputStream(new FileOutputStream(f));
			dos.writeBoolean(true);//写入boolean数据
			dos.writeDouble(3.14);//写入double数据
			dos.writeUTF("你好");//写入字符串
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(dos != null) {
				try {
					dos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
