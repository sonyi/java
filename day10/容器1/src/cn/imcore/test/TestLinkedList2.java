package cn.imcore.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestLinkedList2 {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();//ջ���Ƚ����
		list.push("aaa");
		list.push("bbb");
		list.push("qqq");
		list.push("ddd");//addFirst(E)
		System.out.println(list);
		list.pop();//removeFirst()
		System.out.println("�Ƴ���" + list);
		
	}
}
