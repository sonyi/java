package cn.imcore.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestPerson {

	public static void main(String[] args) {
		List per = new ArrayList();
		per.add(new Person("张三丰1", 50));
		per.add(new Person("张三丰2", 80));
		per.add(new Person("李四", 30));
		per.add(new Person("王五", 25));
		per.add(new Person("黎明", 45));
		per.add(new Person("小何", 30));
		System.out.println("排序前：" + per);
        
		Collections.sort(per);
		System.out.println("排序后：" + per);
	}
}


class Person implements Comparable{
	private String name;
	private int age;
	
	public Person(String name, int age){
		this.name = name;
		this.age = age;
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

	@Override
	public String toString() {
		return name + " " + age;
	}

	//按年龄升序排序
//	@Override
//	public int compareTo(Object o) {
//		Person p = (Person)o;
//		int m = this.age-p.age;
//		if(m==0) {//年龄相等，要按姓名排序
//			return this.name.compareTo(p.name);
//		}
//		
//		return m;
//	}
	
	//按年龄降序排序
	public int compareTo(Object o) {
		Person p = (Person)o;
		int m = p.age-this.age;
		if(m==0) {//年龄相等，要按姓名排序
			return p.name.compareTo(this.name);//字符串比较
		}
		
		return m;
	}
	
}