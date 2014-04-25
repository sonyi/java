package cn.imcore.method;

public class Test2 {

	public void plus() {//无参
		int a = 2, b = 3;
		long sum = a + b;
		System.out.println("和=" + sum);
	}
	
	public void plus(int a) {//1个int类型的参数
		int b = 3;
		long sum = a + b;
		System.out.println("和=" + sum);
	}
	
	public long plus(int a, int b) {//2个int类型的参数
		long sum = a + b;
		return sum;
	}
	
	public double plus(double a, int b) {//2个参数，相对前面的方法，区别参数类型不一样
		double sum = a + b;
		return sum;
	}
	
	public double plus(double a, double b, double c) {//2个参数，相对前面的方法，区别参数类型不一样
		double sum = a + b + c;
		return sum;
	}
	
	public static void main(String[] args) {
		Test2 t = new Test2();
		long s1 = t.plus(2, 3);
		double d1 = t.plus(2.0, 3);
	}
}
