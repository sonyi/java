package generic;

/*
	���ͣ�?Ϊͨ�����Ҳ�������Ϊռλ����
	���͵��޶���
		? extends E: ���Խ���E���ͻ���E�������͡����ޡ�
		? super E: ���Խ���E���ͻ���E�ĸ����͡����ޡ�
 */

import java.util.ArrayList;
import java.util.Iterator;

public class GenericDemo6 {
	public static void main(String[] args) {

/*��ʽһ����ʽ����
		ArrayList<String> al = new ArrayList<String>();
		
		al.add("abd1");
		al.add("abd1");
		al.add("abd1");

		ArrayList<Integer> all = new ArrayList<Integer>();
		
		all.add(4);
		all.add(7);
		all.add(1);
*/
		
		//��ʽһ����ͨ�ã�printColl(all);���ܲ���
		//printColl(al);
		
		//��ʽ����ʹ��?��T������ͨ�÷���
		//printColl(al);
		//printColl(all);
		
		//��ʽ�����޶����͵�����Ϊĳһ���༰���������
		ArrayList<Student> al = new ArrayList<Student>();	
		al.add(new Student("abc---1"));
		al.add(new Student("abc---2"));
		al.add(new Student("abc---3"));
		printColl(al);
	}
	
	//��ʽ�����޶����͵�����ΪPerson��������
	public static void printColl(ArrayList<? extends Person> al){
		for(Iterator<? extends Person> it = al.iterator();it.hasNext();){
			System.out.println(it.next().getName());
		}
	}
/*
	//��ʽ�������巺�ͣ���ͨ��
	public static void printColl(ArrayList<?> al){
		for(Iterator<?> it = al.iterator();it.hasNext();){
			System.out.println(it.next());
			//����ʹ�ö������еķ�������������
			//it.next().length();
		}
	}
	//��?����T������
//	public static <T>void printColl(ArrayList<T> al){
//		for(Iterator<T> it = al.iterator();it.hasNext();){
//			T t = it.next();            //ʹ��T���Խ��ն��󣬶�ʹ��?�����Խ��ն���
//			System.out.println(it.next());
//		}
//	}
*/	
	
	
	/*��ʽһ�����巺�ͣ����ǲ���ͨ��
	public static void printColl(ArrayList<String> al){
		for(Iterator<String> it = al.iterator();it.hasNext();){
			System.out.println(it.next());
		}
	}
	*/
	
}

class Student extends Person{
	Student(){
		
	}
	Student(String name){
		super(name);
	}
}


class Person{
	private String name;
	Person(){
		
	}
	Person(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
}