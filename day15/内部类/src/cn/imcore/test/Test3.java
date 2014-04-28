package cn.imcore.test;
/**
 * 静态内部类
 * @author user
 *
 */
public class Test3 {

	private int a = 100;//成员变量
	static int b = 101;//静态变量
	
	static class Inner3 {
		int c = 102;
		Inner3() {
			
		}
		
		public void print(){
			System.out.println("c:" + c);
//			System.out.println("a:" + a);//不能访问外部类的非静态成员
//			plus(2, 3);
			div(4,2);
		}
	}
	
	
	public int plus(int a, int b) {//成员方法
		return a+b;
	}
	
	public static int div(int a, int b) {//静态方法
		return a/b;
	}
	
	public static void main(String[] args) {
		//静态内部类如何创建对象
		Test3.Inner3 inner = new Test3.Inner3();
		inner.print();//调用内部类的打印方法

	}

}
