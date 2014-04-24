package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
	Map集合的两种取出方式：
		1、Set<K> keySet:将Map中所有的键存入到Set集合。因为set具备迭代器。
			所有可以迭代方式取出所有的键，再根据get方法，获取每一个键对应的值。
			
			Map集合的取出原理：将map集合转成set集合，再通过迭代器取出。
		2、Set<Map.Entry<K,V>> entrySet:将map集合中的映射关系存入到set集合中，
			而这个关系的数据类型就是Map.Entry.
 */
/*
	Map.Entry:其实Entry也是一个接口，它是Map接口中的一个内部接口。
	
interface Map{
	public static interface Entry{
		public abstract Object getKey();
		public abstract Object getValue();
	}
}

class HashMap implements Map{
	class Hash implements Map.Entry{
		public Object getKey(){}
		public Object getValue(){}
	}
}
 */


public class MapDemo2 {
	public static void main(String[] args) {
		
		Map<String,String> map = new HashMap<String,String>();
		
		map.put("02", "zhangsan2");
		map.put("03", "zhangsan3");
		map.put("01", "zhangsan1");
		map.put("04", "zhangsan4");
		
		//方式二：
		//将map集合中的映射关系取出，存入到set集合中。
		Set<Map.Entry<String, String>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, String>> it = entrySet.iterator();
		while(it.hasNext()){
			Map.Entry<String, String> me = it.next();
			String key = me.getKey();
			String value = me.getValue();
			System.out.println("key:" + key + ",value:" + value);
		}
		
		
		
		/*方式一：
		//先获取map集合的所有键的set集合，可以keySet();
		Set<String> keySet = map.keySet();
		
		//有了Set集合，就可以获取其迭代器
		for(Iterator<String> it = keySet.iterator(); it.hasNext();){
			String key = it.next();
			//有了键可以通过map集合的get方法获取其对应的值。
			String value = map.get(key);
			System.out.println("key:" + key + ",value:" + value);
		}
		*/
	}
}
