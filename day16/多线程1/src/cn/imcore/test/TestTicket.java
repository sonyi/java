package cn.imcore.test;

public class TestTicket {

	public static void main(String[] args) {
//		Ticket1 win1 = new Ticket1();
//		Ticket1 win2 = new Ticket1();
//		Ticket1 win3 = new Ticket1();
//
//		win1.start();
//		win2.start();
//		win3.start();
		
		Ticket2 ticket = new Ticket2();
		new Thread(ticket, "´°¿Ú1").start();
		new Thread(ticket, "´°¿Ú2").start();
		new Thread(ticket, "´°¿Ú3").start();
	}

}

class Ticket2 implements Runnable{
	int ticket = 5;
	public void run() {
		while(true) {
			if(ticket==0) break;
			System.out.println(Thread.currentThread().getName() + ":" + ticket--);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

class Ticket1 extends Thread{
	int ticket = 5;
	public void run() {
		while(true) {
			if(ticket==0) break;
			System.out.println(Thread.currentThread().getName() + ":" + ticket--);
		}
	}
	
}