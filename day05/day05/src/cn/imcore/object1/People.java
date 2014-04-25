package cn.imcore.object1;

public class People {
	
	//属性
    String name;
    int age;
    char sex;
	String eye;
	String hair;
	
	public People() {
		
	}
	
	public People(String name, int age) {
		
	}
	
	//行为-方法
	public String getName(){
		return name;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public void eating(String name) {
		System.out.println(name + "正在吃饭。。。。。。。。。。。");
	}
	
}
