package generic;

/*
	泛型：?为通配符。也可以理解为占位符。
	泛型的限定：
		? extends E: 可以接收E类型或者E的子类型。上限。
		? super E: 可以接收E类型或者E的父类型。下限。
 */

import java.util.ArrayList;
import java.util.Iterator;

public class GenericDemo6 {
	public static void main(String[] args) {

/*方式一：方式二：
		ArrayList<String> al = new ArrayList<String>();
		
		al.add("abd1");
		al.add("abd1");
		al.add("abd1");

		ArrayList<Integer> all = new ArrayList<Integer>();
		
		all.add(4);
		all.add(7);
		all.add(1);
*/
		
		//方式一：不通用，printColl(all);不能操作
		//printColl(al);
		
		//方式二：使用?或T，定义通用泛型
		//printColl(al);
		//printColl(all);
		
		//方式三：限定泛型的类型为某一父类及其子类对象
		ArrayList<Student> al = new ArrayList<Student>();	
		al.add(new Student("abc---1"));
		al.add(new Student("abc---2"));
		al.add(new Student("abc---3"));
		printColl(al);
	}
	
	//方式三：限定泛型的类型为Person及其子类
	public static void printColl(ArrayList<? extends Person> al){
		for(Iterator<? extends Person> it = al.iterator();it.hasNext();){
			System.out.println(it.next().getName());
		}
	}
/*
	//方式二：定义泛型，可通用
	public static void printColl(ArrayList<?> al){
		for(Iterator<?> it = al.iterator();it.hasNext();){
			System.out.println(it.next());
			//不能使用对象特有的方法，如下例：
			//it.next().length();
		}
	}
	//用?和用T的区别：
//	public static <T>void printColl(ArrayList<T> al){
//		for(Iterator<T> it = al.iterator();it.hasNext();){
//			T t = it.next();            //使用T可以接收对象，而使用?不可以接收对象。
//			System.out.println(it.next());
//		}
//	}
*/	
	
	
	/*方式一：定义泛型，但是不能通用
	public static void printColl(ArrayList<String> al){
		for(Iterator<String> it = al.iterator();it.hasNext();){
			System.out.println(it.next());
		}
	}
	*/
	
}

class Student extends Person{
	Student(){
		
	}
	Student(String name){
		super(name);
	}
}


class Person{
	private String name;
	Person(){
		
	}
	Person(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
}