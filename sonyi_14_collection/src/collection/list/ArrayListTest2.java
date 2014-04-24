package collection.list;

/*
��ϰ������Ҫ��
	���Զ��������ΪԪ�ش浽ArrayList�����У���ȥ���ظ�Ԫ��
		���磺���˶���ͬ����ͬ�������Ϊͬһ���ˣ�Ϊ�ظ�����
		
˼·��
	1�����������������ݷ�װ���˶���
	2���������������˴��롣
	3��ȡ����
	4��ȥ���ظ�����
	
*******List�����ж�Ԫ���Ƿ���ͬ�����ݵ���Ԫ�ص�equals������**********
*/


import java.util.*;

class ArrayListTest2{
	public static void main(String[] args){
		ArrayList<Object> al = new ArrayList<Object>();//����һ������
		al.add(new Person("lisi01",30));//��������Ӷ���
		al.add(new Person("lisi02",30));
		al.add(new Person("lisi03",30));
		al.add(new Person("lisi01",30));
		al.add(new Person("lisi02",35));
		al.add(new Person("lisi04",30));
		
		System.out.println("---------ȥ���ظ�����ǰ--------------");
		sopArrayList(al);
		
		System.out.println("---------ȥ���ظ������--------------");
		al = singleElement(al);
		sopArrayList(al);
		
		System.out.println("---------�Ƴ�һ��Ԫ��--------------");
		//����Person��equals�������ж��Ƴ�Ԫ���Ƿ��뼯����Ԫ����ͬ
		al.remove(new Person("lisi04",30));
		sopArrayList(al);
	}
	
	//��ӡ�����ж��������
	public static void sopArrayList(ArrayList<Object> al){
		Iterator<Object> it = al.iterator();
		while(it.hasNext()){
			Person p = (Person)it.next();//����ת��
			sop(p.getName() + "......" + p.getAge());
		}
	}
	
	//��ӡ����
	public static void sop(Object obj){
		System.out.println(obj);
	}
	
	//ȥ���������ظ��Ķ���Ԫ��
	public static ArrayList<Object> singleElement(ArrayList<Object> al){
		//����һ����ʱ����
		ArrayList<Object> newAl = new ArrayList<Object>();
		Iterator<Object> it = al.iterator();
		while(it.hasNext()){//���������еĶ���
			Object obj = it.next();
			if(!newAl.contains(obj))//���ݶ����equals���������ж�
				newAl.add(obj);
		}
		return newAl;
	}
}

//����һ��Person��
class Person{
	private String name;
	private int age;
	Person(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	public String getName(){
		return name;
	}
	
	public int getAge(){
		return age;
	}
	
	//��дequals�������ж϶����Ƿ���ͬ
	public boolean equals(Object obj){
		if(!(obj instanceof Person))//�ж϶����Ƿ���Person�����
			return false;
		Person p = (Person)obj;//����ת��
		return this.name.equals(p.name) && this.age == p.age;
	}
}

