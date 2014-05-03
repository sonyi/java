package sonyi;
/*
//单例设计模式：

 */
public class SingleDemo {
	public static void main(String[] args) {
		Single s = Single.getInstance();
	}
}

//饿汉式：实例同时加载
/*
class Single {
	private static final Single s = new Single();
	private Single(){//构造函数私有，外部不可以建立对象
		
	}
	public static Single getInstance(){
		return s;
	}
}
*/

//懒汉式：实例的延迟加载
class Single{
	private static Single s = null;
	private Single(){//构造函数私有，外部不可以建立对象
		
	}
	
	public static Single getInstance(){
		//双重判断，在多线程中，只要有创建一个对象之后，之后进来的线程直接判断条件(s == null),
		//而减少了判断同步锁，提高了效率。同步锁保证了对象的唯一性。
		if(s == null){
			synchronized (Single.class) {//静态中不可以用this作为锁，而是用该类的字节码对象作为锁
				if(s == null)
					s = new Single();
			}		
		}
		return s;
	}
}





