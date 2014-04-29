package cn.imcore.test;
/**
 * 匿名内部类
 */
public class Test4 {
	public static void main(String[] args) {	
		Person p1 = new Person(){
			@Override
			public void sing() {
				System.out.println("yayaaaaaaaaaaaa!!!!");
			}	
		};

		Person p2 = new Person(){
			@Override
			public void sing() {
				System.out.println("do re mi fa so!!!!");				
			}		
		};
		
		p1.sing();
		p2.sing();
	}
}

interface Person {
	public void sing();
}

