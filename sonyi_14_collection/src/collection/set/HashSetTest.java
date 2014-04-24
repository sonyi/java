package collection.set;

import java.util.HashSet;
import java.util.Iterator;

/*
练习：
	往HashSet集合中存入自定义对象（人对象）
		姓名和年龄相同视为同一个人，为重复元素。
		
	HashSet是如何保证元素唯一性的呢？
		是通过元素的两个方法，hashCode和equals来完成的。
		如果元素的HashCode值相同，才会判断equals是否为true。
		如果元素的HashCode值不同，就不会调用equals方法。
				
*/

class HashSetTest{
	public static void main(String[] args){
		//创建HashSet集合
		HashSet<PersonHashSet> hs = new HashSet<PersonHashSet>();
		sop("\n---------添加元素-----------");
		hs.add(new PersonHashSet("a1",11));
		hs.add(new PersonHashSet("a2",12));
		hs.add(new PersonHashSet("a3",13));
		hs.add(new PersonHashSet("a4",14));
		
		sop("\n---------重复添加一个元素-----------");
		hs.add(new PersonHashSet("a2",12));
		
		//判断是否包含一个元素
		sop("\n---------是否包含一个指定元素-----------");
		sop(hs.contains(new PersonHashSet("a4",14)));
		
		//移除一个元素
		sop("\n---------移除一个元素-----------");
		hs.remove(new PersonHashSet("a3",13));
		
		sop("\n---------打印集合中的元素-----------");
		for(Iterator<PersonHashSet> it = hs.iterator(); it.hasNext();){//遍历集合
			PersonHashSet p = (PersonHashSet)it.next();
			sop(p.getName() + "......" + p.getAge());
		}	
	}
	
	public static void sop(Object obj){//打印对象
		System.out.println(obj);
	}
}


//创建一个Person类
class PersonHashSet{
	private String name;
	private int age;
	PersonHashSet(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	public String getName(){
		return name;
	}
	
	public int getAge(){
		return age;
	}
	
	//覆写HashCode方法，判断对象是否相同，如果HashCode相同，再判断equals方法
	public int hashCode(){
		System.out.println(this.name + "-------hashCode");//测试哪个对象调用hashCode方法
		return name.hashCode() + age*39;
	}
	
	//覆写equals方法，判断对象是否相同
	public boolean equals(Object obj){
		if(!(obj instanceof PersonHashSet))//判断对象是否是Person类对象
			return false;
		PersonHashSet p = (PersonHashSet)obj;//向下转型
		//测试哪个对象调用equals方法，并和哪个对象做比较
		System.out.println(this.name + "----equals---" + p.name);
		return this.name.equals(p.name) && this.age == p.age;
	}
}
