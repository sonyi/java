package sonyi;

public class Test5 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account d = new Account(1001,500);
		Account d1 = new Account(105,300);
		
		new ATM(d, 1, 100).start();
		new ATM(d, 2, 50).start();
		new ATM(d, 1, 200).start();
		new ATM(d, 2, 80).start();
		
		new ATM(d1, 2, 100).start();
		new ATM(d1, 1, 50).start();
		new ATM(d1, 2, 200).start();
		new ATM(d1, 1, 80).start();
	}
}

class Account {
	private int id;
	private double money;
	
	public Account(int id, double money) {
		this.id = id;
		this.money = money;
	}
	
	public synchronized void saveMoney(double moneyInt){	
		money += moneyInt;
		System.out.println("����ǰ��" + id + "�˻�����" + moneyInt + "Ԫ���˻����Ϊ��" + money);
		
	}
	
	public synchronized void getMoney(double moneyOut){
		if((money - moneyOut) < 0){
			System.out.println("�˻�����");
		}else {
			money -= moneyOut;
			System.out.println("����ǰ��" +  id + "�˻�ȡ����" + moneyOut + "Ԫ���˻����Ϊ��" + money);
		}		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	
}

class ATM extends Thread{
	private Account account;
	private int getOrSave;
	private double money;
	
	public ATM(Account account, int gerOrSave, double money) {
		this.account = account;
		this.getOrSave = gerOrSave;
		this.money = money;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		switch (getOrSave) {
			case 1:
				account.saveMoney(money);
				break;
			case 2:
				account.getMoney(money);
				break;
			default:
				break;
		}
	}

}