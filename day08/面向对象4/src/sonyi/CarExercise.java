package sonyi;

/*
	练习：
		编写一个Java程序，满足以下要求：
			1、编写一个Car类，具有：
				属性：品牌(mark)----String类型
				功能：驾驶(void drive())
			2、定义Car类的子类SubCar，具有：
				属性：价格(price)、速度(speed)----int型
				功能：变速(void speedChange(int speed))，把新速度赋值给speed
			3、定义主类，在main方法中创建SubCar类的两个对象，bmw和benchi的对象并测试其对象的特性。
 */
public class CarExercise {
	public static void main(String[] args) {
		//实现两个对象
		SubCar bmw = new SubCar("bmw",100,80);
		SubCar benz = new SubCar("benz",110,90);
		
		System.out.println(bmw);
		bmw.drive();
		bmw.speedChange(200);
		
		System.out.println(benz);
		benz.drive();
		benz.speedChange(250);
	}

}

//子类继承父类
class SubCar extends Car{
	private int price;
	private int speed;
	
	SubCar(){
		
	}
	
	SubCar(String mark,int price,int speed){
		super(mark);
		this.price = price;
		this.speed = speed;
	}
	
	public void speedChange(int speed){
		System.out.println(getMark() + "现在变速为：" + speed);
		setSpeed(speed);
	}
	
	
	@Override
	public String toString() {
		return "我是" + getMark() + ",我的价格是：" + price + ", 我现在的速度是：" + speed;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
}

//父类
class Car{
	private String mark;
	Car(){
		
	}
	Car(String mark){
		this.mark = mark;
	}
	public void drive(){
		System.out.println(getMark() + "正在行驶。。。。");
	}
	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}
}