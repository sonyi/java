package set;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;


/*
 * 当元素自身不具备比较性，或者具备的比较性不是所需要的，这时就需要让容器自身具备比较性。
 * 
 * 思路：
 * 		1、定义一个类，实现comparator接口，并覆盖compare方法，做为比较器。
 * 		2、定义了比较器，将比较器对象作为参数传递给TreeSet集合的构造函数。
 * 
 * 练习：(第二种排序方式)
 * 		需求：
 * 			1、往TreeSet集合中存储自定义对象学生。
			2、按照学生年龄进行排序。
			3、现在需求改变，需要按照姓名来排序，但又不能修改原有的排序代码
			
 * 注意：当两种排序都存在时，以比较器为主。
 * 
 * 
 */
public class TreeSetDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//将比较器作为参数传递给集合
		TreeSet<Student> ts = new TreeSet<Student>(new MyCompare());
		ts.add(new Student("李四01",26));
		ts.add(new Student("李四04",23));
		ts.add(new Student("李四02",20));
		ts.add(new Student("李四02",23));//姓名相同，比较年龄
		ts.add(new Student("李四03",20));
		ts.add(new Student("李四04",23));//对象重复，不会添加
		
		for(Iterator<Student> it = ts.iterator(); it.hasNext();){//遍历集合
			Student s = (Student)it.next();
			System.out.println(s.getName() + "-----" + s.getAge());
		}
	}
}

//自定义比较器
class MyCompare implements Comparator<Object>{

	public int compare(Object o1, Object o2) {
		Student s1 = (Student)o1;
		Student s2 = (Student)o2;
		int num = s1.getName().compareTo(s2.getName());
		if(num == 0){
			return s1.getAge()-s2.getAge();//这种方法也可行
			//调用Integer类是compareTo方法
			//return new Integer(s1.getAge()).compareTo(new Integer(s2.getAge()));
		}
		return num;
	}
}
