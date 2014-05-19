package cn.imcore.entity;

public class Person {
	private int ids;
	private String name;
	private int age;
	private String sex;
	
	public Person() {
		
	}
	
	public Person(int ids, String name, int age, String sex) {
		this.ids = ids;
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public int getIds() {
		return ids;
	}

	public void setIds(int ids) {
		this.ids = ids;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
}
