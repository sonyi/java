package cn.imcore.test;

public class Test1 {

	
	public static void main(String[] args) {
		Person p1 = new Person("����", 20);
		Person p2 = new Person("����", 20);
		
		if(p1 instanceof Person) {
			System.out.println("p1 �� Person��ʵ����");
		} else {
			System.out.println("p1 ���� Person��ʵ����");
		}
		
		Parent p = new Parent();
		Son s = new Son();
		
		if(s instanceof Son) {
			System.out.println("s �� Son��ʵ����");
		}
		
		if(s instanceof Parent) {
			System.out.println("s �� Parent��ʵ����");
		} else {
			System.out.println("s ���� Parent��ʵ����");
		}
		
		if(p instanceof Son) {
			System.out.println("p �� Son��ʵ����");
		} else {
			System.out.println("p ���� Son��ʵ����");
		}
	}
}
