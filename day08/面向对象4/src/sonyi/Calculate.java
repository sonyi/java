package sonyi;
/*
	练习：
		编写一个类Calculate1，实现加、减两种运算，然后，编写另一个派生类Calculate2，实现乘、除两种运算。
 */
public class Calculate {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculate1 c1 = new Calculate1();
		Calculate2 c2 = new Calculate2();
			
		System.out.println("c1的加法：" + c1.plus(5, 3));
		System.out.println("c1的减法：" + c1.subtraction(5, 3));
		
		System.out.println("c2的加法：" + c2.plus(5, 3));
		System.out.println("c2的减法：" + c2.subtraction(5, 3));
		System.out.println("c2的乘法：" + c2.multiply(5, 3));
		System.out.println("c2的除法：" + c2.remove(5, 3));
	}
}


class Calculate1{
	
	public double plus(double x,double y){
		return x + y;
	}
	public double subtraction(double x,double y){
		return x - y;
	}
}

class Calculate2 extends Calculate1{
	
	public double multiply(double x, double y){
		return x*y;
	}
	
	public double remove(double x,double y){
		return x/y;
	}
}