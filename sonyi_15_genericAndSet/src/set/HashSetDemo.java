package set;

import java.util.HashSet;
import java.util.Iterator;

/*
|--Set:元素是无序的(存入和取出的顺序不一定一致)，元素不可以重复。
	|-HashSet:底层数据结构是哈希表。
			  HashSet是如何保证元素唯一性的呢？
				是通过元素的两个方法，hashCode和equals来完成的。
				如果元素的HashCode值相同，才会判断equals是否为true。
				如果元素的HashCode值不同，就不会调用equals方法。
				
			  注意：对于判断元素是否存在，以及删除等操作，依赖的方法是元素
				的hashCode和equals方法。先判断hashCode方法，如果相同再判断equals方法。
				
	|-TreeSet:可以对set集合中的元素进行排序。
	
Set集合的功能和Collection是一致的。

*/


public class HashSetDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> hs = new HashSet<String>();
		
		hs.add("java04");//添加元素
		hs.add("java05");
		System.out.println(hs.add("java01"));//添加元素，并打印元素是否存在的值
		hs.add("java02");
		hs.add("java03");
		hs.add("java03");
		System.out.println(hs.add("java01"));//元素已经存在，打印出false
		
		
		for(Iterator<String> it = hs.iterator(); it.hasNext();){//遍历集合
			System.out.println(it.next());
		}
	}

}
