package cn.imcore.extend2;
/**
 * super��Ӧ��
 * @author Administrator
 *
 */
public class Test {

	public static void main(String[] args) {
		//�������
		A1 a1 = new A1();
		
		A2 a2 = new A2();
	}
}

class A{
	int a = 100;
	int b = 100;
	
	public A() {
		System.out.println("����A");
	}
	
	public A(String s) {
		System.out.println(s);
	}
}

class A1 extends A{
	int a = 1000;
	
	public A1() {
		//super(); Ĭ���ǵ����޲����ĸ��๹�췽��
		super("hahaha");
		System.out.println("����A1=" + a);//��ǰ��� a
		System.out.println("�����a=" + super.a);//���ø��������
	}
}

class A2 extends A{
	int b = 1000;
	public A2() {
		System.out.println("����A2");
	}
}