package cn.imcore.serial;

import java.io.Serializable;
//实现序列化接口
public class Car implements Serializable{

	private String brand;//品牌
	private int size;//大小
	transient private int price;//价格  不做序列化
	
	public Car(String brand, int size, int price) {
		this.brand = brand;
		this.size = size;
		this.price = price;
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Car [brand=" + brand + ", size=" + size + ", price=" + price
				+ "]";
	}
	
	
	

}
