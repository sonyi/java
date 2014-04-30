package sonyi;

//������
public class TestATM {

	
	public static void main(String[] args) {
		//����
		Account1 a = new Account1(11111, 1000);
		System.out.println(a);
		//��ȡǮ
		new ATM1(a, 1, 50).start();
		new ATM1(a, 2, 100).start();
		new ATM1(a, 2, 150).start();
		new ATM1(a, 2, 50).start();
		new ATM1(a, 1, 80).start();
		new ATM1(a, 2, 90).start();
		new ATM1(a, 1, 30).start();
	}

}


//ȡ���
class ATM1 extends Thread{
	private Account1 ac;
	private int oper;//oper=1 ��Ǯ�� oper=2 ȡǮ
	private int m; //ȡ���Ľ��
	
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
				System.out.println("û��ѡ��");
		}
		
	}
	
}

//�˻���
class Account1 {
	private int id;
	private int money;
	
	Account1(int id, int money) {
		this.id = id;
		this.money = money;
	}

	//��Ǯ
	public synchronized void saveMoney(int m) {
		money += m;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("����" + m + ",��ǰ���Ϊ" + money);
	}
	
	//ȡǮ
	public synchronized void drawMoney(int m) {
		money -= m;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ȡ��" + m + ",��ǰ���Ϊ" + money);
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
		return "��ǰ�˻�Ϊ" + id + ", ���Ϊ" + money ;
	}
	
	
	
}