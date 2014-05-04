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
		while (Producer1.flag) {//������ǣ�����������������ѲŽ���
			stack.pop();//���Ѳ�Ʒ
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("--------------���ѽ���--------------");
	}	
}

class Producer1 implements Runnable{
	public static boolean flag = true;//����������ǣ���ʼ����Ϊtrue����������Ϊfalse
	private Stack stack;
	public Producer1(Stack stack) {
		this.stack = stack;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 20; i++){//����20����Ʒ
			Produce p = new Produce(i+1);//����һ����Ʒ
			stack.push(p);//��Ʒ��ӵ��ֿ���
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		flag = false;//�����������
		System.out.println("----------��������--------------");
	}	
}

class Stack{
	Produce[] storeHose = new Produce[5];//��������Ϊ5�Ĳֿ�
	int index = 0;
	
	public synchronized void push(Produce p){//���ֿ��ڴ�Ų�Ʒ(����һ����Ʒ)
		try {
			while (index == storeHose.length) {//�жϲֿ��Ƿ��Ѿ�����
				System.out.println("�ֿ��Ѿ�����---------");
				this.wait();//�ֿ���ʱ�������ȴ�
			}	
			this.notifyAll();//���������߳�
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		storeHose[index++] = p;//�ֿ����һ����Ʒ
		System.out.println("������" + p.id + "�Ų�Ʒ,���ڲֿ��У�" + index + "��Ʒ");	
	}
	
	public synchronized void pop(){	//���ֿ������Ѳ�Ʒ
		try {
			//˫���жϣ�ֻ�е��ֿ�û�в�Ʒ�ͳɲ����ڼ���ʱ�������̲߳Ž���ȴ���
			//Ҳ����˵�����������ڼ���ʱ���ֿ�û�в�Ʒ�������̲߳Ž���ȴ�������������ʱ�������̲߳������ȴ������ǽ���Ʒ���ѹ�
			while(index == 0 && Producer1.flag){
				System.out.println("��Ʒ�Ѿ���������---------");
				this.wait();
			}
			this.notifyAll();//�����̵߳ȴ�ʱ�����������߳�
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		Produce p = storeHose[--index];//���Ѳֿ����һ����Ʒ
		System.out.println("������" + p.id + "�Ų�Ʒ�����ڲֿ⻹��" + index + "��Ʒ");	
	}
}

//������Ʒ�࣬ÿ����Ʒ�����Լ���id
class Produce{
	int id;
	public Produce(int id) {
		this.id = id;
	}
}