package cn.imcore.prac;

public class TestCar {

	public static void main(String[] args) {
		SubCar bmw = new SubCar("����", 100, 120);
		SubCar benchi = new SubCar("����", 120, 120);
		
		//��ӡ������ϸ��Ϣ
		System.out.println(bmw);
		System.out.println(benchi);
		//���Գ�������--��
		bmw.drive();
		benchi.drive();
		
		//���Ա����Ƿ�����
		benchi.changeSpeed(150);
		System.out.println(benchi);
	}
}


class Car{
	private String mark;  //Ʒ��
	
	Car() {
		
	}
	
	Car(String mark) {
		this.mark = mark;
	}

	//��ʻ
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
	private int price;  //�۸�
	private int speed;  //�ٶ�
	
	SubCar(String mark, int price, int speed) {
		super(mark);
		this.price = price;
		this.speed = speed;
	}
	//����
	public void changeSpeed(int newSpeed) {
		speed = newSpeed;
	}
	@Override
	public String toString() {
		return "SubCar [Ʒ��=" + super.getMark() + ", �۸�=" + price + ", �ٶ�=" + speed + "]";
	}
	
	
	
}






