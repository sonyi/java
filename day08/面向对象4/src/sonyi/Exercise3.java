package sonyi;
/*
	练习：
		定义一个车辆（Vehicle）基类，具有Run、Stop等方法，具有Speed（速度）、MaxSpeed（最大速度）、
			Weight（重量）等字段。然后以该类为基类，派生出bicycle
 */
public class Exercise3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicle v = new Bicycle("自行车",20,60,20);
		System.out.println(v);
		v.run();
		v.stop();
	}
}

class Bicycle extends Vehicle{
	Bicycle(){
		
	}
	Bicycle(String name,int speed,int maxSpeed,double weight){
		super(name,speed,maxSpeed,weight);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("自行车跑起来真环保。。。。。");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("自行车停了");
	}	
}

abstract class Vehicle{
	private String name;
	private int speed;
	private int maxSpeed;
	private double weight;
	
	Vehicle(){
		
	}
	Vehicle(String name,int speed,int maxSpeed,double weight){
		this.name = name;
		this.speed = speed;
		this.maxSpeed = maxSpeed;
		this.weight = weight;
	}
	
	public abstract void run();
	public abstract void stop();
	
	
	@Override
	public String toString() {
		return "Vehicle [车名：" + name + ", 车速：" + speed + ", 最大速度:"
				+ maxSpeed + ", 车重：" + weight + "]";
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
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}