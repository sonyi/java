package collection.list;


import java.util.ArrayList;
import java.util.Iterator;

/*
��ϰ��
	ȥ��ArrayList�����е��ظ�Ԫ��
*/

class ArrayListTest{
	public static void main(String[] args){
		ArrayList<Object> al = new ArrayList<Object>();
		al.add("java01");
		al.add("java02");
		al.add("java01");
		al.add("java03");
		al.add("java02");
		al.add("java04");
		
		/*
		�ڵ���ʱ��ѭ���е�next����һ�Σ���ҪhasNext�ж�һ�Ρ�
		Iterator it = al.iterator();
		while(it.hasNext()){// �ж�һ��hasNext��ʹ������next�����ܳ���Ԫ�ز������쳣��
			sop(it.next() + "......." + it.next());
		}
		*/
		sop(al);
		al = singleElement(al);
		sop(al);
	}
	
	public static ArrayList<Object> singleElement(ArrayList<Object> al){//ȥ���ظ�Ԫ��
		//����һ����ʱ����
		ArrayList<Object> newAl = new ArrayList<Object>();
		Iterator<Object> it = al.iterator();
		while(it.hasNext()){
			Object obj = it.next();
			if(!newAl.contains(obj))//��Ԫ����ӵ��������У��ظ��Ĳ��棩
				newAl.add(obj);
		}
		return newAl;
	}
	
	public static void sop(Object obj){
		System.out.println(obj);
	}
}
