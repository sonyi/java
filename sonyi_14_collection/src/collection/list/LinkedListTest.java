package collection.list;

import java.util.LinkedList;

/*

---------------------必须掌握（重要）-----------------------------

练习：使用LinkedList模拟一个堆栈或者队列数据结构

堆栈：先进后出   如同一个杯子
队列：先进先出   First in, First out FIFO如同一个水管
*/


class LinkedListTest{
	public static void main(String[] args){
		Queue dl = new Queue();
		dl.myAdd("java01");//作为第一个元素添加到集合中
		dl.myAdd("java02");
		dl.myAdd("java03");
		dl.myAdd("java04");
		
		while(!dl.isNull())
			System.out.println(dl.myGet());//获取最后一个元素
	}
}

class Queue{
	private LinkedList<Object> link;
	
	Queue(){//生成一个链表对象
		link = new LinkedList<Object>();
	}
	
	public void myAdd(Object obj){//作为第一个元素添加
		link.addFirst(obj);
	}
	
	public Object myGet(){//获取最后一个元素，并移除
		return link.removeLast();
	}
	public boolean isNull(){//判断集合是否为空
		return link.isEmpty();
	}
}
