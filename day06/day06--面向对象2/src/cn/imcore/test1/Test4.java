package cn.imcore.test1;

public class Test4 {

	int a;
	
	public int getA() {
		return a;
	}
	
	public void setA(int a) {
		this.a = a;
	}
	
	public void print(){//��Ա����  ��������.����
		System.out.println(a);
	}
	
	public static void main(String[] args) {
		Test4 test = new Test4();
		test.print();
	}
}
