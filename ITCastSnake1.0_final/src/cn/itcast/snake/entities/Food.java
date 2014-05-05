package cn.itcast.snake.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import cn.itcast.snake.util.Global;

/**
 * 
 * 食物, 有x , y 坐标 和 颜色等属性<BR>
 * 可以用setColor() 改变食物的颜色<BR>
 * 也可以通过覆盖 drawFood(Graphics, int, int, int, int) 方法 改变食物的显示方式<BR>
 * 
 * @version 1.0, 01/01/08
 * 
 * @author 汤阳光
 * 
 */
public class Food extends Point {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* 食物的颜色 */
	private Color color = new Color(0xcc0033);

	private Random random = new Random();

	/**
	 * 默认的构造器, 产生(0,0)的坐标
	 */
	public Food() {
		super();
	}

	public Point getNew() {
		Point p = new Point();
		p.x = random.nextInt(Global.WIDTH);
		p.y = random.nextInt(Global.HEIGHT);
		return p;
	}

	/**
	 * 初始化坐标和指定坐标相同的构造器
	 * 
	 * @param x
	 * @param y
	 */
	public Food(Point p) {
		super(p);
	}

	/**
	 * 蛇是否吃到了食物
	 * 
	 * @param p
	 * @return
	 */
	public boolean isSnakeEatFood(Snake snake) {
		return this.equals(snake.getHead());
	}

	/**
	 * 画自己, 将调用 drawFood(Graphics, int, int, int, int) 方法
	 * 
	 * @param g
	 */

	public void drawMe(Graphics g) {
		g.setColor(color);
		drawFood(g, x * Global.CELL_WIDTH, y * Global.CELL_HEIGHT,
				Global.CELL_WIDTH, Global.CELL_HEIGHT);
	}

	/**
	 * 画食物, 可以覆盖这个方法改变食物的显示
	 * 
	 * @param g
	 * @param x
	 *            像素坐标 x
	 * @param y
	 *            像素坐标 y
	 * @param width
	 *            宽度(单位:像素)
	 * @param height
	 *            高度(单位:像素)
	 */
	public void drawFood(Graphics g, int x, int y, int width, int height) {
		g.fill3DRect(x, y, width, height, true);
	}

	/**
	 * 得到食物的颜色
	 * 
	 * @return
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * 设置食物的颜色
	 * 
	 * @param color
	 */
	public void setColor(Color color) {
		this.color = color;
	}

}
