package collection.list;

import java.util.LinkedList;


/*
LinkedList���з�����
	addFirst();
	addLast();
		��Ϊ��һ�������һ����Ԫ�أ���ӵ�������
		
	getFirst();
	getLast();
		��ȡԪ�أ�����ɾ��Ԫ�ء������NoSuchElementException
		
	removeFirst();
	removeLast();
		��ȡԪ�أ���ɾ��Ԫ�ء����������û��Ԫ�أ������NoSuchElementException
		
��JDK1.6�������滻������
	offerFirst();
	offerLast();
		��Ϊ��һ�������һ����Ԫ�أ���ӵ�������
		
	peekFirst();
	peekLast();
		��ȡԪ�أ�����ɾ��Ԫ�ء����������û��Ԫ�أ��᷵��null
		
	pollFirst();
	pollLast();
		��ȡԪ�أ���ɾ��Ԫ�ء����������û��Ԫ�أ��᷵��null
	
*/
class LinkedListDemo{
	public static void main(String[] args){
		LinkedList<Object> link = new LinkedList<Object>();
		link.addFirst("java01");
		link.addFirst("java02");
		link.addFirst("java03");
		link.addFirst("java04");		
		sop(link);
	
		
		
	}
	
	public static void sop(Object obj){
		System.out.println(obj);
	}
}