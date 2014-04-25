package cn.imcore.abs;

public class Test {

	public static void main(String[] args){
//		Animal a = new Animal(); //�����಻�ܱ�ʵ����
		
		Animal a = new Bird("��"); //ʵ��������
		a.eat();
		a.enjoy();
	}
}

//������
abstract class Animal {
	//����
	private String name;
	
	//���췽��
	public Animal() {
		
	}
	
	public Animal(String name) {
		this.name = name;
	}
	
	//��ͨ����
	public void enjoy() {
		System.out.println("�����ڽ�.........");
	}
	
	public String getName() {
		return name;
	}
	//���󷽷�(ֻ���岻ʵ�֣�����û�з�����)
	public abstract void eat();
}

class Bird extends Animal {

	Bird(String n) {
		super(n);
	}
	@Override
	public void eat() {//���󷽷����뱻��д
		System.out.println(super.getName() + "�ڳ�.....");
		
	}
	
	
	public void fly() {
		System.out.println(super.getName() + "�ڷ�.....");
	}
	
}

abstract class Dog extends Animal {//�����д���ˣ�Ӧ�������Լ�Ϊ�����ࡣ
	Dog(String n) {
		super(n);
	}
}



