package cn.imcore.test;

import java.io.PrintWriter;

/**
 * ��Ա�ڲ���
 */
public class Test1 {
    private int a = 1000;//��Ա����
    static int b = 99; //��̬����

	public class Inner1 {//��Ա�ڲ���
		int a = 100;
		int c;

		Inner1() {
	
		}

		Inner1(int c) {
			this.c = c;
		}
		
		public void print(){
			System.out.println("c:" + c);
			System.out.println("a:" + a);
			System.out.println("a:" + Test1.this.a);
			System.out.println("�����ⲿ��ľ�̬������" + b);
			Test1.this.print();//�ⲿ�෽��
		}	
	}

	public void print() {//��Ա����
		System.out.println("Test1");
	}

	public Inner1 getInner() {
		return new Inner1();
	}

	public static void main(String[] args) {
		//��δ�����Ա�ڲ���
		Test1 t1 = new Test1();
		//��ʽ1
		//Test1.Inner1 inner = t1.new Inner1(3);
		//��ʽ2
		Test1.Inner1 inner = t1.getInner();	
		inner.print();//�����ڲ���Ĵ�ӡ����
	}
}
