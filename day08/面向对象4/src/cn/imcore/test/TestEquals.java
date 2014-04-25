package cn.imcore.test;

public class TestEquals {

	int a;
	int b;
	
	TestEquals(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public static void main(String[] args) {
		TestEquals t1 = new TestEquals(2, 3);
		TestEquals t2 = new TestEquals(2, 3);
		
		System.out.println(t1.equals(t2));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		result = prime * result + b;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		return true;
	}
	
} 
