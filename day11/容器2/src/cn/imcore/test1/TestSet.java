package cn.imcore.test1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TestSet {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("qqq");
		set.add("aaa");
		set.add("www");
		set.add("sss");
		set.add("ttt");
		set.add("aaa");
//		set.add(222);
		System.out.println(set);
		//≈≈–Ú
		Set set2 = new TreeSet();
		set2.addAll(set);
		System.out.println(set2);
		
		//±È¿˙
		Iterator it = set.iterator();
		while(it.hasNext()) {
			String value = (String) it.next();
			if("aaa".equals(value)) {
//				set.remove(value);
				it.remove();
			}
			System.out.println(value);
			
		}
		
		System.out.println(set);
	}
}
