package cn.imcore.object2;

public class People {
	
	//属性(封装)
    private String name;
    private int age = 1;
    private char sex;
    private String eye;
    private String hair;
	
	public People() {
		
	}
	
	public People(String name, int age) {
		
	}
	
	//行为-方法
	public String getName(){
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		if(age<=0 || age>120) {//年龄的过滤
			System.out.println("年龄不合法");
			return;
		}
		this.age = age;
		
	}
	
	public void eating(String name) {
		System.out.println(name + "正在吃饭。。。。。。。。。。。");
	}
	
}
