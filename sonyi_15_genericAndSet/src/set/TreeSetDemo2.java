package set;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;


/*
 * ��Ԫ�������߱��Ƚ��ԣ����߾߱��ıȽ��Բ�������Ҫ�ģ���ʱ����Ҫ����������߱��Ƚ��ԡ�
 * 
 * ˼·��
 * 		1������һ���࣬ʵ��comparator�ӿڣ�������compare��������Ϊ�Ƚ�����
 * 		2�������˱Ƚ��������Ƚ���������Ϊ�������ݸ�TreeSet���ϵĹ��캯����
 * 
 * ��ϰ��(�ڶ�������ʽ)
 * 		����
 * 			1����TreeSet�����д洢�Զ������ѧ����
			2������ѧ�������������
			3����������ı䣬��Ҫ�������������򣬵��ֲ����޸�ԭ�е��������
			
 * ע�⣺���������򶼴���ʱ���ԱȽ���Ϊ����
 * 
 * 
 */
public class TreeSetDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//���Ƚ�����Ϊ�������ݸ�����
		TreeSet<Student> ts = new TreeSet<Student>(new MyCompare());
		ts.add(new Student("����01",26));
		ts.add(new Student("����04",23));
		ts.add(new Student("����02",20));
		ts.add(new Student("����02",23));//������ͬ���Ƚ�����
		ts.add(new Student("����03",20));
		ts.add(new Student("����04",23));//�����ظ����������
		
		for(Iterator<Student> it = ts.iterator(); it.hasNext();){//��������
			Student s = (Student)it.next();
			System.out.println(s.getName() + "-----" + s.getAge());
		}
	}
}

//�Զ���Ƚ���
class MyCompare implements Comparator<Object>{

	public int compare(Object o1, Object o2) {
		Student s1 = (Student)o1;
		Student s2 = (Student)o2;
		int num = s1.getName().compareTo(s2.getName());
		if(num == 0){
			return s1.getAge()-s2.getAge();//���ַ���Ҳ����
			//����Integer����compareTo����
			//return new Integer(s1.getAge()).compareTo(new Integer(s2.getAge()));
		}
		return num;
	}
}
