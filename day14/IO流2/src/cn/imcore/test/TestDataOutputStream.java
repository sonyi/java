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
		writeFile(f);//����д���ļ�
		readFile(f);//��ȡ�ļ�
	}

	public static void readFile(File f) {
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(new FileInputStream(f));
			System.out.println(dis.readBoolean());//����˳����д��˳��Ҫһ��
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
			dos.writeBoolean(true);//д��boolean����
			dos.writeDouble(3.14);//д��double����
			dos.writeUTF("���");//д���ַ���
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
