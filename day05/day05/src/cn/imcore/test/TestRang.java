package cn.imcore.test;
/*
  变量的范围：
	1、全局变量：类内部、方法的外部。全局变量有默认值，类加载时会自动初始化
	2、局部变量：方法内部。没有默认值，要使用时，必须初始化
 */
public class TestRang {

	static byte b1;
	static char c1;
	static short s1;
	static int i1;
	static long l1;
	static float f1;
	static double d1;
	static boolean b;
	static String s;//
	
	public static void main(String[] args){
		System.out.println("byte:" + b1);
		System.out.println("char:" + c1);
		System.out.println("short:" + s1);
		System.out.println("int:" + i1);
		System.out.println("long:" + l1);
		System.out.println("float:" + f1);
		System.out.println("double:" + d1);
		System.out.println("boolean:" + b);
		System.out.println("String:" + s);
	}
	/*
	 *  打印结果：
		 	byte:0
		 	char:
		 	short:0
		 	int:0
			long:0
			float:0.0
			double:0.0
			boolean:false
			String:null
	 */
}
