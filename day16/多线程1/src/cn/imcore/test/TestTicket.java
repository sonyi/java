package cn.imcore.test;
//�ര����Ʊϵͳ
public class TestTicket {
	public static void main(String[] args) {		
		Ticket2 ticket = new Ticket2();
		new Thread(ticket, "����1").start();
		new Thread(ticket, "����2").start();
		new Thread(ticket, "����3").start();
	}
}

class Ticket2 implements Runnable{
	int ticket = 100;
	public void run() {
		while(true) {
			synchronized (this) {
				if(ticket==0) 
					break;
				System.out.println(Thread.currentThread().getName() + ":������" + (ticket--) + "��Ʊ");
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
