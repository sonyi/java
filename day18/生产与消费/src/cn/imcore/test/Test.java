package cn.imcore.test;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Store s = new Store();
		new Customer(s, 20).start();
		new Producer(s, 20).start();
		new Producer(s, 30).start();
		new Producer(s, 50).start();
		new Customer(s, 60).start();
		new Customer(s, 20).start();
		new Customer(s, 50).start();
	}

}
