package cn.imcore.test;

import java.util.HashSet;
import java.util.Set;

public class TestSet {

	public static void main(String[] args) {
		Set set = new HashSet();
		set.add(new Person("����1", 20));
		set.add(new Person("����2", 23));
		set.add(new Person("����3", 24));
		
		System.out.println(set);
	}
}
