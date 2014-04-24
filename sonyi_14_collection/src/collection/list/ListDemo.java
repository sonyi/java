package collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


/*
collection:
	--List:元素是有序的，元素是可以重复的。因为该集合体系有索引。
		--ArrayList:底层的数据结构使用的是数组结构。
			特点：查询、修改速度很快，但是增加、删除稍慢。
				线程不同步。java1.2版本出现。
		--LinkedList:底层使用的是链表数据结构。
			特点：增加、删除速度很快，但是查询、修改稍慢。
		--Vector:底层使用的是数组数据结构。线程同步，增删改查速度慢。
			java1.0版本出现。被ArrayList替代。
		
	--Set:元素是无序的，元素是不可以重复的，集合中没有索引。
	
List:
	特有方法：凡是可以操作角标的方法都是改体系特有的方法。
	
	增：add(index,element);
		assAll(index,collection);
	删：remove(index);
	改：set(index,element);
	查：get(index);
		subList(from,to);
		listItetator();
	
List集合特有的迭代器。ListIterator是Iterator的子接口。

在迭代时。不可以通过集合对象的方法操作集合中的元素。因为会发生
	ConcurrentModificationException异常。
	所以，在迭代器时，只能用迭代器的放过操作元素，可是Iterator方法是有限的，
	只能对元素进行判断、取出和删除操作，如果想要其他操作如添加、修改等，就需要
	使用其子接口ListIterator
	
	该接口只能通过List集合的Iterator方法获取。
*/



class ListDemo{
	public static void main(String[] args){
		//演示列表迭代器
		ArrayList<String> al = new ArrayList<String>();
		al.add("java01");
		al.add("java02");
		al.add("java03");
		
		//在迭代过程中，准备添加后删除元素
		ListIterator<String> li = al.listIterator();
		while(li.hasNext()){
			Object obj = li.next();
			if(obj.equals("java02"))
				//li.add("java009");//添加
				li.set("java006");//替换
		}
		sop("hasNext:" + li.hasNext());//正向判断
		sop("hasPrevious:" + li.hasPrevious());//逆向判断

		sop(al);
		
		
	}
	
	public static void method_1(){
		ArrayList<String> al = new ArrayList<String>();
		
		//添加元素
		al.add("java01");
		al.add("java02");
		al.add("java03");
		
		sop("原集合是：" + al);
		//在指定位置添加元素
		al.add(1,"java09");
		sop("添加元素后集合：" + al);
		
		//删除指定位置的元素
		al.remove(2);
		sop("删除元素后集合：" + al);
		
		//修改元素
		al.set(2,"java007");
		sop("修改元素后集合：" + al);

		//通过角标获取元素
		sop("get(1):" + al.get(1));
		
		//获取所有元素
		for(int x = 0; x < al.size(); x++){
			System.out.println("al(" + x + ")=" + al.get(x) );
		}
		
		//用迭代器获取元素
		for(Iterator<String> it = al.iterator(); it.hasNext();){
			sop("next:" + it.next());
		}
		
		//通过index获取对象的位置
		sop("index" + al.indexOf("java02"));
		
		//获取子串
		List<String> sub = al.subList(1,3);
		sop("sub=" + sub);	
	}
	
	//封装打印对象
	public static void sop(Object obj){
		System.out.println(obj);
	}
}