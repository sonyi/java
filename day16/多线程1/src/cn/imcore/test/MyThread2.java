package cn.imcore.test;

public class MyThread2 extends Thread{

	public MyThread2(String name) {
		super(name);
	}
	
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
	
	public static void main(String[] args) {
		//创建线程
		MyThread2 my = new MyThread2("A");
		MyThread2 my2 = new MyThread2("B");
		
//		my.setName("A");
//		my2.setName("B");
		//启动线程
		my.start();
		my2.start();
		
		//下面这个根本不是启动线程，只是调用方法
//		my.run();
//		my2.run();
	}

}
