package cn.imcore.obj3;
/**
 * 父类不能访问子类新增的成员(属性和方法)
 * @author Administrator
 *
 */
public class Test {

	public static void main(String[] args) {
		Parent p = new Parent();
		
		Son son = new Son();
		
		Daughter d = new Daughter();
		
		p.sing();
		
		son.dancing();
		son.sing();
		
		d.drawing();
		d.sing();
		
		Parent p1;//声明父类（基类）
		Parent p2;//声明父类（基类）
		p1 = new Son(); //一个基类的引用类型变量可以“指向”其子类的对象。
		p2 = new Daughter();
		
		p1.sing();
		p2.sing();
		
		if(p1 instanceof Parent) {
			System.out.println("true");
		} else {
			//
		}
		
		if(p1 instanceof Daughter) {
			System.out.println("p1 是 Daughter的实例化");
		} else {
			System.out.println("p1 不是 Daughter的实例化");
		}
		
		
		
	}
}
