package cn.imcore.serial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;
/**
 * �������
 * @author user
 *
 */
public class TestObjectInputStream2 {

	
	public static void main(String[] args) {
		TestObjectInputStream2 demo = new TestObjectInputStream2();
		
		demo.objToStream();//�������л�
		demo.streamToObj();//�����л�
	}

	//���л����Ѷ���ת���ֽ���
	public void objToStream() {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("car.dmp"));
//			oos.writeInt(1);
//			oos.writeObject(new Car("����", 12, 100));
//			oos.writeInt(2);
//			oos.writeObject(new Car("����", 12, 120));
//			oos.writeInt(3);
//			oos.writeObject(new Car("�µ�", 11, 80));
			Vector<Car> v = new Vector();
			v.add(new Car("����", 12, 100));
			v.add(new Car("����", 12, 120));
			v.add(new Car("�µ�", 11, 80));
			v.add(new Car("����", 12, 120));
			v.add(new Car("�µ�", 11, 80));
			v.add(new Car("����", 12, 120));
			v.add(new Car("�µ�", 11, 80));
			oos.writeObject(v);
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
	
	//�����л������ֽ���ת�ɶ���
	public void streamToObj() {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("car.dmp"));
			Vector<Car> v = (Vector<Car>) ois.readObject();
//			System.out.println(v.size());
//			for(int i = 0; i<v.size(); i++) {
//				System.out.println(i+1);
//				System.out.println(v.get(i));
//			}
			for(Car car:v) {//��ǿfor
				System.out.println(car);
			}
			
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






