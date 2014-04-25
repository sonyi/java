package otherClass;

import java.util.Random;
/*
 * 课后练习：
 * 		给定一个小数，保留该小数的后两位
 */
public class MathDemo {
	public static void main(String[] args) {
		Random random = new Random();
		
		for(int x = 0; x < 10; x++){
			//int d = (int)(Math.random()*10 + 1);
			int d = random.nextInt(10+1);
			sop(d);
		}

	}
	
	public static void show(){
		double d = Math.ceil(16.34);//返回大于指定数据的最小整数。
		double d1 = Math.ceil(-16.54);
		sop(d);
		sop(d1);
		
		double d2 = Math.floor(16.34);//返回小于指定数据的最小整数。
		double d3 = Math.floor(-16.54);
		sop(d2);
		sop(d3);
		
		double d4 = Math.round(16.54);//四舍五入。
		double d5 = Math.round(-16.34);
		sop(d4);
		sop(d5);
		
		double d6 = Math.pow(2,3);//幂运算2的3次方。
		double d7 = Math.pow(3,3);
		sop(d6);
		sop(d7);
	}
	public static void sop(Object o){
		System.out.println(o);
	}
}
