package cn.imcore.extend2;

public class Test2 {

	public static void main(String[] args) {
		B1 b1 = new B1();
		B2 b2 = new B2();
	}
}


class B{
	public B() {
		System.out.println("hahaha");
	}
	
	public void print() {
		System.out.println("����B");
	}
}

class B1 extends B{
	public B1() {
		//
		print();
	}
	
	public void print() {
		System.out.println("����B1");
	}
	
}

class B2 extends B{
	public B2() {
		print();
		super.print();//���ø���ķ���
	}
	
	public void print() {
		System.out.println("����B2");
	}
}