package sonyi;
//5位选手同时赛跑，记录最先到达终点的人，并结束比赛。打印冠军选手。

public class WinnerTest {
	public static void main(String[] args) {
		Thread t1 = new Man("选手1");
		Thread t2 = new Man("选手2");
		Thread t3 = new Man("选手3");
		Thread t4 = new Man("选手4");
		Thread t5 = new Man("选手5");
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
			e.printStackTrace();
		}
		System.out.println(Man.winName + "跑赢了");
	}
}

//比赛人员线程
class Man extends Thread {
	static boolean flag = false;//比赛未结束
	public static String winName = "";
	private String name;
	
	public Man(String name) {
		this.name = name;
	}
	
	public void run() {
		int len = 1;
		while(!flag) {
			if(flag) break;
			if(len==10){
				flag = true;//比赛结束
				winName = name;
				break;
			}
			System.out.println(name + "跑了" + len + "米。");
			len++;
		}
	}
}