package cn.imcore.test;

import java.util.Random;

public class TestRandom {

	public static void main(String[] args) {
		//Mathȡ�����
		double d1 = Math.random();
		System.out.println(d1);
		//[0-10]
		int i1 = (int)(d1*10); 
		long i2 = Math.round(d1*10);//��������
		System.out.println(i1 + ", " + i2);
		
		//randomȡ�����
		Random r = new Random();
		double d2 = r.nextDouble(); //0-1
		System.out.println(d2);
		int i3 = r.nextInt(100);//[0-99]
		System.out.println(i3);
	}
}
