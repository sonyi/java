package cn.imcore.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestArrayList {

	public static void main(String[] args) {
		List list1 = new ArrayList();
		list1.add("bbb");
		list1.add("aaa");
		list1.add("eee");
		list1.add("bbb");//����ֵ�����ظ�
		System.out.println(list1);
		System.out.println("get(2):" + list1.get(2));
		System.out.println("set(2, sss),���ص��Ǳ��޸ĵ�ֵ��" + list1.set(2, "sss"));
		System.out.println("list1: " + list1);
		list1.remove("bbb");
		System.out.println("list1: " + list1);
		System.out.println("=====����list1===== ");
		for(int i=0; i<list1.size(); i++) {
			System.out.println(list1.get(i));
		}
		
	
	}
}
