package set;

import java.util.Iterator;
import java.util.TreeSet;
/*
|--Set:Ԫ���������(�����ȡ����˳��һ��һ��)��Ԫ�ز������ظ���
	|-HashSet:�ײ����ݽṹ�ǹ�ϣ��
			  HashSet����α�֤Ԫ��Ψһ�Ե��أ�
				��ͨ��Ԫ�ص�����������hashCode��equals����ɵġ�
				���Ԫ�ص�HashCodeֵ��ͬ���Ż��ж�equals�Ƿ�Ϊtrue��
				���Ԫ�ص�HashCodeֵ��ͬ���Ͳ������equals������
				
			  ע�⣺�����ж�Ԫ���Ƿ���ڣ��Լ�ɾ���Ȳ����������ķ�����Ԫ��
				��hashCode��equals���������ж�hashCode�����������ͬ���ж�equals������
				
	|-TreeSet:�ײ����ݽṹ�Ƕ����������Զ�set�����е�Ԫ�ؽ�������
				�������Ǳ�֤Ԫ��Ψһ�Ե����ݡ�
				��compareTo�����ķ���ֵ�жϴ�С��
				
				TreeSet����
					��һ�ַ�ʽ����Ԫ������߱��Ƚ��ԡ�Ԫ����Ҫʵ��comparable�ӿڣ�
						����compareTo���������ַ�ʽҲ��ΪԪ�ص���Ȼ˳���Ĭ��˳��
					�ڶ��ַ�ʽ����Ԫ�������߱��Ƚ���ʱ�����߾߱��ıȽ��Բ�����Ҫ��ʱ��
						��Ҫ�ü�������߱��Ƚ��ԡ�
						�ڼ���һ��ʼ��ʱ�������˱ȽϷ�ʽ��
						
Set���ϵĹ��ܺ�Collection��һ�µġ�

��ס������ʱ����Ҫ������ͬʱһ��Ҫ�жϴ�Ҫ������

��ϰ��
	����(��һ������ʽ)
		��TreeSet�����д洢�Զ������ѧ����
		����ѧ�������������
*/
public class TreeSetDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TreeSet<Student> ts = new TreeSet<Student>();
		ts.add(new Student("����",26));
		ts.add(new Student("����01",23));
		ts.add(new Student("����",20));
		ts.add(new Student("����02",23));//������ͬʱ���Ƚ�����
		ts.add(new Student("С��",20));
		ts.add(new Student("����",20));//�ظ�Ԫ�ز������´洢
		
		for(Iterator<Student> it = ts.iterator(); it.hasNext();){//��������
			Student s = (Student)it.next();
			System.out.println(s.getName() + "-----" + s.getAge());
		}
	}
}


//ʵ��compareable�ӿڣ��ýӿ�ǿ���ö���߱��Ƚ���
class Student implements Comparable<Object>{
	private String name;
	private int age;
	
	Student(String name,int age){
		this.setName(name);
		this.setAge(age);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	//��дcompareTo���������尴��������ķ���
	public int compareTo(Object o) {
		
		if(!(o instanceof Student))//�ж��Ƿ�����ͬ�࣬������ͬ�����쳣
			throw new RuntimeException("������಻��Student��");
		Student s = (Student)o;
//		System.out.println(this.name + "-----compareTo------" + s.name);
		if(this.age > s.age)
			return 1;
		//���������ͬ�������������������ַ����������Դ���compareTo������
		if(this.age == s.age){
			return this.name.compareTo(s.name);
		}
		return -1;
			
	}
}

