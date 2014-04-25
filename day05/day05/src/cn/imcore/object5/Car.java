package cn.imcore.object5;

/**
 * 构造方法名必须和类名一致
 * 当成员变量与局部变量重名的时候，通过‘this.属性’访问成员变量
 * @author Administrator
 *
 */
public class Car {

	//属性
	private String brand;//品牌
	private String color;//颜色
	private int size;//大小
	private double price; //价格
	
	//无参构造方法
	public Car() {
		
	}
	
	//带参的构造方法
	public Car(String brand, String color, int size, double price) {
		this.brand = brand;
		this.color = color;
		this.size = size;
		this.price = price;
	}
	
	//取品牌的内容
	public String getBrand() {
		return brand;
	}
	
	//设置品牌的内容
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	//取颜色的内容
	public String getColor() {
		return color;
	}
	
	//设置车的颜色
	public void setColor(String color) {
		this.color = color;
	}
	
	//车的大小
	public int getSize() {
		return size;
	}
	
	//改车的大小
	public void setSize(int size) {
		this.size = size;
	}
	
	//想得到价格
	public double getPrice() {
		return price;
	}
	
	//修改价格
	public void setPrice(double price) {
		this.price = price;
	}
	
	//打印车的所有信息
	public void printCar(){
		System.out.println(brand + "," + color + "," + size + "," + price);
	}
	
	//跑的方法
	public void driving() {
		System.out.println(brand + "在跑。。。。");
	}
	
	//停止的方法
	public void stopping() {
		System.out.println(brand + "停止.....");
	}
	
}
