package cn.imcore.obj3;
/**
 * ���಻�ܷ������������ĳ�Ա(���Ժͷ���)
 * @author Administrator
 *
 */
public class Test {

	public static void main(String[] args) {
		Parent p = new Parent();
		
		Son son = new Son();
		
		Daughter d = new Daughter();
		
		p.sing();
		
		son.dancing();
		son.sing();
		
		d.drawing();
		d.sing();
		
		Parent p1;//�������ࣨ���ࣩ
		Parent p2;//�������ࣨ���ࣩ
		p1 = new Son(); //һ��������������ͱ������ԡ�ָ��������Ķ���
		p2 = new Daughter();
		
		p1.sing();
		p2.sing();
		
		if(p1 instanceof Parent) {
			System.out.println("true");
		} else {
			//
		}
		
		if(p1 instanceof Daughter) {
			System.out.println("p1 �� Daughter��ʵ����");
		} else {
			System.out.println("p1 ���� Daughter��ʵ����");
		}
		
		
		
	}
}
