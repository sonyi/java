package cn.imcore.prac;

public class Test2 extends Thread{
	
	public Test2(String name) {
		super(name);
	}
	
	public void run() {
		
		System.out.println(getName() + " Start");
		//ÿ���0.5���ӡһ��Loop:��ʾ2��
		for(int i=0; i<2; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(getName() + " Loop");
		}
		System.out.println(getName() + " End");
	}
	
	public static void main(String[] args) {
		new Test2("A").start();
		new Test2("B").start();
		new Test2("C").start();

	}

}
