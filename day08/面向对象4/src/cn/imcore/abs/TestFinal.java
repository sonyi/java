package cn.imcore.abs;

public class TestFinal extends AAA{
	
//	public final void m1() {//final�������ܱ���д
//		System.out.println("AAA");
//	}
	
	public static void main(String[] args) {
		AAA a = new AAA();
//		a.sno = 3;  //ֵ���ܱ��ı�
		
		System.out.println(a.sno);
	}
}


class AAA {
//	public static final int sno;   һ��Ҫ��ֵ
	public static final int sno = 1;
	
	public final void m1() {
		System.out.println("AAA");
	}
}