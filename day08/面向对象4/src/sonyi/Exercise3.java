package sonyi;
/*
	��ϰ��
		����һ��������Vehicle�����࣬����Run��Stop�ȷ���������Speed���ٶȣ���MaxSpeed������ٶȣ���
			Weight�����������ֶΡ�Ȼ���Ը���Ϊ���࣬������bicycle
 */
public class Exercise3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicle v = new Bicycle("���г�",20,60,20);
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
		System.out.println("���г��������滷������������");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("���г�ͣ��");
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
		return "Vehicle [������" + name + ", ���٣�" + speed + ", ����ٶ�:"
				+ maxSpeed + ", ���أ�" + weight + "]";
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