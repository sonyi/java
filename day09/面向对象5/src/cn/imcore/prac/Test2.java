package cn.imcore.prac;

public class Test2 {
	public static void main(String[] args) {
		AAA a1 = new AAA();
		a1.setMyNumber(10);
		System.out.println(a1.getMyNumber());
	}
}

class AAA {
	int myNumber;

	public int getMyNumber() {
		return myNumber/100;
	}

	public void setMyNumber(int myNumber) {
		this.myNumber = myNumber*100;
	}
	
	
	
	
}