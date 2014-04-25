package cn.imcore.prac;

public class Test1 {

	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		a.myMethod(50);
		b.myMethod(50);
	}
	
}


class A {
	
	public void myMethod(int x) {
		x = x + 10;
		System.out.println("x:" + x);//Êä³ö
	}
	
}

class B extends A {
	
	public void myMethod(int x) {
		x = x + 50;
		System.out.println("x:" + x);//Êä³ö
	}
	
}