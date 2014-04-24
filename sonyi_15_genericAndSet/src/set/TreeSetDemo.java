package set;

import java.util.Iterator;
import java.util.TreeSet;
/*
|--Set:元素是无序的(存入和取出的顺序不一定一致)，元素不可以重复。
	|-HashSet:底层数据结构是哈希表。
			  HashSet是如何保证元素唯一性的呢？
				是通过元素的两个方法，hashCode和equals来完成的。
				如果元素的HashCode值相同，才会判断equals是否为true。
				如果元素的HashCode值不同，就不会调用equals方法。
				
			  注意：对于判断元素是否存在，以及删除等操作，依赖的方法是元素
				的hashCode和equals方法。先判断hashCode方法，如果相同再判断equals方法。
				
	|-TreeSet:底层数据结构是二叉树。可以对set集合中的元素进行排序。
				二叉树是保证元素唯一性的依据。
				用compareTo方法的返回值判断大小。
				
				TreeSet排序：
					第一种方式：让元素自身具备比较性。元素需要实现comparable接口，
						覆盖compareTo方法。这种方式也成为元素的自然顺序或默认顺序。
					第二种方式：当元素自身不具备比较性时，或者具备的比较性不是需要的时候，
						需要让集合自身具备比较性。
						在集合一初始化时，就有了比较方式。
						
Set集合的功能和Collection是一致的。

记住：排序时当主要条件相同时一定要判断次要条件。

练习：
	需求：(第一种排序方式)
		往TreeSet集合中存储自定义对象学生。
		按照学生年龄进行排序。
*/
public class TreeSetDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TreeSet<Student> ts = new TreeSet<Student>();
		ts.add(new Student("张三",26));
		ts.add(new Student("李四01",23));
		ts.add(new Student("王五",20));
		ts.add(new Student("李四02",23));//年龄相同时，比较姓名
		ts.add(new Student("小王",20));
		ts.add(new Student("王五",20));//重复元素不会重新存储
		
		for(Iterator<Student> it = ts.iterator(); it.hasNext();){//遍历集合
			Student s = (Student)it.next();
			System.out.println(s.getName() + "-----" + s.getAge());
		}
	}
}


//实现compareable接口，该接口强制让对象具备比较性
class Student implements Comparable<Object>{
	private String name;
	private int age;
	
	Student(String name,int age){
		this.setName(name);
		this.setAge(age);
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
	
	//覆写compareTo方法，定义按年龄排序的方法
	public int compareTo(Object o) {
		
		if(!(o instanceof Student))//判断是否是相同类，不是相同类抛异常
			throw new RuntimeException("输入的类不是Student类");
		Student s = (Student)o;
//		System.out.println(this.name + "-----compareTo------" + s.name);
		if(this.age > s.age)
			return 1;
		//如果年龄相同，按照姓名进行排序。字符串本身有自带的compareTo方法。
		if(this.age == s.age){
			return this.name.compareTo(s.name);
		}
		return -1;
			
	}
}

