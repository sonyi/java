package map.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
	��ϰ��
		ÿһ��ѧ�����ж�Ӧ�Ĺ����ء�
		ѧ��Student����ַString
		ѧ�����ԣ����������䡣
		ע�⣺������������ͬ����Ϊͬһ��ѧ������֤ѧ����Ψһ�ԡ�
		
		˼·��
			1������ѧ����
			2������map��������ѧ����Ϊ������ַ��Ϊֵ�����롣
			3����ȡmap�����е�Ԫ�ء�
 */
public class MapTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Student,String> map = new HashMap<Student,String>();
		map.put(new Student("zhangsan1",21), "beijing");
		map.put(new Student("zhangsan3",23), "shenzhen");
		map.put(new Student("zhangsan3",23), "tianjing");
		map.put(new Student("zhangsan4",24), "xiamen");
		map.put(new Student("zhangsan2",22), "shanghai");
		
		System.out.println("----------------��һ�ֻ�ȡ��ʽ--------------");
		//��ʽһ��
		Set<Student> set = map.keySet();
		Iterator<Student> it = set.iterator();
		while(it.hasNext()){
			Student s = it.next();		
			System.out.println(s + ",��ַ��" + map.get(s));
		}
		
		System.out.println("----------------�ڶ��ֻ�ȡ��ʽ--------------");
		//��ʽ����
		Set<Map.Entry<Student, String>> set1 = map.entrySet();
		Iterator<Map.Entry<Student, String>> it1 = set1.iterator();
		while(it1.hasNext()){
			Map.Entry<Student, String> me = it1.next();
			Student s1 = me.getKey();
			String addr = me.getValue();
			System.out.println(s1 + ",��ַ��" + addr);
			
		}	
	}
}

class Student implements Comparable<Student>{
	private String name;
	private int age;
	
	Student(){
		
	}
	Student(String name,int age){
		this.name = name;
		this.age = age;
	}
		
	@Override
	public String toString() {
		return "Student: ������" + name + ", ���䣺" + age ;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		int num = new Integer(age).compareTo(new Integer(o.getAge()));
		if(num == 0)
			return this.getName().compareTo(o.getName());
		return num;
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
}
