package cn.imcore.test;

public class MyThread extends Thread{

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
		MyThread my = new MyThread();
		MyThread my2 = new MyThread();
		
		my.setName("A");
		my2.setName("B");
		//启动线程
		my.start();
		my2.start();

	}

}
