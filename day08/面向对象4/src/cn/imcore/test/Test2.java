package cn.imcore.test;

public class Test2 {
	public static void m1(Object obj) {
//		Person w = (Person)p;
//		w.eat();
		if(obj instanceof Son) {
			Son s = (Son)obj;
			s.dance();
			s.sing();
		}
		
		if(obj instanceof Person) {
			Person man = (Person)obj;
			man.eat();
		}
	}
	
	public static void main(String[] args) {
		Son son = new Son();
		
		Person per = new Person();
		m1(son);
		m1(per);
		
	}
}
