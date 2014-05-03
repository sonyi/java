package sonyi;
/*
死锁：一般是同步中嵌套同步
	锁标记如果过多，就会出现线程等待其他线程释放锁标记，而又都不释放自己的锁标记供其他线程运行的状况。就是死锁。
		死锁的问题通过线程间的通信的方式进行解决。线程间通信机制实际上也就是协调机制。
		线程间通信使用的空间称之为对象的等待队列，则个队列也是属于对象的空间的。
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
				synchronized (MyLock.lockb) {//拿着a锁要b锁。
					System.out.println("if lockb");
				}
			}
		}
		else {
			synchronized (MyLock.lockb) {
				System.out.println("else lockb");
				synchronized (MyLock.locka) {//拿着b锁要a锁。
					System.out.println("else locka");
				}
			}
		}
	}
}

//创建两个锁
class MyLock{
	static Object locka = new Object();
	static Object lockb = new Object();
}