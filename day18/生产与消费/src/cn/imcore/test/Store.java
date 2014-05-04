package cn.imcore.test;
/**
 * �ֿ�
 * @author user
 *
 */
public class Store{
	public static final int max = 100; //�ֿ���������
	private int current = 10; //��ǰ�ֿ�Ĭ����10��

	//�����ķ���(Ҫ�Ѳ�Ʒ�ŵ��ֿ�)
	public synchronized void produce(int num) {
		while(num+current > max) {
			System.out.println(Thread.currentThread().getName() + ":"
					 + "��Ҫ���������Ϊ" + num +",��ǰ���Ϊ" + current + ",�ѳ�����棬��ȴ�������");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		current = current + num;
		System.out.println(Thread.currentThread().getName() + ":"
				 + "��Ҫ���������Ϊ" + num +",��ǰ���Ϊ" + current + ",�����");
		notifyAll();
	}
	
	//����
	public synchronized void custom(int num) {
		while(current < num) {//��ǰ����С��������������Ҫ�ȴ�
			System.out.println(Thread.currentThread().getName() + ":"
					 + "��Ҫ���ѵ�����Ϊ" + num +",��ǰ���Ϊ" + current + ",������������ȴ�������");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		current = current - num;
		System.out.println(Thread.currentThread().getName() + ":"
				 + "��Ҫ���ѵ�����Ϊ" + num +",��ǰ���Ϊ" + current + ",������");
		notifyAll();
	}

}
