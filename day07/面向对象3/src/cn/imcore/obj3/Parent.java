package cn.imcore.obj3;

public class Parent {
	private String pName;
	private int pAge;
	
	public Parent() {
		
	}
	
	public Parent(String pName, int pAge) {
		this.pName = pName;
		this.pAge = pAge;
	}
	
	public void sing() {
		System.out.println("Parent are sing.");
	}
	
}

class Son extends Parent {
	private String name;
	private int age;
	
	public Son() {
		
	}
	
	public Son(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void dancing() {
		System.out.println("son is dancing");
	}
	
	public void sing() {
		System.out.println("son is sing.");
	}
}


class Daughter extends Parent {
	private String name;
	private int age;
	
	public Daughter() {
		
	}
	
	public Daughter(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void drawing() {
		System.out.println("Daughter is drawing.");
	}
	
	public void sing() {
		System.out.println("Daughter is sing.");
	}
	
}