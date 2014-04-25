package cn.imcore.extend2;
/**
 * super的应用
 * @author Administrator
 *
 */
public class Test {

	public static void main(String[] args) {
		//子类对象
		A1 a1 = new A1();
		
		A2 a2 = new A2();
	}
}

class A{
	int a = 100;
	int b = 100;
	
	public A() {
		System.out.println("父类A");
	}
	
	public A(String s) {
		System.out.println(s);
	}
}

class A1 extends A{
	int a = 1000;
	
	public A1() {
		//super(); 默认是调用无参数的父类构造方法
		super("hahaha");
		System.out.println("子类A1=" + a);//当前类的 a
		System.out.println("父类的a=" + super.a);//调用父类的属性
	}
}

class A2 extends A{
	int b = 1000;
	public A2() {
		System.out.println("子类A2");
	}
}