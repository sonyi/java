package collection;


/*
1��add�����Ĳ���������object���Ա�����������͵Ķ���
2�������д洢�Ķ��Ƕ�������ã���ַ��

ʲô�ǵ�������
	��ʵ���Ǽ��ϵ�ȡ��Ԫ�صķ�ʽ��
	
collection:
	--List:Ԫ��������ģ�Ԫ���ǿ����ظ��ġ���Ϊ�ü�����ϵ��������
		--ArrayList:�ײ�����ݽṹʹ�õ�������ṹ��
			�ص㣺��ѯ���޸��ٶȺܿ죬�������ӡ�ɾ��������
				�̲߳�ͬ����java1.2�汾���֡�
		--LinkedList:�ײ�ʹ�õ����������ݽṹ��
			�ص㣺���ӡ�ɾ���ٶȺܿ죬���ǲ�ѯ���޸�������
		--Vector:�ײ�ʹ�õ����������ݽṹ���߳�ͬ������ɾ�Ĳ��ٶ�����
			java1.0�汾���֡���ArrayList�����
		
	--Set:Ԫ��������ģ�Ԫ���ǲ������ظ��ģ�������û��������
*/


import java.util.ArrayList;
import java.util.Iterator;

class CollectionDemo{
	public static void main(String[] args){
		//method_1();
		//method_2();
		method_get();
		
		
		
	}
	
	public static void method_get(){
		ArrayList<Object> al = new ArrayList<Object>();
		al.add("java01");//add(obj);
		al.add("java02");
		al.add("java03");
		al.add("java04");
		
		//sop(al);
		
		/*//��ȡ������������ȡ�������е�Ԫ��
		Iterator it = al.iterator();
		while(it.hasNext()){
			sop(it.next());
		}
		*/
		for(Iterator<Object> it = al.iterator(); it.hasNext();){
			sop(it.next());
		}
	}
	
	public static void method_2(){
		//����һ������������ʹ��collection�ӿڵ����ࡣArrayList
		ArrayList<String> al1 = new ArrayList<String>();
		al1.add("java01");//add(obj);
		al1.add("java02");
		al1.add("java03");
		al1.add("java04");
		
		ArrayList<String> al2 = new ArrayList<String>();
		al2.add("java01");//add(obj);
		al2.add("java02");
		al2.add("java05");
		al2.add("java06");
		
		//ȡ������al1��ֻ�ᱣ����al2����ͬ��Ԫ��
		al1.retainAll(al2);
		sop("al1:" + al1);
		sop("al2:" + al2);

		//al1.removeAll(al2);
	}
	
	public static void method_1(){
		//����һ������������ʹ��collection�ӿڵ����ࡣArrayList
		ArrayList<String> al = new ArrayList<String>();
		
		//1�����Ԫ��
		al.add("java01");//add(obj);
		al.add("java02");
		al.add("java03");
		al.add("java04");
		
		//��ӡԭ����
		sop(al);
		
		//3��ɾ��Ԫ��
		al.remove("java02");
		
		//2����ȡ���������ϳ���
		sop("size:" + al.size());
		
		//��ӡ�Ƴ��󼯺�
		sop(al);
			
		//4���ж�Ԫ��
		sop("java03�Ƿ���ڣ�" + al.contains("java03"));
		sop("�����Ƿ�Ϊ�գ�" + al.isEmpty());
		
		//��ռ���
		al.clear();
	}
	
	//�������
	public static void sop(Object obj){
		System.out.println(obj);
	}
}