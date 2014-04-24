package collection.list;

import java.util.Enumeration;
import java.util.Vector;


/*
枚举就是vector特有的取出方式。
发现枚举和迭代器很像。其实枚举和迭代是一样的。

因为枚举的名称以及方法的名称都过长，所以枚举被迭代器取代了。
枚举就郁郁而终了。
*/


class VectorDemo{
	public static void main(String[] args){
		Vector<String> v = new Vector<String>();
		v.add("java01");
		v.add("java02");
		v.add("java03");
		v.add("java04");
		
		Enumeration<String> en = v.elements();
		
		while(en.hasMoreElements()){
			System.out.println(en.nextElement());
		}
		
	}
}