package cn.imcore.obj3;
/**
 * 转型
 * @author Administrator
 *
 */
public class Test2 {

	//向下转型 （条件：要先向上转型才可以向下转型） 父类的引用变量赋给子类的引用变量
	public static void m1(Parent p) {
		if(p instanceof Son) {
			Son son = (Son)p;//向下转型
			son.dancing();
		}
		
		if(p instanceof Daughter) {
			Daughter d = (Daughter)p;//向下转型
			d.drawing();
		}
	}
	
	public static void main(String[] args) {
		
		
		Son s1 = new Son();
		Daughter d1 = new Daughter();
		
//		Daughter d2 = s1;  //两边类型不一致
		
		//向上转型 （父类指向子类对象） 子类对象赋给父类的引用变量
		m1(s1);//向上转型
		m1(d1);
	}
}
