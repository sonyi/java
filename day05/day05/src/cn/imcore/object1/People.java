package cn.imcore.object1;

public class People {
	
	//����
    String name;
    int age;
    char sex;
	String eye;
	String hair;
	
	public People() {
		
	}
	
	public People(String name, int age) {
		
	}
	
	//��Ϊ-����
	public String getName(){
		return name;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public void eating(String name) {
		System.out.println(name + "���ڳԷ�����������������������");
	}
	
}
