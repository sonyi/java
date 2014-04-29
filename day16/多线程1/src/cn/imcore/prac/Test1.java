package cn.imcore.prac;

public class Test1 extends Thread{

	public void run() {
		for(int i=(int)'a' ; i<=(int)'z'; i++) {
			System.out.println((char)i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new Test1().start();

	}

}
