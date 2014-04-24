package cn.imcore.test;

public class Test1 {
	public static void main(String[] args) {
		try{
			int i = 1/0;
		} catch(Exception e) {
//			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			
		}
		
		System.out.println("main");
		
		
	}
}
