package set;

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
				
	|-TreeSet:���Զ�set�����е�Ԫ�ؽ�������
	
Set���ϵĹ��ܺ�Collection��һ�µġ�

*/


public class HashSetDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> hs = new HashSet<String>();
		
		hs.add("java04");//���Ԫ��
		hs.add("java05");
		System.out.println(hs.add("java01"));//���Ԫ�أ�����ӡԪ���Ƿ���ڵ�ֵ
		hs.add("java02");
		hs.add("java03");
		hs.add("java03");
		System.out.println(hs.add("java01"));//Ԫ���Ѿ����ڣ���ӡ��false
		
		
		for(Iterator<String> it = hs.iterator(); it.hasNext();){//��������
			System.out.println(it.next());
		}
	}

}
