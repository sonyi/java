package cn.imcore.test;

public class Test1 {

	
	public static void main(String[] args) {
		Person p1 = new Person("李宁", 20);
		Person p2 = new Person("李宁", 20);
		
		if(p1 instanceof Person) {
			System.out.println("p1 是 Person的实例化");
		} else {
			System.out.println("p1 不是 Person的实例化");
		}
		
		Parent p = new Parent();
		Son s = new Son();
		
		if(s instanceof Son) {
			System.out.println("s 是 Son的实例化");
		}
		
		if(s instanceof Parent) {
			System.out.println("s 是 Parent的实例化");
		} else {
			System.out.println("s 不是 Parent的实例化");
		}
		
		if(p instanceof Son) {
			System.out.println("p 是 Son的实例化");
		} else {
			System.out.println("p 不是 Son的实例化");
		}
	}
}
