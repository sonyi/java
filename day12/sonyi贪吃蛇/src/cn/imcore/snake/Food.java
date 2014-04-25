package cn.imcore.snake;

import java.util.LinkedList;
import java.util.Random;

public class Food {//用链表集合存储食物，随机生成在游戏界面内
	LinkedList<Point> f = new LinkedList<Point>();
	Random r = new Random();
	public Food() {
		int x = r.nextInt(TestSnake.getrow()-2)+1;
		int y = r.nextInt(TestSnake.getcol()-2)+1;
		f.add(new Point(x,y));
	}
}
