package collection.list;

/*
练习：（重要）
	将自定义对象作为元素存到ArrayList集合中，并去除重复元素
		比如：存人对象。同姓名同年龄的视为同一个人，为重复对象。
		
思路：
	1、对人描述，将数据封装进人对象。
	2、定义容器，将人存入。
	3、取出。
	4、去除重复对象。
	
*******List集合判断元素是否相同，依据的是元素的equals方法。**********
*/


import java.util.*;

class ArrayListTest2{
	public static void main(String[] args){
		ArrayList<Object> al = new ArrayList<Object>();//创建一个集合
		al.add(new Person("lisi01",30));//集合中添加对象
		al.add(new Person("lisi02",30));
		al.add(new Person("lisi03",30));
		al.add(new Person("lisi01",30));
		al.add(new Person("lisi02",35));
		al.add(new Person("lisi04",30));
		
		System.out.println("---------去除重复对象前--------------");
		sopArrayList(al);
		
		System.out.println("---------去除重复对象后--------------");
		al = singleElement(al);
		sopArrayList(al);
		
		System.out.println("---------移除一个元素--------------");
		//调用Person的equals方法，判断移除元素是否与集合内元素相同
		al.remove(new Person("lisi04",30));
		sopArrayList(al);
	}
	
	//打印集合中对象的内容
	public static void sopArrayList(ArrayList<Object> al){
		Iterator<Object> it = al.iterator();
		while(it.hasNext()){
			Person p = (Person)it.next();//向下转型
			sop(p.getName() + "......" + p.getAge());
		}
	}
	
	//打印对象
	public static void sop(Object obj){
		System.out.println(obj);
	}
	
	//去除集合内重复的对象元素
	public static ArrayList<Object> singleElement(ArrayList<Object> al){
		//定义一个临时容器
		ArrayList<Object> newAl = new ArrayList<Object>();
		Iterator<Object> it = al.iterator();
		while(it.hasNext()){//遍历集合中的对象。
			Object obj = it.next();
			if(!newAl.contains(obj))//依据对象的equals方法进行判断
				newAl.add(obj);
		}
		return newAl;
	}
}

//创建一个Person类
class Person{
	private String name;
	private int age;
	Person(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	public String getName(){
		return name;
	}
	
	public int getAge(){
		return age;
	}
	
	//覆写equals方法，判断对象是否相同
	public boolean equals(Object obj){
		if(!(obj instanceof Person))//判断对象是否是Person类对象
			return false;
		Person p = (Person)obj;//向下转型
		return this.name.equals(p.name) && this.age == p.age;
	}
}

