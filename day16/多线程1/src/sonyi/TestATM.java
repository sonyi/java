package sonyi;

//ȡ�����ȡǮ��ϰ��

public class TestATM {
	public static void main(String[] args) {
		//����
		Account1 a = new Account1(11111, 100);
		System.out.println(a);
		//��ȡǮ
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

//ȡ���
class ATMWindow implements Runnable{
	private Account1 ac;
	private int oper;//oper=1 ��Ǯ�� oper=2 ȡǮ
	private int m; //ȡ���Ľ��
	
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
		System.out.println("�˻���" + id + "��" + Thread.currentThread().getName() + "�д���" + m + "Ԫ,��ǰ���Ϊ" + money);
		this.notifyAll();//���˻��д���Ǯʱ�����������߳�
	}
	
	//ȡǮ
	public synchronized void drawMoney(int m) {
		while (money < m) {//����ѭ����������ʱ���̵߳ȴ���
			System.out.println("��ǰ���㣡");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
		money -= m;
		System.out.println("�˻���" + id + "��" + Thread.currentThread().getName() +"��ȡ��" + m + "Ԫ,��ǰ���Ϊ" + money);
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
		return "��ǰ�˻���" + id + ", ���Ϊ��" + money ;
	}	
}