package cn.imcore.obj2;

import cn.imcore.obj1.AAA;

/**
 * ��AAA���ڲ�ͬ��
 * @author Administrator
 *
 */
public class Test2 {

	Test2() {
		AAA a1 = new AAA();
		//����
		a1.a = 1; //public
//		a1.b = 2; //private
//		a1.c = 3; //default
//		a1.d = 4; //protected
		
		//����
		a1.m1();  //public
//		a1.m2(); //private
//		a1.m3(2.0, 30);  //default
//		a1.m4();  //protected
	}
}
