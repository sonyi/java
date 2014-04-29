package sonyi;

public class Test3 {
	public static void main(String[] args) {
		new ThreadABC("A").start();
		new ThreadABC("B").start();
		new ThreadABC("C").start();	
	}
}

class ThreadABC extends Thread{
	private String name;
	public ThreadABC(String name) {
		this.name = name;
	}
	public void run(){
		try {
			System.out.println(name + ": start");
			Thread.sleep(500);
			System.out.println(name + ": loop");
			Thread.sleep(500);
			System.out.println(name + ": loop");
			Thread.sleep(500);
			System.out.println(name + ": end");
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}