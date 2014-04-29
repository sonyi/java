package cn.imcore.test;

public class TestPriority extends Thread{

	public TestPriority(String name) {
		super(name);
	}
	
	public void run() {
		int k = 10;
		while(k-- > 0) {
			System.out.println(Thread.currentThread().getName() + ":" + k);
		}
		
	}
	
	public static void main(String[] args) {
		TestPriority t1 = new TestPriority("张三");
		TestPriority t2 = new TestPriority("李四");
		TestPriority t3 = new TestPriority("王五");

		System.out.println(t1.getPriority());//5
		System.out.println(t2.getPriority());//5
		System.out.println(t3.getPriority());//5
		
		t3.setPriority(Thread.MAX_PRIORITY);
		t1.setPriority(MIN_PRIORITY);
		t1.start();
		t2.start();
		t3.start();
	}

}
