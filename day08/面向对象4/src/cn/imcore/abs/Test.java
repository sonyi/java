package cn.imcore.abs;

public class Test {

	public static void main(String[] args){
//		Animal a = new Animal(); //抽象类不能被实例化
		
		Animal a = new Bird("鸟"); //实例化子类
		a.eat();
		a.enjoy();
	}
}

//抽象类
abstract class Animal {
	//属性
	private String name;
	
	//构造方法
	public Animal() {
		
	}
	
	public Animal(String name) {
		this.name = name;
	}
	
	//普通方法
	public void enjoy() {
		System.out.println("动物在叫.........");
	}
	
	public String getName() {
		return name;
	}
	//抽象方法(只定义不实现，就是没有方法体)
	public abstract void eat();
}

class Bird extends Animal {

	Bird(String n) {
		super(n);
	}
	@Override
	public void eat() {//抽象方法必须被重写
		System.out.println(super.getName() + "在吃.....");
		
	}
	
	
	public void fly() {
		System.out.println(super.getName() + "在飞.....");
	}
	
}

abstract class Dog extends Animal {//如果重写不了，应该声明自己为抽象类。
	Dog(String n) {
		super(n);
	}
}



