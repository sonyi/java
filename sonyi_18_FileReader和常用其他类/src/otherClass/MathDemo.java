package otherClass;

import java.util.Random;
/*
 * �κ���ϰ��
 * 		����һ��С����������С���ĺ���λ
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
		double d = Math.ceil(16.34);//���ش���ָ�����ݵ���С������
		double d1 = Math.ceil(-16.54);
		sop(d);
		sop(d1);
		
		double d2 = Math.floor(16.34);//����С��ָ�����ݵ���С������
		double d3 = Math.floor(-16.54);
		sop(d2);
		sop(d3);
		
		double d4 = Math.round(16.54);//�������롣
		double d5 = Math.round(-16.34);
		sop(d4);
		sop(d5);
		
		double d6 = Math.pow(2,3);//������2��3�η���
		double d7 = Math.pow(3,3);
		sop(d6);
		sop(d7);
	}
	public static void sop(Object o){
		System.out.println(o);
	}
}
