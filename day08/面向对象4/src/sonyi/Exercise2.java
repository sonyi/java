package sonyi;
/*
	��ϰ��
	��дһ������̨Ӧ�ó���������й��ܣ���д�����г��������Ľ����
	   1) ����һ����A����A�б�дһ�����Ա���д�Ĵ�int���Ͳ����ķ���MyMethod�����ڸ÷�����������ݵ�����ֵ��10��Ľ����
	   2) �ٴ���һ����B��ʹ��̳�����A��Ȼ����дA�е�MyMethod��������A�н��յ�����ֵ��50������������
	   3) ��Main�����зֱ𴴽���A����B�Ķ��󣬲��ֱ����MyMethod������
 */
public class Exercise2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		B b = new B();
		System.out.println(a.myMethod(5));//����ķ���
		System.out.println(b.myMethod(5));//����ķ���
	}

}
class B extends A{
	
	public int myMethod(int i){//��д���෽��
		return i + 50;
	}
}

class A{
	
	public int myMethod(int i){
		return i + 10;
	}
}