package cn.imcore.test;
/**
 * ��̬�ڲ���
 * @author user
 *
 */
public class Test3 {

	private int a = 100;//��Ա����
	static int b = 101;//��̬����
	
	static class Inner3 {
		int c = 102;
		Inner3() {
			
		}
		
		public void print(){
			System.out.println("c:" + c);
//			System.out.println("a:" + a);//���ܷ����ⲿ��ķǾ�̬��Ա
//			plus(2, 3);
			div(4,2);
		}
	}
	
	
	public int plus(int a, int b) {//��Ա����
		return a+b;
	}
	
	public static int div(int a, int b) {//��̬����
		return a/b;
	}
	
	public static void main(String[] args) {
		//��̬�ڲ�����δ�������
		Test3.Inner3 inner = new Test3.Inner3();
		inner.print();//�����ڲ���Ĵ�ӡ����

	}

}
