package cn.imcore.test;

/**
 * ������
 * @author user
 *
 */
public class Producer extends Thread{
	private Store s; //�ֿ�
	private int num; //���ѵ�����
	
	public Producer(Store s, int num) {
		this.s = s;
		this.num = num;
	}
	
	public void run() {
		s.produce(num);//������������
	}

	
	
}
