package cn.imcore.test;

/**
 * 生产者
 * @author user
 *
 */
public class Producer extends Thread{
	private Store s; //仓库
	private int num; //消费的数量
	
	public Producer(Store s, int num) {
		this.s = s;
		this.num = num;
	}
	
	public void run() {
		s.produce(num);//调用生产方法
	}

	
	
}
