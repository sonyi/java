package cn.imcore.test;

public class TestYield extends Thread{

	public void run() {
		int k = 50;
		while(k-- > 0) {
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		TestYield t1 = new TestYield();
		TestYield t2 = new TestYield();
		t1.start();
		t2.start();
		
		Thread.yield();
		
//		Thread.currentThread().yield();
		int k = 50;
		while(k-- > 0) {
			System.out.println("main");
		}
	}

}
