package cn.imcore.test;

import java.io.PrintWriter;

/**
 * 成员内部类
 */
public class Test1 {
    private int a = 1000;//成员变量
    static int b = 99; //静态变量

	public class Inner1 {//成员内部类
		int a = 100;
		int c;

		Inner1() {
	
		}

		Inner1(int c) {
			this.c = c;
		}
		
		public void print(){
			System.out.println("c:" + c);
			System.out.println("a:" + a);
			System.out.println("a:" + Test1.this.a);
			System.out.println("访问外部类的静态变量：" + b);
			Test1.this.print();//外部类方法
		}	
	}

	public void print() {//成员方法
		System.out.println("Test1");
	}

	public Inner1 getInner() {
		return new Inner1();
	}

	public static void main(String[] args) {
		//如何创建成员内部类
		Test1 t1 = new Test1();
		//方式1
		//Test1.Inner1 inner = t1.new Inner1(3);
		//方式2
		Test1.Inner1 inner = t1.getInner();	
		inner.print();//调用内部类的打印方法
	}
}
