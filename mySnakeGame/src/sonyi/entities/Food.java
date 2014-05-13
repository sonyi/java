package sonyi.entities;

import java.awt.Graphics;
import java.awt.Point;

import sonyi.util.Global;

public class Food extends Point{
	private static final long serialVersionUID = 1L;

	public void newFood(Point p){//设置新食物的位置
		this.setLocation(p);
	}
	
	public boolean isSnakeEatFood(Snake snake){//判断食物是否被蛇迟到
		System.out.println("Food's isSnakeEatFood");
		return this.equals(snake.getHead());
	}
	
	public void drawMe(Graphics g){//在画板中画出食物位置
		System.out.println("Food's drawMe");
		g.fill3DRect(x * Global.CELL_SIZE, y * Global.CELL_SIZE,
				Global.CELL_SIZE,Global.CELL_SIZE,true);
	}
}
