package cn.imcore.obj1;

public class TestObject extends Object{

	private int a;
	private int b;
	
	TestObject() {
		
	}
	
	TestObject(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public void printMsg() {
		System.out.println("a:" + a + ",b:" + b);
	}
	
	
	
	@Override
	public String toString() {
		return "a=" + a + ", b=" + b;
	}

	public static void main(String[] args) {
		TestObject to = new TestObject(1, 2);
		System.out.println("hahaha");
		
		System.out.println(to);
		to.printMsg();
		
	}
	
}
