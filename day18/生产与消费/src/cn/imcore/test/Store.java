package cn.imcore.test;
/**
 * 仓库
 * @author user
 *
 */
public class Store{
	public static final int max = 100; //仓库的最大容量
	private int current = 10; //当前仓库默认有10个

	//生产的方法(要把产品放到仓库)
	public synchronized void produce(int num) {
		while(num+current > max) {
			System.out.println(Thread.currentThread().getName() + ":"
					 + "您要放入的数量为" + num +",当前库存为" + current + ",已超出库存，请等待。。。");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		current = current + num;
		System.out.println(Thread.currentThread().getName() + ":"
				 + "您要放入的数量为" + num +",当前库存为" + current + ",已入库");
		notifyAll();
	}
	
	//消费
	public synchronized void custom(int num) {
		while(current < num) {//当前数量小于消费数量，就要等待
			System.out.println(Thread.currentThread().getName() + ":"
					 + "您要消费的数量为" + num +",当前库存为" + current + ",数量不够，请等待。。。");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		current = current - num;
		System.out.println(Thread.currentThread().getName() + ":"
				 + "您要消费的数量为" + num +",当前库存为" + current + ",已消费");
		notifyAll();
	}

}
