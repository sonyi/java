package collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


/*
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
	
List:
	���з��������ǿ��Բ����Ǳ�ķ������Ǹ���ϵ���еķ�����
	
	����add(index,element);
		assAll(index,collection);
	ɾ��remove(index);
	�ģ�set(index,element);
	�飺get(index);
		subList(from,to);
		listItetator();
	
List�������еĵ�������ListIterator��Iterator���ӽӿڡ�

�ڵ���ʱ��������ͨ�����϶���ķ������������е�Ԫ�ء���Ϊ�ᷢ��
	ConcurrentModificationException�쳣��
	���ԣ��ڵ�����ʱ��ֻ���õ������ķŹ�����Ԫ�أ�����Iterator���������޵ģ�
	ֻ�ܶ�Ԫ�ؽ����жϡ�ȡ����ɾ�������������Ҫ������������ӡ��޸ĵȣ�����Ҫ
	ʹ�����ӽӿ�ListIterator
	
	�ýӿ�ֻ��ͨ��List���ϵ�Iterator������ȡ��
*/



class ListDemo{
	public static void main(String[] args){
		//��ʾ�б������
		ArrayList<String> al = new ArrayList<String>();
		al.add("java01");
		al.add("java02");
		al.add("java03");
		
		//�ڵ��������У�׼����Ӻ�ɾ��Ԫ��
		ListIterator<String> li = al.listIterator();
		while(li.hasNext()){
			Object obj = li.next();
			if(obj.equals("java02"))
				//li.add("java009");//���
				li.set("java006");//�滻
		}
		sop("hasNext:" + li.hasNext());//�����ж�
		sop("hasPrevious:" + li.hasPrevious());//�����ж�

		sop(al);
		
		
	}
	
	public static void method_1(){
		ArrayList<String> al = new ArrayList<String>();
		
		//���Ԫ��
		al.add("java01");
		al.add("java02");
		al.add("java03");
		
		sop("ԭ�����ǣ�" + al);
		//��ָ��λ�����Ԫ��
		al.add(1,"java09");
		sop("���Ԫ�غ󼯺ϣ�" + al);
		
		//ɾ��ָ��λ�õ�Ԫ��
		al.remove(2);
		sop("ɾ��Ԫ�غ󼯺ϣ�" + al);
		
		//�޸�Ԫ��
		al.set(2,"java007");
		sop("�޸�Ԫ�غ󼯺ϣ�" + al);

		//ͨ���Ǳ��ȡԪ��
		sop("get(1):" + al.get(1));
		
		//��ȡ����Ԫ��
		for(int x = 0; x < al.size(); x++){
			System.out.println("al(" + x + ")=" + al.get(x) );
		}
		
		//�õ�������ȡԪ��
		for(Iterator<String> it = al.iterator(); it.hasNext();){
			sop("next:" + it.next());
		}
		
		//ͨ��index��ȡ�����λ��
		sop("index" + al.indexOf("java02"));
		
		//��ȡ�Ӵ�
		List<String> sub = al.subList(1,3);
		sop("sub=" + sub);	
	}
	
	//��װ��ӡ����
	public static void sop(Object obj){
		System.out.println(obj);
	}
}