package 题目2;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;

class A{

public static void main (String args[])
{
	ArrayList<Student> students = new ArrayList<Student>();
	  //Tom是姓名,20是年龄
	students.add(new Student("Tom", 20));
	students.add(new Student("Jim", 22));
	students.add(new Student("Tony", 18));
	students.add(new Student("JJ", 12));
	

	
}
}

class Student{
	public String name;
	public int age;
	public Student(String name,int age) {
		this.name = name;
		this.age = age;
	}
}