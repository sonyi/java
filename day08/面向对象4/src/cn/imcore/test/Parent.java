package cn.imcore.test;

public class Parent {
	
	public void sing() {
		System.out.println("Parent sing");
	}
}

class Son extends Parent {
	
	public void sing() {
		System.out.println("Son sing");
	}
	
	public void dance() {//���������ĳ�Ա
		System.out.println("Son dance");
	}
}