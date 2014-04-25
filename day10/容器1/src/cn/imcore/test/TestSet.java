package cn.imcore.test;

import java.util.HashSet;
import java.util.Set;

public class TestSet {

	public static void main(String[] args) {
		Set set = new HashSet();
		set.add(new Person("¹úÈÙ1", 20));
		set.add(new Person("¹úÈÙ2", 23));
		set.add(new Person("¹úÈÙ3", 24));
		
		System.out.println(set);
	}
}
