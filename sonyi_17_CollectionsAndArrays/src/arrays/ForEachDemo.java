package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
	�߼�forѭ����
		��ʽ��
			for(�������� ���������������ļ���(collection)��������){
			}
			
		�Լ��Ͻ��б�����
			ֻ�ܻ�ȡԪ�أ����ǲ��ܶԼ��Ͻ��в�����
			�����������˱��������Խ���remove������Ԫ�صĶ�����
			���ʹ��ListIterator,�������ڱ��������жԼ��Ͻ�����ɾ�Ĳ�Ķ�����
			
		��ͳfor�͸߼�for��ʲô����
			�߼�for��һ�������ԡ������б�������Ŀ�ꡣ
			���飺�ڱ��������ʱ�򣬻���ϣ��ʹ�ô�ͳfor����Ϊ��ͳfor���Զ���Ǳꡣ     
 */
public class ForEachDemo {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("abd--1");
		al.add("abd--2");
		al.add("abd--3");
		
		//1���߼�forѭ�����õ����Ķ������ø߼�forѭ��
		for(String s :al){//����д
			//s = "kk";
			System.out.println(s);
		}
		System.out.println(al);
		
		/*
		Iterator<String> it = al.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		*/
		
		//2������������Ԫ��
		int[] arr = {3,5,1};
		for(int i : arr){
			System.out.println("i:" + i);
		}
		
		
		//3������������Ԫ��
		HashMap<Integer,String> hm = new HashMap<Integer,String>();
		hm.put(1, "a");
		hm.put(2, "b");
		hm.put(3, "c");
		
		//��һ�ַ�ʽ��
		Set<Integer> keySet = hm.keySet();
		for(Integer i : keySet){
			System.out.println(i + "--" + hm.get(i));	
		}
		
		//�ڶ��ַ�ʽ��
		//Set<Map.Entry<Integer,String>> entrySet = hm.entrySet();
		//for(Map.Entry<Integer,String> me : entrySet)
		for(Map.Entry<Integer,String> me : hm.entrySet())
		{
			System.out.println(me.getKey() + "======" + me.getValue());
		}
	}
}
