package collection.set;

import java.util.HashSet;
import java.util.Iterator;

/*
|--Set:Ԫ���������(�����ȡ����˳��һ��һ��)��Ԫ�ز������ظ���
	|-HashSet:�ײ����ݽṹ�ǹ�ϣ��
			  HashSet����α�֤Ԫ��Ψһ�Ե��أ�
				��ͨ��Ԫ�ص�����������hashCode��equals����ɵġ�
				���Ԫ�ص�HashCodeֵ��ͬ���Ż��ж�equals�Ƿ�Ϊtrue��
				���Ԫ�ص�HashCodeֵ��ͬ���Ͳ������equals������
				
			  ע�⣺�����ж�Ԫ���Ƿ���ڣ��Լ�ɾ���Ȳ����������ķ�����Ԫ��
				��hashCode��equals���������ж�hashCode�����������ͬ���ж�equals������
	|-TreeSet:
Set���ϵĹ��ܺ�Collection��һ�µġ�

*/


class HashSetDemo{
	public static void main(String[] args){
		HashSet<String> hs = new HashSet<String>();
		
		hs.add("java04");//���Ԫ��
		hs.add("java05");
		sop(hs.add("java01"));//���Ԫ�أ�����ӡԪ���Ƿ���ڵ�ֵ
		hs.add("java02");
		hs.add("java03");
		hs.add("java03");
		sop(hs.add("java01"));//Ԫ���Ѿ����ڣ���ӡ��false
		
		
		for(Iterator<String> it = hs.iterator(); it.hasNext();){//��������
			sop(it.next());
		}
	}
	
	public static void sop(Object obj){//��ӡ����
		System.out.println(obj);
	}
}