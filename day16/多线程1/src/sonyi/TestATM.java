package sonyi;

//取款机存取钱练习：

public class TestATM {
	public static void main(String[] args) {
		//开户
		Account1 a = new Account1(11111, 100);
		System.out.println(a);
		//存取钱
		new Thread(new ATMWindow(a, 1, 50),"ATM1").start();
		new Thread(new ATMWindow(a, 2, 100),"ATM2").start();
		new Thread(new ATMWindow(a, 2, 150),"ATM3").start();
		new Thread(new ATMWindow(a, 1, 50),"ATM4").start();
		new Thread(new ATMWindow(a, 1, 150),"ATM5").start();
		new Thread(new ATMWindow(a, 1, 250),"ATM6").start();
		new Thread(new ATMWindow(a, 2, 250),"ATM7").start();
		new Thread(new ATMWindow(a, 2, 100),"ATM8").start();
		new Thread(new ATMWindow(a, 1, 200),"ATM9").start();	
	}
}

//取款机
class ATMWindow implements Runnable{
	private Account1 ac;
	private int oper;//oper=1 存钱； oper=2 取钱
	private int m; //取或存的金额
	
	public ATMWindow(Account1 ac, int oper, int m) {
		this.ac = ac;
		this.oper = oper;
		this.m = m;
	}
	
	public void run() {
		switch(oper) {
			case 1:
				ac.saveMoney(m);
				break;
			case 2:
				ac.drawMoney(m);
				break;
			default:
				System.out.println("没有选择！");
		}
	}
}

//账户类
class Account1 {
	private int id;
	private int money;
	
	Account1(int id, int money) {
		this.id = id;
		this.money = money;
	}
	
	//存钱
	public synchronized void saveMoney(int m) {
		money += m;
		System.out.println("账户：" + id + "从" + Thread.currentThread().getName() + "中存入" + m + "元,当前余额为" + money);
		this.notifyAll();//当账户中存入钱时，唤醒所有线程
	}
	
	//取钱
	public synchronized void drawMoney(int m) {
		while (money < m) {//设置循环，当余额不足时，线程等待。
			System.out.println("当前余额不足！");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
		money -= m;
		System.out.println("账户：" + id + "从" + Thread.currentThread().getName() +"中取出" + m + "元,当前余额为" + money);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "当前账户：" + id + ", 余额为：" + money ;
	}	
}