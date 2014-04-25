package cn.imcore.prac;

public class TestCal {

	public static void main(String[] args) {
		Calculate2 c = new Calculate2();
		System.out.println(c.plus(5, 2, 1));//8
		System.out.println(c.sub(5, 2, 1));//2
		System.out.println(c.mix(5, 2, 1));//10
		System.out.println(c.div(5, 2, 1));//1
	}
}
