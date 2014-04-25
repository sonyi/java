package cn.imcore.object5;

public class TestCar {

	public static void main(String[] args) {
		//方式1 初始化
		Car bmw = new Car();
		bmw.setBrand("bmw");
		bmw.setColor("黑色");
		bmw.setSize(8);
		bmw.setPrice(100);
		
		Car audi = new Car();
		audi.setBrand("audi");
		audi.setColor("红色");
		audi.setSize(7);
		audi.setPrice(90);
		
		Car benchi = new Car();
		benchi.setBrand("benchi");
		benchi.setColor("白色");
		benchi.setSize(9);
		benchi.setPrice(120);
		
		//打印3辆车的信息
		bmw.printCar();
		audi.printCar();
		benchi.printCar();
		
		bmw.driving();
		audi.driving();
		benchi.stopping();
		//方式2 初始化
		
		
	}
}
