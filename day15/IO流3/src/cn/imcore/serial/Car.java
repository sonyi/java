package cn.imcore.serial;

import java.io.Serializable;
//ʵ�����л��ӿ�
public class Car implements Serializable{

	private String brand;//Ʒ��
	private int size;//��С
	transient private int price;//�۸�  �������л�
	
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
