package cn.imcore.abs;
/**
 * 接口
 * @author Administrator
 *
 */
public interface Calcu {

//	int a;  不能是变量
	//常量
	int a = 1;
	public static final int b = 1;
	
//	Calcu() {//借口没有构造方法
//		
//	}
	//不能使普通方法
//	public void plus(int x, int y) {
//		
//	}
	
	//抽象方法
	void divi(int x, int y);//除法
	
	public void plus(int x, int y);//加法
	
}
