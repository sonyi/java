package cn.imcore.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestPerson {

	public static void main(String[] args) {
		List per = new ArrayList();
		per.add(new Person("������1", 50));
		per.add(new Person("������2", 80));
		per.add(new Person("����", 30));
		per.add(new Person("����", 25));
		per.add(new Person("����", 45));
		per.add(new Person("С��", 30));
		System.out.println("����ǰ��" + per);
        
		Collections.sort(per);
		System.out.println("�����" + per);
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

	//��������������
//	@Override
//	public int compareTo(Object o) {
//		Person p = (Person)o;
//		int m = this.age-p.age;
//		if(m==0) {//������ȣ�Ҫ����������
//			return this.name.compareTo(p.name);
//		}
//		
//		return m;
//	}
	
	//�����併������
	public int compareTo(Object o) {
		Person p = (Person)o;
		int m = p.age-this.age;
		if(m==0) {//������ȣ�Ҫ����������
			return p.name.compareTo(this.name);//�ַ����Ƚ�
		}
		
		return m;
	}
	
}