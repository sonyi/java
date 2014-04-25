package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
	集合框架的工具类：
		collections：
 */
public class CollectionsDemo {
	public static void main(String[] args) {

		sortDemo();
//		maxDemo();
//		binarySearchDemo();
	}
	
	public static void binarySearchDemo(){
		List<String> list = new ArrayList<String>();
		list.add("abcd");
		list.add("ad");
		list.add("a");
		list.add("qq");
		list.add("zzz");
		list.add("dsd");
		
		Collections.sort(list);
		System.out.println(list);//
		int index = Collections.binarySearch(list, "aa");
		System.out.println("index:" + index);
		
		int index1 = halfSearch(list,"qq");
		System.out.println("index1:" + index1);
		
		Collections.sort(list,new strLengthSort());
		System.out.println(list);
		int index2 = halfSearch2(list,"qq",new strLengthSort());
		System.out.println("index2:" + index2);
	}
	
	public static int halfSearch(List<String> list,String key){
		int max,min,mid;
		max = list.size()-1;
		min = 0;
		while(min <= max){
			mid = (max + min)>>1;
			String str = list.get(mid);
			int num = str.compareTo(key);
			if(num > 0)
				max = mid - 1;
			else if(num < 0)
				min = mid + 1;
			else 
				return mid;
		}
		return -min-1;
	}
	
	public static int halfSearch2(List<String> list,String key,Comparator<String> cmp){
		int max,min,mid;
		max = list.size()-1;
		min = 0;
		while(min <= max){
			mid = (max + min)>>1;
			String str = list.get(mid);
			int num = cmp.compare(str, key);
			if(num > 0)
				max = mid - 1;
			else if(num < 0)
				min = mid + 1;
			else 
				return mid;
		}
		return -min-1;
	}
	
	public static void  maxDemo(){
		List<String> list = new ArrayList<String>();
		list.add("abcd");
		list.add("ad");
		list.add("a");
		list.add("qq");
		list.add("zzz");
		list.add("dsd");
		
		String max = Collections.max(list);//调用工具，获取最大值
		System.out.println(max);
		
		String max1 = Collections.max(list,new strLengthSort());//特点比较（按长度）获取最大值
		System.out.println(max1);	
	}
	
	
	public static void sortDemo(){
		List<String> list = new ArrayList<String>();
		list.add("abcd");
		list.add("ad");
		list.add("a");
		list.add("qq");
		list.add("zzz");
		list.add("dsd");
			
		System.out.println(list);//无排序
		//Collections.sort(list);//调用工具，自然排序
		Collections.swap(list, 1, 2);//置换集合内两元素。
		System.out.println(list);	
		
		Collections.sort(list,new strLengthSort());//特点排序（按照字符串长度排序）
		System.out.println(list);	
	}
}

//创建比较器，按照字符串长度比较
class strLengthSort implements Comparator<String>{

	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		if(o1.length() == o2.length())
			return o1.compareTo(o1);
		else return o1.length() - o2.length();
	}
}
