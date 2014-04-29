package sonyi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class SerializeDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		write();//写
		read();//读
	}
	
	//反序列化
	@SuppressWarnings("unchecked")
	public static void read(){
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("obj.txt"));
			ArrayList<Person> arr = (ArrayList<Person>)ois.readObject();
			for(Person p:arr){//按顺序读取对象
				System.out.println(p);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				if(ois != null)
					ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//序列化
	public static void write(){
		ObjectOutputStream oos = null;
		ArrayList<Person> arr = new ArrayList<Person>();//创建容器装对象
		try {
			oos = new ObjectOutputStream(new FileOutputStream("obj.txt"));
			arr.add(new Person("zhangsan", 25));
			arr.add(new Person("lisi", 26));
			arr.add(new Person("wangwu", 27));
			
			oos.writeObject(arr);//将容器作为对象传递给流	
			//System.out.println(oos);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				if(oos != null)
					oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

class Person implements Serializable{
	private String name;
	private int age;
	Person(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}