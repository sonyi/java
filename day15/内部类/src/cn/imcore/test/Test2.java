package cn.imcore.test;
/**
 * 局部内部类
 * @author user
 *
 */
public class Test2 {
	private int a = 97;
	static int b = 98;
	
	public void f1() {
//		int c = 99;
		final int c = 99;//必须是常量 final
		
		class Inner2 {
			int d = 100;
			
			public Inner2() {
				
			}
			
			public void print() {
				System.out.println("d:" + d);
				System.out.println("c:" + c);
				System.out.println("a:" + a);
				System.out.println("b:" + b);
				m1();//
			}
		}
		
		Inner2 inner = new Inner2();//创建局部内部类对象
		inner.print();
	}
	
	public void m1() {
		System.out.println("Test2");
	}
	
	public static void main(String[] args) {
		Test2 test2 = new Test2();
		test2.f1();

	}

}
