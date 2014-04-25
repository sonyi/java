package sonyi;

/*
	��ϰ��
		��дһ��Java������������Ҫ��
			1����дһ��Car�࣬���У�
				���ԣ�Ʒ��(mark)----String����
				���ܣ���ʻ(void drive())
			2������Car�������SubCar�����У�
				���ԣ��۸�(price)���ٶ�(speed)----int��
				���ܣ�����(void speedChange(int speed))�������ٶȸ�ֵ��speed
			3���������࣬��main�����д���SubCar�����������bmw��benchi�Ķ��󲢲������������ԡ�
 */
public class CarExercise {
	public static void main(String[] args) {
		//ʵ����������
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

//����̳и���
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
		System.out.println(getMark() + "���ڱ���Ϊ��" + speed);
		setSpeed(speed);
	}
	
	
	@Override
	public String toString() {
		return "����" + getMark() + ",�ҵļ۸��ǣ�" + price + ", �����ڵ��ٶ��ǣ�" + speed;
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

//����
class Car{
	private String mark;
	Car(){
		
	}
	Car(String mark){
		this.mark = mark;
	}
	public void drive(){
		System.out.println(getMark() + "������ʻ��������");
	}
	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}
}