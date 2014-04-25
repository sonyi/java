package cn.imcore.test;
/**
 * 全局变量：类内部、方法的外部
 * 局部变量：方法内部
 * @author Administrator
 *
 */
public class Test1 {
    public static String name;
	static int age;
	
	public static void main(String[] args) {
		int age = 20;//局部变量，必须初始化
		System.out.println("main:" + age);
		printMsg();//调用方法
	}
	
	//方法体
	public static void printMsg(){
		System.out.println(name + "," + age);//全局变量
	}
	
}
