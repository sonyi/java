package cn.imcore.object5;

public class TestCar2 {
	public static void main(String[] args) {
		//��ʽ2 ��ʼ��  ֱ��ͨ�����췽������ʵ����
		Car bmw = new Car("bmw","��ɫ",8,100);
		Car audi = new Car("audi","��ɫ",7,90);
		Car benchi = new Car("benchi","��ɫ",9,120);
		
		//������.����
		bmw.printCar();
		audi.printCar();
		benchi.printCar();
		
		System.out.println("======�޸ı���۸�======");
		//���豦��ļ۸�¼���ˣ�Ҫ�����۸񣬵����޸ļ۸�ķ���
		bmw.setSize(150);
		bmw.printCar();
		
		System.out.println("");
		bmw.driving();
		audi.driving();
		benchi.stopping();
	}
	
}
