package cn.imcore.test1;

public class Test1 {
	public static int a;//��̬����,����ı���
	public int b; //��Ա����
	
	
	public static void main(String[] args) {
		a = 10;
		//b = 100; ����ͨ���������
		
		Test1 t1 = new Test1();
		t1.b = 100;
		t1.a = 99;
		
		Test1 t2 = new Test1();
		t2.b = 101;
		t2.a = 999;
		
		Test1 t3 = new Test1();
		t3.b = 102;
		t3.a = 9999;
		
		System.out.println("t1.b = " + t1.b);
		System.out.println("t2.b = " + t2.b);
		System.out.println("t3.b = " + t3.b);
		
		System.out.println("a=" + t1.a);//���ĵ�ֵ
	}	
}
