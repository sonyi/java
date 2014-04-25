package cn.imcore.test;

public class Test3 {

	public static void main(String[] args) {
		Test3 t = new Test3();
//		int rev = t.m1(2, 0);
		int rev = t.m2(2, 0);
		System.out.println(rev);
	}
	
	public int m2(int a, int b){
		int m = 1;
		try{
			int num = a/b;
			return m;
		}catch(Exception e) {
			m=2;
			return m;
		}finally{
			m=3;
//			return m;
		}
		
	}
	
	public int m1(int a, int b){
		try{
			int num = a/b;
			return 1;
		}catch(Exception e) {
			return 2;
		}finally{
			return 3;
		}
		
	}
	
	
}
