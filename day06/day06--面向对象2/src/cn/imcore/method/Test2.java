package cn.imcore.method;

public class Test2 {

	public void plus() {//�޲�
		int a = 2, b = 3;
		long sum = a + b;
		System.out.println("��=" + sum);
	}
	
	public void plus(int a) {//1��int���͵Ĳ���
		int b = 3;
		long sum = a + b;
		System.out.println("��=" + sum);
	}
	
	public long plus(int a, int b) {//2��int���͵Ĳ���
		long sum = a + b;
		return sum;
	}
	
	public double plus(double a, int b) {//2�����������ǰ��ķ���������������Ͳ�һ��
		double sum = a + b;
		return sum;
	}
	
	public double plus(double a, double b, double c) {//2�����������ǰ��ķ���������������Ͳ�һ��
		double sum = a + b + c;
		return sum;
	}
	
	public static void main(String[] args) {
		Test2 t = new Test2();
		long s1 = t.plus(2, 3);
		double d1 = t.plus(2.0, 3);
	}
}
