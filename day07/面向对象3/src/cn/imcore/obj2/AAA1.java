package cn.imcore.obj2;

import cn.imcore.obj1.AAA;

/**
 * ��AAA���ڲ�ͬ��,����AAA�������
 * @author Administrator
 *
 */
public class AAA1 extends AAA{
	AAA1() {
		a = 1; //public
//		b = 2; //private
//		c = 3; //default
		d = 4; //protected
		
		//������Ȩ��
		m1();   //public
//		m2();   //private
//		m3(1.3, 5.4);  //default
		m4();  //protected
	}
}
