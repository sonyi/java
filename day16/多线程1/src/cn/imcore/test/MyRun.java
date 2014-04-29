package cn.imcore.test;

public class MyRun implements Runnable{

	
	public static void main(String[] args) {
		//先创建Runnable对象
		MyRun my = new MyRun();
		//创建线程
		Thread t1 = new Thread(my, "AAA");
		Thread t2 = new Thread(my, "BBB");
		//启动线程
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
