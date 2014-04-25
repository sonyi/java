package cn.imcore.extend2;
/**
 * 方法的重写
 * @author Administrator
 *
 */
public class Test3 extends AAA{

//	public double plus(int a, int b) {
//		return a+b;
//	}
	
	public double plus(int a, double b) {//参数类型不一样，方法的重载
		return a+b;
	}
	
	
	public int plus(int a, int b, int c) {//参数个数不一样，方法的重载
		return a+b+c;
	}
	
//	private int plus(int a, int b) {//访问权限
//		return a+b;
//	}
	
	public int plus(int a, int b) {//重写父类的方法
		return a+b;
	}
	
}


class AAA {
	
	public int plus(int a, int b) {
		return a+b;
	}
	
}