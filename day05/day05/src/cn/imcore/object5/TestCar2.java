package cn.imcore.object5;

public class TestCar2 {
	public static void main(String[] args) {
		//方式2 初始化  直接通过构造方法进行实例化
		Car bmw = new Car("bmw","黑色",8,100);
		Car audi = new Car("audi","红色",7,90);
		Car benchi = new Car("benchi","白色",9,120);
		
		//对象名.方法
		bmw.printCar();
		audi.printCar();
		benchi.printCar();
		
		System.out.println("======修改宝马价格======");
		//假设宝马的价格录错了，要纠正价格，调用修改价格的方法
		bmw.setSize(150);
		bmw.printCar();
		
		System.out.println("");
		bmw.driving();
		audi.driving();
		benchi.stopping();
	}
	
}
