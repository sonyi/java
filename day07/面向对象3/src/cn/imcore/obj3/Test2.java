package cn.imcore.obj3;
/**
 * ת��
 * @author Administrator
 *
 */
public class Test2 {

	//����ת�� ��������Ҫ������ת�Ͳſ�������ת�ͣ� ��������ñ���������������ñ���
	public static void m1(Parent p) {
		if(p instanceof Son) {
			Son son = (Son)p;//����ת��
			son.dancing();
		}
		
		if(p instanceof Daughter) {
			Daughter d = (Daughter)p;//����ת��
			d.drawing();
		}
	}
	
	public static void main(String[] args) {
		
		
		Son s1 = new Son();
		Daughter d1 = new Daughter();
		
//		Daughter d2 = s1;  //�������Ͳ�һ��
		
		//����ת�� ������ָ��������� ������󸳸���������ñ���
		m1(s1);//����ת��
		m1(d1);
	}
}
