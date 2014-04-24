package generic;

public class GenericDemo3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//采用泛型机制，当类型输入异常时，编译时直接出错，提醒修改程序，提高安全性
		Utils<Worker> u = new Utils<Worker>();
		u.setObject(new Worker());
		Worker w = u.getObject();
		
		/*
		//当类型转换异常时，编译时不会出错，运行时才会抛出ClassCastException，这就降低了程序的安全性。
		Tool t = new Tool();
		t.setObject(new Student01());
		Worker w1 = (Worker)t.getObject();
		*/
	}
}

//类1
class Worker{
	
}

//类2
class Student01{
	
}

/*泛型类
	什么时候需要定义泛型类？
		当类中要操作的引用数据类型不确定的时候，早期定义Object来完成扩展，现在定义泛型来完成扩展。
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

//泛型出现之前操作
class Tool{
	private Object o;//向上转型，可复用性好，但是需要人为强制类型转换，容易出错

	public Object getObject() {
		return o;
	}
	public void setObject(Object o) {
		this.o = o;
	}	
}

/*

class Tool{
	private Worker w;//可复用性差

	public Worker getWorker() {
		return w;
	}

	public void setWorker(Worker w) {
		this.w = w;
	}	
}
*/