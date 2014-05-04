package sonyi;

public class ProAndConDemo {
	public static void main(String[] args) {
		Stack stack = new Stack();
		new Thread(new Producer1(stack)).start();
		new Thread(new Consumer1(stack)).start();	
	}
}

class Consumer1 implements Runnable{
	private Stack stack;
	public Consumer1(Stack stack) {
		this.stack = stack;
	}
	@Override
	public void run() {
		while (Producer1.flag) {//创建标记，如果生产结束，消费才结束
			stack.pop();//消费产品
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("--------------消费结束--------------");
	}	
}

class Producer1 implements Runnable{
	public static boolean flag = true;//创建生产标记，开始生产为true，结束生产为false
	private Stack stack;
	public Producer1(Stack stack) {
		this.stack = stack;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 20; i++){//生产20个产品
			Produce p = new Produce(i+1);//生产一个产品
			stack.push(p);//产品添加到仓库中
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		flag = false;//结束生产标记
		System.out.println("----------生产结束--------------");
	}	
}

class Stack{
	Produce[] storeHose = new Produce[5];//创建容量为5的仓库
	int index = 0;
	
	public synchronized void push(Produce p){//往仓库内存放产品(传入一个产品)
		try {
			while (index == storeHose.length) {//判断仓库是否已经满了
				System.out.println("仓库已经满了---------");
				this.wait();//仓库满时，生产等待
			}	
			this.notifyAll();//唤醒其他线程
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		storeHose[index++] = p;//仓库添加一个产品
		System.out.println("生产了" + p.id + "号产品,现在仓库有：" + index + "产品");	
	}
	
	public synchronized void pop(){	//往仓库中消费产品
		try {
			//双重判断，只有当仓库没有产品和成产还在继续时，消费线程才进入等待。
			//也就是说，当生产还在继续时，仓库没有产品，消费线程才进入等待，当生产结束时，消费线程不会进入等待，而是将产品消费光
			while(index == 0 && Producer1.flag){
				System.out.println("产品已经消费完了---------");
				this.wait();
			}
			this.notifyAll();//消费线程等待时，唤醒其他线程
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		Produce p = storeHose[--index];//消费仓库里的一个产品
		System.out.println("消费了" + p.id + "号产品，现在仓库还有" + index + "产品");	
	}
}

//创建产品类，每个产品都有自己的id
class Produce{
	int id;
	public Produce(int id) {
		this.id = id;
	}
}