package cn.imcore.test;
/**
 * ������
 * @author user
 *
 */
public class Customer extends Thread{
	private Store s; //�ֿ�
	private int num; //���ѵ�����
	
	public Customer(Store s, int num) {
		this.s = s;
		this.num = num;
	}
	
	public void run() {
		s.custom(num);//�������ѷ���
	}
}
