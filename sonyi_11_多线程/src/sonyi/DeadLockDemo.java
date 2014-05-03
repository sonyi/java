package sonyi;
/*
������һ����ͬ����Ƕ��ͬ��
	�����������࣬�ͻ�����̵߳ȴ������߳��ͷ�����ǣ����ֶ����ͷ��Լ�������ǹ������߳����е�״��������������
		����������ͨ���̼߳��ͨ�ŵķ�ʽ���н�����̼߳�ͨ�Ż���ʵ����Ҳ����Э�����ơ�
		�̼߳�ͨ��ʹ�õĿռ��֮Ϊ����ĵȴ����У��������Ҳ�����ڶ���Ŀռ�ġ�
*/
public class DeadLockDemo {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Test(true));
		Thread t2 = new Thread(new Test(false));
		t1.start();
		t2.start();
	}
}

class Test implements Runnable{
	private boolean flag;
	public Test(boolean flag) {
		this.flag = flag;
	}
	public void run(){
		if(flag){
			synchronized (MyLock.locka) {
				System.out.println("if locka");
				synchronized (MyLock.lockb) {//����a��Ҫb����
					System.out.println("if lockb");
				}
			}
		}
		else {
			synchronized (MyLock.lockb) {
				System.out.println("else lockb");
				synchronized (MyLock.locka) {//����b��Ҫa����
					System.out.println("else locka");
				}
			}
		}
	}
}

//����������
class MyLock{
	static Object locka = new Object();
	static Object lockb = new Object();
}