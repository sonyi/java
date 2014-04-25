package cn.imcore.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("555");
		list.add("333");
		list.add("111");
		list.add("222");
		list.add("888");

		Object[] obj = list.toArray();
		Arrays.sort(obj);
		System.out.println(Arrays.toString(obj));
		
		//
		Collections.sort(list);
		System.out.println(list);
		Collections.reverse(list);
		System.out.println("µ¹Ðò£º" + list);
	}

}
