package cn.imcore.test1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestList {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();//限定范围--泛型
		
		list.add("111");
		list.add("999");
		list.add("555");
		list.add("888");
		list.add("333");
//		list.add(333);
		Collections.sort(list); //排序--默认是升序
		System.out.println(list);
		
		//遍历1
		for(int i=0; i<list.size(); i++){
			System.out.println(list.get(i));
		}
		
		System.out.println("=====iterator======");
		//遍历2
		Iterator it = list.iterator();
		while(it.hasNext()) {
			String value = (String) it.next();
//			if("999".equals(value)) {
//				System.out.println(value);
//			}
			System.out.println(value);
		}
	}
}
