package sonyi;

//测试类
public class TestATM {

	
	public static void main(String[] args) {
		//开户
		Account1 a = new Account1(11111, 1000);
		System.out.println(a);
		//存取钱
		new ATM1(a, 1, 50).start();
		new ATM1(a, 2, 100).start();
		new ATM1(a, 2, 150).start();
		new ATM1(a, 2, 50).start();
		new ATM1(a, 1, 80).start();
		new ATM1(a, 2, 90).start();
		new ATM1(a, 1, 30).start();
	}

}


//取款机
class ATM1 extends Thread{
	private Account1 ac;
	private int oper;//oper=1 存钱； oper=2 取钱
	private int m; //取或存的金额
	
	public ATM1(Account1 ac, int oper, int m) {
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
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("存入" + m + ",当前余额为" + money);
	}
	
	//取钱
	public synchronized void drawMoney(int m) {
		money -= m;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("取出" + m + ",当前余额为" + money);
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
		return "当前账户为" + id + ", 余额为" + money ;
	}
	
	
	
}