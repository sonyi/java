package cn.imcore.prac;

public class WinnerTest {

	
	public static void main(String[] args) {
		new Man("ѡ��1").start();
		new Man("ѡ��2").start();
		new Man("ѡ��3").start();
		new Man("ѡ��4").start();
		new Man("ѡ��5").start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Man.winName + "��Ӯ��");
	}

}

class Man extends Thread {
	static boolean flag = false;//����δ����
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
				flag = true;//��������
				winName = name;
				break;
			}
			System.out.println(name + "����" + len + "�ס�");
			len++;
			
		}
	}
}