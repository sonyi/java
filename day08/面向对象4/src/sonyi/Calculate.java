package sonyi;
/*
	��ϰ��
		��дһ����Calculate1��ʵ�ּӡ����������㣬Ȼ�󣬱�д��һ��������Calculate2��ʵ�ֳˡ����������㡣
 */
public class Calculate {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculate1 c1 = new Calculate1();
		Calculate2 c2 = new Calculate2();
			
		System.out.println("c1�ļӷ���" + c1.plus(5, 3));
		System.out.println("c1�ļ�����" + c1.subtraction(5, 3));
		
		System.out.println("c2�ļӷ���" + c2.plus(5, 3));
		System.out.println("c2�ļ�����" + c2.subtraction(5, 3));
		System.out.println("c2�ĳ˷���" + c2.multiply(5, 3));
		System.out.println("c2�ĳ�����" + c2.remove(5, 3));
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