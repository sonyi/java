package generic;

public class GenericDemo3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//���÷��ͻ��ƣ������������쳣ʱ������ʱֱ�ӳ��������޸ĳ�����߰�ȫ��
		Utils<Worker> u = new Utils<Worker>();
		u.setObject(new Worker());
		Worker w = u.getObject();
		
		/*
		//������ת���쳣ʱ������ʱ�����������ʱ�Ż��׳�ClassCastException����ͽ����˳���İ�ȫ�ԡ�
		Tool t = new Tool();
		t.setObject(new Student01());
		Worker w1 = (Worker)t.getObject();
		*/
	}
}

//��1
class Worker{
	
}

//��2
class Student01{
	
}

/*������
	ʲôʱ����Ҫ���巺���ࣿ
		������Ҫ�����������������Ͳ�ȷ����ʱ�����ڶ���Object�������չ�����ڶ��巺���������չ��
*/	
class Utils<QQ>{
	private QQ q;
	public void setObject(QQ q){
		this.q = q;
	}
	public QQ getObject(){
		return q;
	}
}

//���ͳ���֮ǰ����
class Tool{
	private Object o;//����ת�ͣ��ɸ����Ժã�������Ҫ��Ϊǿ������ת�������׳���

	public Object getObject() {
		return o;
	}
	public void setObject(Object o) {
		this.o = o;
	}	
}

/*

class Tool{
	private Worker w;//�ɸ����Բ�

	public Worker getWorker() {
		return w;
	}

	public void setWorker(Worker w) {
		this.w = w;
	}	
}
*/