package collection.list;

import java.util.Enumeration;
import java.util.Vector;


/*
ö�پ���vector���е�ȡ����ʽ��
����ö�ٺ͵�����������ʵö�ٺ͵�����һ���ġ�

��Ϊö�ٵ������Լ����������ƶ�����������ö�ٱ�������ȡ���ˡ�
ö�پ����������ˡ�
*/


class VectorDemo{
	public static void main(String[] args){
		Vector<String> v = new Vector<String>();
		v.add("java01");
		v.add("java02");
		v.add("java03");
		v.add("java04");
		
		Enumeration<String> en = v.elements();
		
		while(en.hasMoreElements()){
			System.out.println(en.nextElement());
		}
		
	}
}