package cn.imcore.serial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestObjectInputStream {

	
	public static void main(String[] args) {
		TestObjectInputStream demo = new TestObjectInputStream();
		
//		demo.objToStream();//调用序列化
		demo.streamToObj();//反序列化
	}

	//序列化：把对象转成字节流
	public void objToStream() {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("car.dmp"));
			oos.writeInt(1);
			oos.writeObject(new Car("宝马", 12, 100));
			oos.writeInt(2);
			oos.writeObject(new Car("奔驰", 12, 120));
			oos.writeInt(3);
			oos.writeObject(new Car("奥迪", 11, 80));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	//反序列化：将字节流转成对象
	public void streamToObj() {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("car.dmp"));
			System.out.println(ois.readInt());
			System.out.println(ois.readObject());
			
			System.out.println(ois.readInt());
			System.out.println(ois.readObject());
			
			System.out.println(ois.readInt());
			System.out.println(ois.readObject());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}



