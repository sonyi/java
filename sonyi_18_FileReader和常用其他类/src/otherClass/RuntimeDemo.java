package otherClass;
/*
	Runtime对象：
		该类并没有提供构造函数。说明不可以new对象。那么会直接想到该类中的方法都是静态的。
		但是发现该类中还有非静态方法。说明该类肯定会提供方法获取本类对象。而且该方法是
			静态的。并返回值类型是本类类型。（单例设计模式）
		该方法是static getRuntime();
		有这个特点可以看出该类使用了单例设计模式完成。
 */
public class RuntimeDemo {

	public static void main(String[] args) throws Exception{//会产生异常
		Runtime r = Runtime.getRuntime();
		Process p = r.exec("D:\\Program Files (x86)\\Tencent\\QQ\\QQProtect\\Bin\\QQProtect.exe");//返回一个子进程
		Thread.sleep(400);
		p.destroy();//结束子线程
	}
}
