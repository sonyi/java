package cn.imcore.test;

public class Test2 {

	public static void main(String[] args){
		Test2 t2 = new Test2();
//		try {
//			t2.div1(2, 0);
//		} catch (Exception e) {
////			e.printStackTrace();
//		}
		
		t2.div2(2, 0);
		System.out.println("main");
		
	}
	
	
	public int div2(int a, int b){
		if(b==0)
			try {
				throw new Exception("被除数不能等于0");
			} catch (Exception e) {
				b=1;
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		return a/b;
	}
	
	public int div1(int a, int b) throws Exception{
		return a/b;
	}
}
