package cn.imcore.test;
/**
 * ȫ�ֱ��������ڲ����������ⲿ
 * �ֲ������������ڲ�
 * @author Administrator
 *
 */
public class Test1 {
    public static String name;
	static int age;
	
	public static void main(String[] args) {
		int age = 20;//�ֲ������������ʼ��
		System.out.println("main:" + age);
		printMsg();//���÷���
	}
	
	//������
	public static void printMsg(){
		System.out.println(name + "," + age);//ȫ�ֱ���
	}
	
}
