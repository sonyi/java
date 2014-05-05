package cn.itcast.snake.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import cn.itcast.snake.util.Global;

/**
 * 
 * ʳ��, ��x , y ���� �� ��ɫ������<BR>
 * ������setColor() �ı�ʳ�����ɫ<BR>
 * Ҳ����ͨ������ drawFood(Graphics, int, int, int, int) ���� �ı�ʳ�����ʾ��ʽ<BR>
 * 
 * @version 1.0, 01/01/08
 * 
 * @author ������
 * 
 */
public class Food extends Point {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* ʳ�����ɫ */
	private Color color = new Color(0xcc0033);

	private Random random = new Random();

	/**
	 * Ĭ�ϵĹ�����, ����(0,0)������
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
	 * ��ʼ�������ָ��������ͬ�Ĺ�����
	 * 
	 * @param x
	 * @param y
	 */
	public Food(Point p) {
		super(p);
	}

	/**
	 * ���Ƿ�Ե���ʳ��
	 * 
	 * @param p
	 * @return
	 */
	public boolean isSnakeEatFood(Snake snake) {
		return this.equals(snake.getHead());
	}

	/**
	 * ���Լ�, ������ drawFood(Graphics, int, int, int, int) ����
	 * 
	 * @param g
	 */

	public void drawMe(Graphics g) {
		g.setColor(color);
		drawFood(g, x * Global.CELL_WIDTH, y * Global.CELL_HEIGHT,
				Global.CELL_WIDTH, Global.CELL_HEIGHT);
	}

	/**
	 * ��ʳ��, ���Ը�����������ı�ʳ�����ʾ
	 * 
	 * @param g
	 * @param x
	 *            �������� x
	 * @param y
	 *            �������� y
	 * @param width
	 *            ���(��λ:����)
	 * @param height
	 *            �߶�(��λ:����)
	 */
	public void drawFood(Graphics g, int x, int y, int width, int height) {
		g.fill3DRect(x, y, width, height, true);
	}

	/**
	 * �õ�ʳ�����ɫ
	 * 
	 * @return
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * ����ʳ�����ɫ
	 * 
	 * @param color
	 */
	public void setColor(Color color) {
		this.color = color;
	}

}
