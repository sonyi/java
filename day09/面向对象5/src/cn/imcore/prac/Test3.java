package cn.imcore.prac;

public class Test3 {

	public static void main(String[] args) {
		Bicycle bike = new Bicycle(20, 50, 15);
		Car car = new Car(80, 120, 10000);
		
		bike.run();
		car.run();
		bike.stop();
		car.stop();
	}
}


class Vehicle {
	//属性
	private int speed;
	private int maxSpeed;
	private int weight;
	
	//构造方法
	public Vehicle() {
		
	}
	
	public Vehicle(int speed, int maxSpeed, int weight) {
		this.speed = speed;
		this.maxSpeed = maxSpeed;
		this.weight = weight;
	}
	
	//方法
	public void run() {
		//
	}
	
	public void stop() {
		//
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
}


class Bicycle extends Vehicle{

	public Bicycle(int speed, int maxSpeed, int weight) {
		super(speed, maxSpeed, weight);
	}
	
	@Override
	public void run() {
		System.out.println("自行车 速度为" + super.getSpeed()
				+ ",最大速度为" + super.getMaxSpeed()
				+ ",重量为" + super.getWeight());
	}

	@Override
	public void stop() {
		System.out.println("自行车停止了");
	}
	
}

class Car extends Vehicle {

	public Car(int speed, int maxSpeed, int weight) {
		super(speed, maxSpeed, weight);
	}
	
	@Override
	public void run() {
		System.out.println("小车 速度为" + super.getSpeed()
				+ ",最大速度为" + super.getMaxSpeed()
				+ ",重量为" + super.getWeight());
	}

	@Override
	public void stop() {
		System.out.println("小车停止了");
	}
	
}