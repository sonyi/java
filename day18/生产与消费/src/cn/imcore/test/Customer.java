package cn.imcore.test;
/**
 * 消费者
 * @author user
 *
 */
public class Customer extends Thread{
	private Store s; //仓库
	private int num; //消费的数量
	
	public Customer(Store s, int num) {
		this.s = s;
		this.num = num;
	}
	
	public void run() {
		s.custom(num);//调用消费方法
	}
}
