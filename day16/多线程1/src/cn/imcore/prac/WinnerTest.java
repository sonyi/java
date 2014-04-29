package cn.imcore.prac;

public class WinnerTest {

	
	public static void main(String[] args) {
		new Man("选手1").start();
		new Man("选手2").start();
		new Man("选手3").start();
		new Man("选手4").start();
		new Man("选手5").start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Man.winName + "跑赢了");
	}

}

class Man extends Thread {
	static boolean flag = false;//比赛未结束
	public static String winName = "";
	private String name;
	
	public Man(String name) {
		this.name = name;
	}
	
	public void run() {
		int len = 1;
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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