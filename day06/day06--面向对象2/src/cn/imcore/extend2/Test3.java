package cn.imcore.extend2;
/**
 * ��������д
 * @author Administrator
 *
 */
public class Test3 extends AAA{

//	public double plus(int a, int b) {
//		return a+b;
//	}
	
	public double plus(int a, double b) {//�������Ͳ�һ��������������
		return a+b;
	}
	
	
	public int plus(int a, int b, int c) {//����������һ��������������
		return a+b+c;
	}
	
//	private int plus(int a, int b) {//����Ȩ��
//		return a+b;
//	}
	
	public int plus(int a, int b) {//��д����ķ���
		return a+b;
	}
	
}


class AAA {
	
	public int plus(int a, int b) {
		return a+b;
	}
	
}