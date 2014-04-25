package cn.imcore.abs;

public class TestFinal extends AAA{
	
//	public final void m1() {//final方法不能被重写
//		System.out.println("AAA");
//	}
	
	public static void main(String[] args) {
		AAA a = new AAA();
//		a.sno = 3;  //值不能被改变
		
		System.out.println(a.sno);
	}
}


class AAA {
//	public static final int sno;   一定要赋值
	public static final int sno = 1;
	
	public final void m1() {
		System.out.println("AAA");
	}
}