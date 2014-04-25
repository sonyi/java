package cn.imcore.test;

import java.util.Collection;
import java.util.HashSet;

public class TestCollection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Collection c = new HashSet();
		c.add("b");
        c.add("1");
        c.add("a");
        c.add("b");//ֵ�����ظ�
        System.out.println(c);//��ӡ����
        
        Collection c1 = new HashSet();
        c1.add("aa");
        c1.add("bb");
        c.addAll(c1);//�������������ݼӵ�������
        System.out.println(c);
        c1.clear();
        System.out.println(c1);
        System.out.println("c �Ƿ� ����ָ����Ԫ�� 1 : " + c.contains("1"));//true
        System.out.println("c1 �Ƿ� ����ָ����Ԫ�� 1 : " + c1.contains("1"));//false
        
        Collection c2 = new HashSet();
        c2.add("1");
        c2.add("b");
        System.out.println("c �Ƿ� ����ָ�������� c2��Ԫ�� : " + c.containsAll(c2));//true
	    c.remove("aa");
	    System.out.println(c);
	    System.out.println("c2: " + c2);
	    c.removeAll(c2);
	    System.out.println(c);
	    System.out.println("c1 isEmpty: " + c1.isEmpty());//true
	    System.out.println("c size : " + c.size());//2
	    
	    System.out.println("======for��������======");
	    Object[] obj = c.toArray();
	    for(int i = 0; i<obj.length; i++) {
	    	System.out.println(obj[i]);
	    }
	}

}
