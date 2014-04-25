package cn.imcore.test1;

public class Test3 {
	public static int a;//静态变量,共享的变量
	private int b; //成员变量
	private static Test1 t;//声明对象，null 代表不存在，要用它必须new出来
	
	public Test3() {
		
	}
	
	public Test3(int b) {
		this.b = b;
	}
	
	public static void main(String[] args) {
//		t.b = 9000;
		t = new Test1();
		t.b = 9000;
		////////////
		a = 10;
		//b = 100; 必须通过对象访问
		
		Test3 t1 = new Test3(100);
		t1.a = 99;
		
		Test3 t2 = new Test3(101);
		t2.a = 999;
		
		Test3 t3 = new Test3(102);
		t3.a = 9999;
		
		System.out.println("t1.b = " + t1.b);
		System.out.println("t2.b = " + t2.b);
		System.out.println("t3.b = " + t3.b);
		
		System.out.println("a=" + t1.a);//最后改的值
	}
	
}
