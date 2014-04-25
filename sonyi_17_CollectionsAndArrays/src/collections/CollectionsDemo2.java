package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/*
	课下练习：
		fill方法可以将list集合中所有元素替换成指定元素。
			将list集合中部分元素替换成指定元素
 * 
 */
public class CollectionsDemo2 {

	public static void main(String[] args) {
		//fillDemo();
		//replaceAllDemo();
		//orderDemo();
		shuffleDemo();
	}
	
	public static void shuffleDemo(){
		List<String> list = new ArrayList<String>();
		list.add("abcd");
		list.add("ad");
		list.add("a");
		list.add("qq");
		list.add("zzz");
		list.add("dsd");
		
		System.out.println(list);
		Collections.shuffle(list);//将集合中的元素按照随机性进行再次排列
		System.out.println(list);
	}
	
	public static void orderDemo(){
		//两种方式将集合按自然顺序的反序排序
		//TreeSet<String> ts = new TreeSet<String>(Collections.reverseOrder()/*new StrComparator()*/);
		//自定义排序方式（按长度排序），将集合按照自定义排序的反序排序
		TreeSet<String> ts = new TreeSet<String>(Collections.reverseOrder(new strLengthSort()));
		
		ts.add("abced");
		ts.add("aa");
		ts.add("kkk");
		ts.add("c");
		
		Iterator<String> it = ts.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
	
	}
	
	public static void replaceAllDemo(){
		List<String> list = new ArrayList<String>();
		list.add("abcd");
		list.add("ad");
		list.add("a");
		list.add("qq");
		list.add("zzz");
		list.add("dsd");
		
		System.out.println(list);
		Collections.replaceAll(list, "ad", "kkk");//替换
		System.out.println(list);
		
		Collections.reverse(list);//反转
		System.out.println(list);
	}
	
	public static void fillDemo(){
		List<String> list = new ArrayList<String>();
		list.add("abcd");
		list.add("ad");
		list.add("a");
		list.add("qq");
		list.add("zzz");
		list.add("dsd");
		
		System.out.println(list);
		Collections.fill(list, "qq");//将集合中元素，全部替换成指定值
		System.out.println(list);
	}

}

//自定义反序排序
class StrComparator implements Comparator<String>{
	public int compare(String s1, String s2){
		return s2.compareTo(s1);
	}
}
