package cn.imcore.snake;

import java.util.LinkedList;
import java.util.Random;

public class Snake {
	//�������ϴ洢�ߣ�ÿ������Ϊһ������(һ�������)
	LinkedList<Point> s = new LinkedList<Point>();
	Random r = new Random();
	
	public Snake() {//�������������Ϸ������м䲿λ
		int x = r.nextInt(TestSnake.getrow()/2)+TestSnake.getrow()/4;
		int y = r.nextInt(TestSnake.getcol()/2)+TestSnake.getrow()/4;
		for(int i=1; i<=3; i++) {//��ʼ���߳�3��
			s.push(new Point(x, y-i));
		}
	}
}
