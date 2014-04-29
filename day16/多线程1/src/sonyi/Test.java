package sonyi;



public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new Man1("选手1"));
		Thread t2 = new Thread(new Man1("选手2"));
		Thread t3 = new Thread(new Man1("选手3"));
		Thread t4 = new Thread(new Man1("选手4"));
		Thread t5 = new Thread(new Man1("选手5"));
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Man1.winName + "跑赢了");	
	}
}

class Man1 implements Runnable{
	public static boolean flag = false;
	public static String winName = "";
	private String name;
	Man1(String name){
		this.name = name;
	}
	
	int len = 1;
	@Override
	public void run() {	
		while(!flag){	
			if(flag) break;
			if(len == 10){	
				flag = true;
				winName = name;
				break;
			}
			System.out.println(name + ": " + (len++));	
		}	
	}	
}