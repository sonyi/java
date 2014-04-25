package cn.imcore.object4;

public class Test {
	
	public void A1(People p) {
		p.printMsg();
	} 
	
	public People A2() {
		return new People();
	}
	
	public static void main(String[] args) {
		Test t = new Test();//实例化
		People p1 = new People();
		t.A1(p1);//访问非静态方法
		
		People p2 = new People("王明",20);
		t.A1(p2);
		
		People p3 = t.A2();
		t.A1(p3);
	}
}
