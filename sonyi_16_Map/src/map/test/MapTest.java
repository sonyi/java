package map.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
	练习：
		每一个学生都有对应的归属地。
		学生Student，地址String
		学生属性：姓名，年龄。
		注意：姓名和年龄相同的视为同一个学生，保证学生的唯一性。
		
		思路：
			1、描述学生。
			2、定义map容器。将学生作为键，地址作为值，存入。
			3、获取map集合中的元素。
 */
public class MapTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Student,String> map = new HashMap<Student,String>();
		map.put(new Student("zhangsan1",21), "beijing");
		map.put(new Student("zhangsan3",23), "shenzhen");
		map.put(new Student("zhangsan3",23), "tianjing");
		map.put(new Student("zhangsan4",24), "xiamen");
		map.put(new Student("zhangsan2",22), "shanghai");
		
		System.out.println("----------------第一种获取方式--------------");
		//方式一：
		Set<Student> set = map.keySet();
		Iterator<Student> it = set.iterator();
		while(it.hasNext()){
			Student s = it.next();		
			System.out.println(s + ",地址：" + map.get(s));
		}
		
		System.out.println("----------------第二种获取方式--------------");
		//方式二：
		Set<Map.Entry<Student, String>> set1 = map.entrySet();
		Iterator<Map.Entry<Student, String>> it1 = set1.iterator();
		while(it1.hasNext()){
			Map.Entry<Student, String> me = it1.next();
			Student s1 = me.getKey();
			String addr = me.getValue();
			System.out.println(s1 + ",地址：" + addr);
			
		}	
	}
}

class Student implements Comparable<Student>{
	private String name;
	private int age;
	
	Student(){
		
	}
	Student(String name,int age){
		this.name = name;
		this.age = age;
	}
		
	@Override
	public String toString() {
		return "Student: 姓名：" + name + ", 年龄：" + age ;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		int num = new Integer(age).compareTo(new Integer(o.getAge()));
		if(num == 0)
			return this.getName().compareTo(o.getName());
		return num;
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
