package cn.imcore.extend2;

public class Test4 extends Person{
	private String name;
	
	Test4(){
		
	}
	
	Test4(String name, int age) {
		this.name = name;
		super.setName(name);
		super.setAge(age);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void printMsg() {
		System.out.println(super.getName() + "," + getAge());
	}
	
	public static void main(String[] args) {
		Test4 p1 = new Test4("admin", 45);
		p1.printMsg();
		
	}
}


class Person {
	private String name;//姓名
	private int age;//年龄
	
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setName(String name) {
		if("admin".equals(name)){
			System.out.println("这是管理员账号不能改");
		}else {
			this.name = name;
		}
	}
	
	public void setAge(int age) {
		if(age<0 || age >120) {
			System.out.println("年龄不合法");
		} else{
			this.age = age;
		}
		
	}
	
}