package cn.imcore.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestPeople {

	public static void main(String[] args) {
		List per = new ArrayList();
		per.add(new People("张三丰1", 50));
		per.add(new People("张三丰2", 80));
		per.add(new People("李四", 30));
		per.add(new People("王五", 25));
		per.add(new People("黎明", 45));
		per.add(new People("小何", 30));
		System.out.println("排序前：" + per);
        
		Collections.sort(per, new Asc());
		System.out.println("升序排序：" + per);
		
		Collections.sort(per, new Desc());
		System.out.println("降序排序：" + per);
	}
}

class Asc implements Comparator<People>{

	@Override
	public int compare(People o1, People o2) {
		//如果年龄相等，想按姓名排序的话，自己补充
		return o1.getAge()-o2.getAge();
	}
	
}

class Desc implements Comparator<People>{

	@Override
	public int compare(People o1, People o2) {
		// TODO Auto-generated method stub
		return o2.getAge()-o1.getAge();
	}
	
} 

class People{
	private String name;
	private int age;
	
	public People(String name, int age){
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
}