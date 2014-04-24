package generic;
/*
	泛型类定义的泛型，在整个类中有效，如果被方法使用，那么，泛型类的对象明确要操作的
		具体类型后，所以要操作的类型就已经固定了。为了让不同方法可以操作不同类型，而且
		类型还不确定，那么可以将类型定义在方法上。
		
	特殊之处：静态方法不可以访问类上定义的泛型。如果静态方法操作的引用数据类型不确定，
		可以将泛型定义在方法上。
	
	泛型位置：定义在类中，泛型在类名后面；定义在方法中，泛型在返回值前面。(书写格式)
 */

//泛型定义在类上和方法上
public class GenericDemo4 {
	public static void main(String[] args) {
		
		/*方式一：
		Demo<Integer> d = new Demo<Integer>();
		d.show(4);
		d.print(new Integer(5));
		
		Demo<String> d1 = new Demo<String>();
		d1.show("hahaha");
		d1.print("hehehe");
		*/
		
		/*方式二：
		Demo d = new Demo();
		d.show("hahah");
		d.show(new Integer(4));
		d.print("heihei");
		d.print(5);
		*/
		
		//方式三：
		Demo<String> d = new Demo<String>();
		d.show("haha");
		d.print("heihei");
		d.print(9);
		Demo.method("lalalal");
	}
}

//方式三：类上定义泛型，方法上也可以另外定义泛型。
class Demo<T>{
	public void show(T t){
		System.out.println("show:" + t);
	}
	public <Q>void print(Q q){
		System.out.println("print:" + q);
	}
	public static<W> void method(W w){
		System.out.println("method:" + w);
	}
	
	//静态方法不可以访问类上定义的泛型，可以将泛型定义在方法上
//	public static void method(T t){
//		System.out.println("method:" + t);
//	}
}


/*方式二：泛型只定义在方法上
class Demo{
	public <T>void show(T t){
		System.out.println("show:" + t);
	}
	public <Q>void print(Q q){
		System.out.println("print:" + q);
	}
}
*/

/*方式一：方法与类的类型一致
class Demo<T>{
	public void show(T t){
		System.out.println("show:" + t);
	}
	public void print(T t){
		System.out.println("print:" + t);
	}
}
*/