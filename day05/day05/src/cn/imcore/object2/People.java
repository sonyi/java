package cn.imcore.object2;

public class People {
	
	//����(��װ)
    private String name;
    private int age = 1;
    private char sex;
    private String eye;
    private String hair;
	
	public People() {
		
	}
	
	public People(String name, int age) {
		
	}
	
	//��Ϊ-����
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
		if(age<=0 || age>120) {//����Ĺ���
			System.out.println("���䲻�Ϸ�");
			return;
		}
		this.age = age;
		
	}
	
	public void eating(String name) {
		System.out.println(name + "���ڳԷ�����������������������");
	}
	
}
