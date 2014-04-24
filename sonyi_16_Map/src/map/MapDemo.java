package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*
	Map集合：该集合存储键值对，一对一对往里存，而且要保证键的唯一性。
		1、添加：
			put(key,value);
			putAll(Map<? extends K,? extends v> m);
		2、判断：
			boolean containsKey();
			boolean containsValue()
			isEmpty();
		3、删除：
			void clear();
			remove(key);
		4、获取：
			get(key)
			size();
			values();
			
			entrySet();
			keySet();
			
	Map:
		|--Hashtable:底层是哈希表数据结构，不可以存入null键和null值。该集合是线程同步的。JDK1.0.效率低。
		|--HashMap:底层是哈希表数据结构，允许使用null键和null值，该集合是不同步的。JDK1.2.效率高。
		|--TreeMap:底层是二叉树数据结构。线程不同步，可以用于给Map集合中的键进行排序。
		
	和Set很像。其实Set底层就是用了Map集合。
 */
public class MapDemo {
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>();
		
		//添加元素，如果出现添加时，相同的键，那么后添加的值会覆盖原有键对应的值。
		//并put方法会返回被覆盖的值。		
		System.out.println("put:" + map.put("01", "zhangsan1"));
		System.out.println("put:" + map.put("01", "wangwu1"));
		map.put("02", "zhangsan2");
		map.put("03", "zhangsan3");
		
		System.out.println("containsKey:" + map.containsKey("02"));
		System.out.println("remove:" + map.remove("02"));
		System.out.println("get:" + map.get("01"));
		
		//可以通过get方法的返回值来判断一个键是否存在。通过返回null来判断
		map.put(null, "05");
		map.put("04", null);
		System.out.println("get:" + map.get("04"));
		
		//获取Map集合中所以的值
		Collection<String> coll = map.values();
		System.out.println(coll);
		
		System.out.println(map);
	}
}
