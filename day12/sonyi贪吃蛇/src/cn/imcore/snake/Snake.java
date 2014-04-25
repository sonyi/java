package cn.imcore.snake;

import java.util.LinkedList;
import java.util.Random;

public class Snake {
	//用链表集合存储蛇，每节蛇身为一个对象(一个点对象)
	LinkedList<Point> s = new LinkedList<Point>();
	Random r = new Random();
	
	public Snake() {//蛇随机生成在游戏界面的中间部位
		int x = r.nextInt(TestSnake.getrow()/2)+TestSnake.getrow()/4;
		int y = r.nextInt(TestSnake.getcol()/2)+TestSnake.getrow()/4;
		for(int i=1; i<=3; i++) {//初始化蛇长3格
			s.push(new Point(x, y-i));
		}
	}
}
