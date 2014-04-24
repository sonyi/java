package collection.list;

import java.util.LinkedList;


/*
LinkedList特有方法：
	addFirst();
	addLast();
		作为第一个（最后一个）元素，添加到集合中
		
	getFirst();
	getLast();
		获取元素，但不删除元素。会出现NoSuchElementException
		
	removeFirst();
	removeLast();
		获取元素，并删除元素。如果集合中没有元素，会出现NoSuchElementException
		
在JDK1.6出现了替换方法：
	offerFirst();
	offerLast();
		作为第一个（最后一个）元素，添加到集合中
		
	peekFirst();
	peekLast();
		获取元素，但不删除元素。如果集合中没有元素，会返回null
		
	pollFirst();
	pollLast();
		获取元素，并删除元素。如果集合中没有元素，会返回null
	
*/
class LinkedListDemo{
	public static void main(String[] args){
		LinkedList<Object> link = new LinkedList<Object>();
		link.addFirst("java01");
		link.addFirst("java02");
		link.addFirst("java03");
		link.addFirst("java04");		
		sop(link);
	
		
		
	}
	
	public static void sop(Object obj){
		System.out.println(obj);
	}
}