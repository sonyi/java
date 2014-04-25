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
	//����
	private int speed;
	private int maxSpeed;
	private int weight;
	
	//���췽��
	public Vehicle() {
		
	}
	
	public Vehicle(int speed, int maxSpeed, int weight) {
		this.speed = speed;
		this.maxSpeed = maxSpeed;
		this.weight = weight;
	}
	
	//����
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
		System.out.println("���г� �ٶ�Ϊ" + super.getSpeed()
				+ ",����ٶ�Ϊ" + super.getMaxSpeed()
				+ ",����Ϊ" + super.getWeight());
	}

	@Override
	public void stop() {
		System.out.println("���г�ֹͣ��");
	}
	
}

class Car extends Vehicle {

	public Car(int speed, int maxSpeed, int weight) {
		super(speed, maxSpeed, weight);
	}
	
	@Override
	public void run() {
		System.out.println("С�� �ٶ�Ϊ" + super.getSpeed()
				+ ",����ٶ�Ϊ" + super.getMaxSpeed()
				+ ",����Ϊ" + super.getWeight());
	}

	@Override
	public void stop() {
		System.out.println("С��ֹͣ��");
	}
	
}