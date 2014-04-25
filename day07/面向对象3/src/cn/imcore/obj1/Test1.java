package cn.imcore.obj1;
/**
 * 与AAA类在同一个包
 * @author Administrator
 *
 */
public class Test1 {
	
	Test1() {
		AAA a1 = new AAA();
		a1.a = 1; //public
//		a1.b = 2;  //private
		a1.c = 3; //default
		a1.d = 4; //protected
		
		a1.m1();  //public
//		a1.m2();  //private
		a1.m3(1,3);  //default
		a1.m4(); //protected
	}
	
}
