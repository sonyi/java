package sonyi;
//5λѡ��ͬʱ���ܣ���¼���ȵ����յ���ˣ���������������ӡ�ھ�ѡ�֡�

public class WinnerTest {
	public static void main(String[] args) {
		Thread t1 = new Man("ѡ��1");
		Thread t2 = new Man("ѡ��2");
		Thread t3 = new Man("ѡ��3");
		Thread t4 = new Man("ѡ��4");
		Thread t5 = new Man("ѡ��5");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Man.winName + "��Ӯ��");
	}
}

//������Ա�߳�
class Man extends Thread {
	static boolean flag = false;//����δ����
	public static String winName = "";
	private String name;
	
	public Man(String name) {
		this.name = name;
	}
	
	public void run() {
		int len = 1;
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