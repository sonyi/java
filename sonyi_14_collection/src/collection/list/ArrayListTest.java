package collection.list;


import java.util.ArrayList;
import java.util.Iterator;

/*
练习：
	去除ArrayList集合中的重复元素
*/

class ArrayListTest{
	public static void main(String[] args){
		ArrayList<Object> al = new ArrayList<Object>();
		al.add("java01");
		al.add("java02");
		al.add("java01");
		al.add("java03");
		al.add("java02");
		al.add("java04");
		
		/*
		在迭代时，循环中的next调用一次，就要hasNext判断一次。
		Iterator it = al.iterator();
		while(it.hasNext()){// 判断一次hasNext，使用两次next，可能出现元素不存在异常。
			sop(it.next() + "......." + it.next());
		}
		*/
		sop(al);
		al = singleElement(al);
		sop(al);
	}
	
	public static ArrayList<Object> singleElement(ArrayList<Object> al){//去除重复元素
		//定义一个临时容器
		ArrayList<Object> newAl = new ArrayList<Object>();
		Iterator<Object> it = al.iterator();
		while(it.hasNext()){
			Object obj = it.next();
			if(!newAl.contains(obj))//将元素添加到新容器中（重复的不存）
				newAl.add(obj);
		}
		return newAl;
	}
	
	public static void sop(Object obj){
		System.out.println(obj);
	}
}
