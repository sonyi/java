package generic;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class GenericDemo7 {
	public static void main(String[] args) {
		TreeSet<Student1> ts = new TreeSet<Student1>(new Comp());
		ts.add(new Student1("abc01"));
		ts.add(new Student1("abc02"));
		ts.add(new Student1("abc03"));
		ts.add(new Student1("abc04"));
		
		Iterator<Student1> it = ts.iterator();
		while(it.hasNext()){
			System.out.println(it.next().getName());
		}
		
		TreeSet<Worker1> ts1 = new TreeSet<Worker1>(new Comp());
		ts1.add(new Worker1("abc----01"));
		ts1.add(new Worker1("abc----02"));
		ts1.add(new Worker1("abc----03"));
		ts1.add(new Worker1("abc----04"));
		
		Iterator<Worker1> it1 = ts1.iterator();
		while(it1.hasNext()){
			System.out.println(it1.next().getName());
		}		
	}
}

//泛型定义父类
class Comp implements Comparator<Person1>{
	public int compare(Person1 s1,Person1 s2){
		return s1.getName().compareTo(s2.getName());
	}
}

class Student1 extends Person1{
	Student1(String name){
		super(name);
	}
}

class Worker1 extends Person1{
	Worker1(String name){
		super(name);
	}
}


class Person1{
	private String name;
	
	Person1(){
		
	}
	Person1(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public String toString(){
		return "Person:" + name;
	}
}