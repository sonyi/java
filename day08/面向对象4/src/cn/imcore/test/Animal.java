package cn.imcore.test;

public class Animal {

	private String name;
	
	Animal() {
		
	}
	
	Animal(String name) {
		this.name = name;
	}
	
	public void enjoy() {
		System.out.println("強麗壓出。。。。。。");
	}
	
	
	public String getName() {
		return name;
	}
}


class Bird extends Animal {
	private String featherColor;
	
	Bird(String name, String f) {
		super(name);
		this.featherColor = f;
	}
	
	public void enjoy() {
		System.out.println(super.getName() + "壓出。。。。。。");
	}
}


class Dog extends Animal {
	private String color;
	Dog(String n, String c) {
		super(n);
		this.color = c;
	}
	
	public void enjoy() {
		System.out.println(super.getName() + "壓出。。。。。。");
	}
}





