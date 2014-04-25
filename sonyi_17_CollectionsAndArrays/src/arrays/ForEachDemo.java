package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
	高级for循环：
		格式：
			for(数据类型 变量名：被遍历的集合(collection)或者数组){
			}
			
		对集合进行遍历：
			只能获取元素，但是不能对集合进行操作。
			而迭代器除了遍历还可以进行remove集合中元素的动作。
			如果使用ListIterator,还可以在遍历过程中对集合进行增删改查的动作。
			
		传统for和高级for有什么区别？
			高级for有一个局限性。必须有被遍历的目标。
			建议：在遍历数组的时候，还是希望使用传统for。因为传统for可以定义角标。     
 */
public class ForEachDemo {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("abd--1");
		al.add("abd--2");
		al.add("abd--3");
		
		//1、高级for循环，用迭代的都可以用高级for循环
		for(String s :al){//简化书写
			//s = "kk";
			System.out.println(s);
		}
		System.out.println(al);
		
		/*
		Iterator<String> it = al.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		*/
		
		//2、遍历数组中元素
		int[] arr = {3,5,1};
		for(int i : arr){
			System.out.println("i:" + i);
		}
		
		
		//3、遍历集合中元素
		HashMap<Integer,String> hm = new HashMap<Integer,String>();
		hm.put(1, "a");
		hm.put(2, "b");
		hm.put(3, "c");
		
		//第一种方式：
		Set<Integer> keySet = hm.keySet();
		for(Integer i : keySet){
			System.out.println(i + "--" + hm.get(i));	
		}
		
		//第二种方式：
		//Set<Map.Entry<Integer,String>> entrySet = hm.entrySet();
		//for(Map.Entry<Integer,String> me : entrySet)
		for(Map.Entry<Integer,String> me : hm.entrySet())
		{
			System.out.println(me.getKey() + "======" + me.getValue());
		}
	}
}
