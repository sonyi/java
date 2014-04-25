package cn.imcore.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestPeople {

	public static void main(String[] args) {
		List per = new ArrayList();
		per.add(new People("������1", 50));
		per.add(new People("������2", 80));
		per.add(new People("����", 30));
		per.add(new People("����", 25));
		per.add(new People("����", 45));
		per.add(new People("С��", 30));
		System.out.println("����ǰ��" + per);
        
		Collections.sort(per, new Asc());
		System.out.println("��������" + per);
		
		Collections.sort(per, new Desc());
		System.out.println("��������" + per);
	}
}

class Asc implements Comparator<People>{

	@Override
	public int compare(People o1, People o2) {
		//���������ȣ��밴��������Ļ����Լ�����
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