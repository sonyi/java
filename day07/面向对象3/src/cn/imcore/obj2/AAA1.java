package cn.imcore.obj2;

import cn.imcore.obj1.AAA;

/**
 * 与AAA类在不同包,但是AAA类的子类
 * @author Administrator
 *
 */
public class AAA1 extends AAA{
	AAA1() {
		a = 1; //public
//		b = 2; //private
//		c = 3; //default
		d = 4; //protected
		
		//方法的权限
		m1();   //public
//		m2();   //private
//		m3(1.3, 5.4);  //default
		m4();  //protected
	}
}
