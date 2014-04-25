package cn.imcore.test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TestTreeSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Collection c = new TreeSet();
		c.add("q");
		c.add("3");
		c.add("e");
		c.add("5");
		System.out.println(c);
		
		Collection c1 = new HashSet();
		c1 = c;
		System.out.println(c1);
		
		Collection c2 = new HashSet();
		c2.add("uuu");
		c2.add("ccc");
		c2.add("aaa");
		c2.add("fff");
		
		System.out.println(c2);
		Collection c3 = new TreeSet();
//		c3 = c2;
		c3.addAll(c2);
		System.out.println(c3);
		
		Set s1 = new HashSet();
		s1.add("www");
		s1.add("qqq");
		
		System.out.println(s1);
	}

}
