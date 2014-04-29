package cn.imcore.test;

public class TestIsLive extends Thread{
	
	//�߳���
	public void run() {
		System.out.println(Thread.currentThread().isAlive());//true
		int k = 50;
		while(k-- > 0) {
			System.out.println("AAAAAA");
		}
	}
	
	public static void main(String[] args) {
		//�����߳�
		TestIsLive t = new TestIsLive();
		System.out.println(t.isAlive());//false
		t.start();//�����߳�
		
		System.out.println("main......");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(t.isAlive());//false

	}

}
