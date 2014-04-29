package cn.imcore.test;

public class TestIsLive extends Thread{
	
	//线程体
	public void run() {
		System.out.println(Thread.currentThread().isAlive());//true
		int k = 50;
		while(k-- > 0) {
			System.out.println("AAAAAA");
		}
	}
	
	public static void main(String[] args) {
		//创建线程
		TestIsLive t = new TestIsLive();
		System.out.println(t.isAlive());//false
		t.start();//启动线程
		
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
