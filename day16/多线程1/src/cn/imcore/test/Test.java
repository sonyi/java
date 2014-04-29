package cn.imcore.test;

public class Test implements Runnable{
	Timer time = new Timer();
	public static void main(String[] args) {
		Test t1 = new Test();
		new Thread(t1).start();
		new Thread(t1).start();
	}
	
	@Override
	public void run() {
		
		time.add(Thread.currentThread().getName());
	}

}

class Timer{
	static int num;
	static Object obj = new Object();
//	public synchronized void add(String name) {
//		num++;
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println(name+", 你是第"+num+"个使用timer的线程");
//
//	}
	
	public void add(String name) {
		synchronized(obj) {
			num++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name+", 你是第"+num+"个使用timer的线程");
		}
	}
	
}
