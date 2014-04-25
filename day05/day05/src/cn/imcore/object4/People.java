package cn.imcore.object4;

public class People {

	private String name;
	private int age;
	
	People() {
		this("ÕÅÈý·á");
	}
	
	People(String name) {
		this.name = name;	
	}

	People(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public static void A1() {
//		this.name = "AAA";
	}
	
	public void printMsg() {
		System.out.println(name + "," + age);
	}
}
