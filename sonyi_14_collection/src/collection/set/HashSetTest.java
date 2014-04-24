package collection.set;

import java.util.HashSet;
import java.util.Iterator;

/*
��ϰ��
	��HashSet�����д����Զ�������˶���
		������������ͬ��Ϊͬһ���ˣ�Ϊ�ظ�Ԫ�ء�
		
	HashSet����α�֤Ԫ��Ψһ�Ե��أ�
		��ͨ��Ԫ�ص�����������hashCode��equals����ɵġ�
		���Ԫ�ص�HashCodeֵ��ͬ���Ż��ж�equals�Ƿ�Ϊtrue��
		���Ԫ�ص�HashCodeֵ��ͬ���Ͳ������equals������
				
*/

class HashSetTest{
	public static void main(String[] args){
		//����HashSet����
		HashSet<PersonHashSet> hs = new HashSet<PersonHashSet>();
		sop("\n---------���Ԫ��-----------");
		hs.add(new PersonHashSet("a1",11));
		hs.add(new PersonHashSet("a2",12));
		hs.add(new PersonHashSet("a3",13));
		hs.add(new PersonHashSet("a4",14));
		
		sop("\n---------�ظ����һ��Ԫ��-----------");
		hs.add(new PersonHashSet("a2",12));
		
		//�ж��Ƿ����һ��Ԫ��
		sop("\n---------�Ƿ����һ��ָ��Ԫ��-----------");
		sop(hs.contains(new PersonHashSet("a4",14)));
		
		//�Ƴ�һ��Ԫ��
		sop("\n---------�Ƴ�һ��Ԫ��-----------");
		hs.remove(new PersonHashSet("a3",13));
		
		sop("\n---------��ӡ�����е�Ԫ��-----------");
		for(Iterator<PersonHashSet> it = hs.iterator(); it.hasNext();){//��������
			PersonHashSet p = (PersonHashSet)it.next();
			sop(p.getName() + "......" + p.getAge());
		}	
	}
	
	public static void sop(Object obj){//��ӡ����
		System.out.println(obj);
	}
}


//����һ��Person��
class PersonHashSet{
	private String name;
	private int age;
	PersonHashSet(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	public String getName(){
		return name;
	}
	
	public int getAge(){
		return age;
	}
	
	//��дHashCode�������ж϶����Ƿ���ͬ�����HashCode��ͬ�����ж�equals����
	public int hashCode(){
		System.out.println(this.name + "-------hashCode");//�����ĸ��������hashCode����
		return name.hashCode() + age*39;
	}
	
	//��дequals�������ж϶����Ƿ���ͬ
	public boolean equals(Object obj){
		if(!(obj instanceof PersonHashSet))//�ж϶����Ƿ���Person�����
			return false;
		PersonHashSet p = (PersonHashSet)obj;//����ת��
		//�����ĸ��������equals�����������ĸ��������Ƚ�
		System.out.println(this.name + "----equals---" + p.name);
		return this.name.equals(p.name) && this.age == p.age;
	}
}
