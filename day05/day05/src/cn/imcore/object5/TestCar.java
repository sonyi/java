package cn.imcore.object5;

public class TestCar {

	public static void main(String[] args) {
		//��ʽ1 ��ʼ��
		Car bmw = new Car();
		bmw.setBrand("bmw");
		bmw.setColor("��ɫ");
		bmw.setSize(8);
		bmw.setPrice(100);
		
		Car audi = new Car();
		audi.setBrand("audi");
		audi.setColor("��ɫ");
		audi.setSize(7);
		audi.setPrice(90);
		
		Car benchi = new Car();
		benchi.setBrand("benchi");
		benchi.setColor("��ɫ");
		benchi.setSize(9);
		benchi.setPrice(120);
		
		//��ӡ3��������Ϣ
		bmw.printCar();
		audi.printCar();
		benchi.printCar();
		
		bmw.driving();
		audi.driving();
		benchi.stopping();
		//��ʽ2 ��ʼ��
		
		
	}
}
