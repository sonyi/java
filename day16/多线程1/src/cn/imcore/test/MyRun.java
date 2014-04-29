package cn.imcore.test;

public class MyRun implements Runnable{

	
	public static void main(String[] args) {
		//�ȴ���Runnable����
		MyRun my = new MyRun();
		//�����߳�
		Thread t1 = new Thread(my, "AAA");
		Thread t2 = new Thread(my, "BBB");
		//�����߳�
		t1.start();
		t2.start();

	}

	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
