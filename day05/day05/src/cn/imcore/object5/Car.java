package cn.imcore.object5;

/**
 * ���췽�������������һ��
 * ����Ա������ֲ�����������ʱ��ͨ����this.���ԡ����ʳ�Ա����
 * @author Administrator
 *
 */
public class Car {

	//����
	private String brand;//Ʒ��
	private String color;//��ɫ
	private int size;//��С
	private double price; //�۸�
	
	//�޲ι��췽��
	public Car() {
		
	}
	
	//���εĹ��췽��
	public Car(String brand, String color, int size, double price) {
		this.brand = brand;
		this.color = color;
		this.size = size;
		this.price = price;
	}
	
	//ȡƷ�Ƶ�����
	public String getBrand() {
		return brand;
	}
	
	//����Ʒ�Ƶ�����
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	//ȡ��ɫ������
	public String getColor() {
		return color;
	}
	
	//���ó�����ɫ
	public void setColor(String color) {
		this.color = color;
	}
	
	//���Ĵ�С
	public int getSize() {
		return size;
	}
	
	//�ĳ��Ĵ�С
	public void setSize(int size) {
		this.size = size;
	}
	
	//��õ��۸�
	public double getPrice() {
		return price;
	}
	
	//�޸ļ۸�
	public void setPrice(double price) {
		this.price = price;
	}
	
	//��ӡ����������Ϣ
	public void printCar(){
		System.out.println(brand + "," + color + "," + size + "," + price);
	}
	
	//�ܵķ���
	public void driving() {
		System.out.println(brand + "���ܡ�������");
	}
	
	//ֹͣ�ķ���
	public void stopping() {
		System.out.println(brand + "ֹͣ.....");
	}
	
}
