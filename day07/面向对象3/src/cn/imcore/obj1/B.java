package cn.imcore.obj1;

class A extends Object {
	protected void print(String s) {
		System.out.println(s);
	}

	A() {
		print("A()");
	}

	public void f() {
		print("A:f()");
	}
}

public class B extends A {
	B() {
		//super();
		print("B()");
	}

	public void f() {//������д����ķ���
		print("B:f()");
	}

	public static void main(String arg[]) {
		B b = new B();
		b.f();
	}
}
