package sonyi;
/*
	练习：
	编写一个控制台应用程序，完成下列功能，并写出运行程序后输出的结果。
	   1) 创建一个类A，在A中编写一个可以被重写的带int类型参数的方法MyMethod，并在该方法中输出传递的整型值加10后的结果。
	   2) 再创建一个类B，使其继承自类A，然后重写A中的MyMethod方法，将A中接收的整型值加50，并输出结果。
	   3) 在Main方法中分别创建类A和类B的对象，并分别调用MyMethod方法。
 */
public class Exercise2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		B b = new B();
		System.out.println(a.myMethod(5));//父类的方法
		System.out.println(b.myMethod(5));//子类的方法
	}

}
class B extends A{
	
	public int myMethod(int i){//复写父类方法
		return i + 50;
	}
}

class A{
	
	public int myMethod(int i){
		return i + 10;
	}
}