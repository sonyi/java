package cn.imcore.prac;

public class TestCar {

	public static void main(String[] args) {
		SubCar bmw = new SubCar("宝马", 100, 120);
		SubCar benchi = new SubCar("奔驰", 120, 120);
		
		//打印车的详细信息
		System.out.println(bmw);
		System.out.println(benchi);
		//测试车的质量--跑
		bmw.drive();
		benchi.drive();
		
		//测试变速是否正常
		benchi.changeSpeed(150);
		System.out.println(benchi);
	}
}


class Car{
	private String mark;  //品牌
	
	Car() {
		
	}
	
	Car(String mark) {
		this.mark = mark;
	}

	//驾驶
	public void drive() {
		System.out.println(mark + " is driving.");
	}
	//=======get/set
	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}
	
	
}


class SubCar extends Car{
	private int price;  //价格
	private int speed;  //速度
	
	SubCar(String mark, int price, int speed) {
		super(mark);
		this.price = price;
		this.speed = speed;
	}
	//变速
	public void changeSpeed(int newSpeed) {
		speed = newSpeed;
	}
	@Override
	public String toString() {
		return "SubCar [品牌=" + super.getMark() + ", 价格=" + price + ", 速度=" + speed + "]";
	}
	
	
	
}






