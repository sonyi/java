package cn.imcore.test;

public class Test4 {
	public static void main(String[] args) {
		Test4 t = new Test4();
		t.div(2, 0);
	}
	
	
	public int div(int a, int b) {
		int sum = 0;
		if(b==0)
			try {
				throw new MyException("被除数不能为0");
			} catch (MyException e) {
				System.out.println(e.getMessage());
				return 0;
			}
		return sum;
	}
}


class MyException extends Exception{
	
	MyException(String msg) {
		super(msg);
	}
}