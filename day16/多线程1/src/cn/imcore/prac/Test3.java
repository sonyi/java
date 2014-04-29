package cn.imcore.prac;

public class Test3 {

	public static void main(String[] args) {
		MyThread t1 = new MyThread(1);
		MyThread t2 = new MyThread(2);
		t1.setPriority(10);
		t2.setPriority(6);
		t1.start();
		t2.start();

	}

}

class MyThread extends Thread {
	private int flag;
	
	public MyThread(int flag) {
		this.flag = flag;
	}
	
	public void run() {
		if(flag==1) {
			//
			m1();
		} 
		else if(flag==2) {
			m2();
		}
		else {
			//就什么都不做
		}
	}
	
	public void m1() {
		for(int i=1; i<=200; i++) {
			System.out.println("线程 1正在运行");
		}
	}
	
	public void m2() {
		for(int i=1; i<=200; i++) {
			System.out.println("线程 2正在运行");
		}
	}
}