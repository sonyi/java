package cn.imcore.test1;

public class Test3 {
	public static int a;//��̬����,����ı���
	private int b; //��Ա����
	private static Test1 t;//��������null �������ڣ�Ҫ��������new����
	
	public Test3() {
		
	}
	
	public Test3(int b) {
		this.b = b;
	}
	
	public static void main(String[] args) {
//		t.b = 9000;
		t = new Test1();
		t.b = 9000;
		////////////
		a = 10;
		//b = 100; ����ͨ���������
		
		Test3 t1 = new Test3(100);
		t1.a = 99;
		
		Test3 t2 = new Test3(101);
		t2.a = 999;
		
		Test3 t3 = new Test3(102);
		t3.a = 9999;
		
		System.out.println("t1.b = " + t1.b);
		System.out.println("t2.b = " + t2.b);
		System.out.println("t3.b = " + t3.b);
		
		System.out.println("a=" + t1.a);//���ĵ�ֵ
	}
	
}
