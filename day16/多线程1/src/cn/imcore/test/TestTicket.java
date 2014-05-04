package cn.imcore.test;
//多窗口卖票系统
public class TestTicket {
	public static void main(String[] args) {		
		Ticket2 ticket = new Ticket2();
		new Thread(ticket, "窗口1").start();
		new Thread(ticket, "窗口2").start();
		new Thread(ticket, "窗口3").start();
	}
}

class Ticket2 implements Runnable{
	int ticket = 100;
	public void run() {
		while(true) {
			synchronized (this) {
				if(ticket==0) 
					break;
				System.out.println(Thread.currentThread().getName() + ":卖出第" + (ticket--) + "张票");
			}			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
