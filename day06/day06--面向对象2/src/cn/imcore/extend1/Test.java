package cn.imcore.extend1;

public class Test {

	public static void main(String[] args) {
		A1 a1 = new A1(1000);
		A2 a2 = new A2(1002);
		System.out.println("a1.a=" + a1.getA() + ",a1.b=" + a1.getB());
		System.out.println("a2.a=" + a2.getA() + ",a2.c=" + a2.getC());
	}
	
}
