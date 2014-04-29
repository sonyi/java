package cn.imcore.test;

public class TestJoin extends Thread{

	public void run() {
		int k = 50;
		while(k-- > 0) {
			System.out.println("AAAAAA");
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		TestJoin t = new TestJoin();//×ÓÏß³Ì
		
		t.start();
		
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int k = 50;
		while(k-- > 0) {
			System.out.println("main");
		}

	}

}
