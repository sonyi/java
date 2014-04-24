package collection;


/*
1、add方法的参数类型是object，以便接收任意类型的对象。
2、集合中存储的都是对象的引用（地址）

什么是迭代器：
	其实就是集合的取出元素的方式。
	
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
*/


import java.util.ArrayList;
import java.util.Iterator;

class CollectionDemo{
	public static void main(String[] args){
		//method_1();
		//method_2();
		method_get();
		
		
		
	}
	
	public static void method_get(){
		ArrayList<Object> al = new ArrayList<Object>();
		al.add("java01");//add(obj);
		al.add("java02");
		al.add("java03");
		al.add("java04");
		
		//sop(al);
		
		/*//获取迭代器，用于取出集合中的元素
		Iterator it = al.iterator();
		while(it.hasNext()){
			sop(it.next());
		}
		*/
		for(Iterator<Object> it = al.iterator(); it.hasNext();){
			sop(it.next());
		}
	}
	
	public static void method_2(){
		//创建一个集合容器，使用collection接口的子类。ArrayList
		ArrayList<String> al1 = new ArrayList<String>();
		al1.add("java01");//add(obj);
		al1.add("java02");
		al1.add("java03");
		al1.add("java04");
		
		ArrayList<String> al2 = new ArrayList<String>();
		al2.add("java01");//add(obj);
		al2.add("java02");
		al2.add("java05");
		al2.add("java06");
		
		//取交集，al1中只会保留和al2中相同的元素
		al1.retainAll(al2);
		sop("al1:" + al1);
		sop("al2:" + al2);

		//al1.removeAll(al2);
	}
	
	public static void method_1(){
		//创建一个集合容器，使用collection接口的子类。ArrayList
		ArrayList<String> al = new ArrayList<String>();
		
		//1、添加元素
		al.add("java01");//add(obj);
		al.add("java02");
		al.add("java03");
		al.add("java04");
		
		//打印原集合
		sop(al);
		
		//3、删除元素
		al.remove("java02");
		
		//2、获取个数。集合长度
		sop("size:" + al.size());
		
		//打印移除后集合
		sop(al);
			
		//4、判断元素
		sop("java03是否存在：" + al.contains("java03"));
		sop("集合是否为空：" + al.isEmpty());
		
		//清空集合
		al.clear();
	}
	
	//输出对象
	public static void sop(Object obj){
		System.out.println(obj);
	}
}