package cn.imcore.test1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestMap {

	public static void main(String[] args){
		Map map = new HashMap();
		map.put(8, "888");
		map.put(4, "444");
		map.put(3, "333");
		map.put(1, "111");
		map.put(2, "222");
		map.put(5, "111");
		
		System.out.println(map);
		System.out.println("根据Key取值：" + map.get(4));
		System.out.println("删除Key为2：" + map.remove(2));
		
		System.out.println("加Key为4的内容为aaa：" + map.put(4, "aaa"));
		System.out.println(map);
		System.out.println("是否包含Key 3：" + map.containsKey(3));//true
		System.out.println("是否包含value 111：" + map.containsValue("111"));//true
		System.out.println("size:" + map.size());
		
		Set keyset = map.keySet();
		System.out.println("键的集合：" + keyset);
		System.out.println("值的集合：" + map.values());
		
		//Map不能直接遍历，要先转成keySet，然后再遍历
		Iterator it = keyset.iterator();
		while(it.hasNext()) {
			int key = (int) it.next();//取到key值
			System.out.println(key + "," + map.get(key));
		}
	}
}
