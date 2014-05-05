package cn.itcast.snake.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import cn.itcast.snake.listener.SnakeListener;
import cn.itcast.snake.util.Global;

/**
 * 
 * ��<BR>
 * move()����Ĭ��֧���ߵ����Ժ����һ�߳���<BR>
 * <BR>
 * ������setHeadColor(), �� setBodyColor() ����������ͷ�����������ɫ<BR>
 * <BR>
 * Ҳ����ͨ������ drawHead(Graphics, int, int, int, int) ���� �ı���ͷ����ʾ��ʽ �͸���
 * drawBody(Graphics, int, int, int, int) ���� �ı����������ʾ��ʽ<BR>
 * <BR>
 * ���ڲ���MoveDriver �����߶�ʱ�ƶ�<BR>
 * begin() �����ڲ�����һ���µ��߳������߶�ʱ�ƶ�, �������������ʱ��Ҫע��<BR>
 * 
 * �ߵ�����ĳ�ʼ���ȱ�����ڵ���2
 * 
 * @version 1.0, 01/01/08
 * 
 * @author ������
 * 
 */
public class Snake {

	/**
	 * ������
	 */
	public static final int UP = 1;

	/**
	 * ������
	 */
	public static final int DOWN = -1;

	/**
	 * ������
	 */
	public static final int LEFT = 2;
	/**
	 * ������
	 */
	public static final int RIGHT = -2;

	/* ��(����ڵ�) */
	private LinkedList<Point> body = new LinkedList<Point>();

	/* ��һ�ε��ƶ����� */
	private int oldDirection;

	/* ��һ���ķ���(��Ч����) */
	private int newDirection;

	/* ��ʱ�����ͷ������ */
	private Point head;

	/* ��ʱ�����β�͵����� */
	private Point tail;

	/* �ƶ��ٶ� */
	private int speed;

	/* ����, �Ƿ���� */
	private boolean live;

	/* �Ƿ���ͣ */
	private boolean pause;

	private Set<SnakeListener> listeners = new HashSet<SnakeListener>();

	public static final Color DEFAULT_HEAD_COLOR = new Color(0xcc0033);
	/* ��ͷ����ɫ */
	private Color headColor = DEFAULT_HEAD_COLOR;

	public static final Color DEFAULT_BODY_COLOR = new Color(0xcc0033);
	/* ���������ɫ */
	private Color bodyColor = DEFAULT_BODY_COLOR;

	/**
	 * �ƶ�һ��, ������෴����
	 */
	public void move() {
		/* �����෴���� */
		if (oldDirection + newDirection != 0)
			oldDirection = newDirection;
		/* ����β���ó�����������������Ϊ����ͷ */
		/* getLocation ������һ���µ�Point */
		/* tail��β�����걣������, �Ե�ʳ��ʱ�ټ��� */
		tail = (head = takeTail()).getLocation();
		/* ������ͷ�������� �������� */
		head.setLocation(getHead());
		/* ���ݷ��������ƶ� */
		switch (oldDirection) {
		case UP:
			head.y--;
			/* �������˿��Դ���һ�߳��� */
			if (head.y < 0)
				head.y = Global.HEIGHT - 1;
			break;
		case DOWN:
			head.y++;
			/* �������˿��Դ���һ�߳��� */
			if (head.y == Global.HEIGHT)
				head.y = 0;
			break;
		case LEFT:
			head.x--;
			/* �������˿��Դ���һ�߳��� */
			if (head.x < 0)
				head.x = Global.WIDTH - 1;
			break;
		case RIGHT:
			head.x++;
			/* �������˿��Դ���һ�߳��� */
			if (head.x == Global.WIDTH)
				head.x = 0;
			break;
		}
		/* ��ӵ�ͷ��ȥ */
		body.addFirst(head);
	}

	/**
	 * һ���ڲ���, �����߶�ʱ�ƶ�
	 * 
	 * @author ������
	 * 
	 */
	private class SnakeDriver implements Runnable {

		public void run() {
			// TODO Auto-generated method stub
			while (live) {
				if (!pause) {
					move();
					/* ���� ControllerListener ��״̬�ı��¼� */
					for (SnakeListener l : listeners)
						l.snakeMoved();
				}
				try {
					Thread.sleep(speed);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * ��β��������һ���ڵ�
	 */
	public void eatFood() {
		/* ����һ���ƶ��õ��Ľڵ��ټ��� */
		body.addLast(tail.getLocation());
		/* ����SnakeListener �� snakeEatFood �¼� */
		for (SnakeListener l : listeners)
			l.snakeEatFood();
	}

	/**
	 * �ı䷽��
	 * 
	 * @param direction
	 */
	public void changeDirection(int direction) {
		this.newDirection = direction;
	}

	/**
	 * �õ���ͷ�ڵ�
	 * 
	 * @return
	 */
	public Point getHead() {
		/* �Լ�Լ���ĸ�����ͷ */
		return body.getFirst();
	}

	/**
	 * �õ���β�ͽڵ�
	 * 
	 * @return
	 */
	public Point takeTail() {
		/* ȥ����β�� */
		return body.removeLast();
	}

	/**
	 * �õ��ߵĳ���
	 * 
	 * @return
	 */
	public int getLength() {
		return body.size();
	}

	/**
	 * ���߿�ʼ�˶�<BR>
	 * ����һ���µ��߳�
	 */
	public void begin() {
		new Thread(new SnakeDriver()).start();
	}

	/**
	 * ���߸���, ����ʼ�˶�<BR>
	 * ������ begin() ����
	 */
	public void reNew() {
		init();
		begin();
	}

	/**
	 * ��ʼ���ߵ���Ϣ<BR>
	 * ����, λ��, ����, �ٶ�, ��������ͣ״̬
	 */
	public void init() {
		body.clear();
		/* ��ʼ��λ�����м� */
		int x = Global.WIDTH / 2 - Global.INIT_LENGTH / 2;
		int y = Global.HEIGHT / 2;
		for (int i = 0; i < Global.INIT_LENGTH; i++)
			this.body.addFirst(new Point(x++, y));
		/* ����Ĭ�Ϸ���Ϊ���� */
		oldDirection = newDirection = RIGHT;
		/* ��ʼ���ٶ� */
		speed = Global.SPEED;
		/* ��ʼ����������ͣ״̬ */
		live = true;
		pause = false;
	}

	/**
	 * �Ƿ�Ե��Լ�������<BR>
	 * 
	 * @return ��ͷ�������Ƿ���Լ��������ĳһ�������غ�
	 */
	public boolean isEatBody() {
		/* Ҫ����ͷ�ų�, body.get(0) ����ͷ */
		for (int i = 1; i < body.size(); i++)
			if (getHead().equals(body.get(i)))
				return true;
		return false;
	}

	/**
	 * ���Լ�<BR>
	 * ������ drawHead(Graphics, int, int, int, int) ���� �� drawBody(Graphics, int,
	 * int, int, int) ����
	 * 
	 * @param g
	 */
	public void drawMe(Graphics g) {
		for (Point p : body) {
			/* �������� */
			g.setColor(bodyColor);
			drawBody(g, p.x * Global.CELL_WIDTH, p.y * Global.CELL_HEIGHT,
					Global.CELL_WIDTH, Global.CELL_HEIGHT);
		}
		/* ����ͷ */
		g.setColor(headColor);
		drawHead(g, getHead().x * Global.CELL_WIDTH, getHead().y
				* Global.CELL_HEIGHT, Global.CELL_WIDTH, Global.CELL_HEIGHT);
	}

	/**
	 * ����ͷ, ���Ը�����������ı���ͷ����ʾ
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
	public void drawHead(Graphics g, int x, int y, int width, int height) {
		g.fill3DRect(x, y, width, height, true);
	}

	/**
	 * ���ߵ�һ������, ���Ը�����������ı��ߵ�����ڵ����ʾ
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
	public void drawBody(Graphics g, int x, int y, int width, int height) {
		g.fill3DRect(x, y, width, height, true);
	}

	/**
	 * �õ���ͷ����ɫ
	 * 
	 * @return
	 */
	public Color getHeadColor() {
		return headColor;
	}

	/**
	 * ������ͷ����ɫ
	 * 
	 * @param headColor
	 */
	public void setHeadColor(Color headColor) {
		this.headColor = headColor;
	}

	/**
	 * �õ����������ɫ
	 * 
	 * @return
	 */
	public Color getBodyColor() {
		return bodyColor;
	}

	/**
	 * �������������ɫ
	 * 
	 * @param bodyColor
	 */
	public void setBodyColor(Color bodyColor) {
		this.bodyColor = bodyColor;
	}

	/**
	 * ��Ӽ�����
	 * 
	 * @param l
	 */
	public synchronized void addSnakeListener(SnakeListener l) {
		if (l == null)
			return;
		this.listeners.add(l);
	}

	/**
	 * �Ƴ�������
	 * 
	 * @param l
	 */
	public synchronized void removeSnakeListener(SnakeListener l) {
		if (l == null)
			return;
		this.listeners.remove(l);
	}

	/**
	 * ����, ����Ϊ Global �����õ� SPEED_STEP <BR>
	 * ����Ч���ٶȷ�Χ֮��(���Ӻ��ٶȴ��� 0����/��)
	 */
	public void speedUp() {
		if (speed > Global.SPEED_STEP)
			speed -= Global.SPEED_STEP;
	}

	/**
	 * ����, ����Ϊ Global �����õ� SPEED_STEP
	 */
	public void speedDown() {
		speed += Global.SPEED_STEP;
	}

	/**
	 * �õ��ߵ��ƶ��ٶ�
	 * 
	 * @return
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * �����ߵ��ƶ��ٶ�
	 * 
	 * @param speed
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * ���Ƿ�������
	 * 
	 * @return
	 */
	public boolean isLive() {
		return live;
	}

	/**
	 * �������Ƿ�����
	 * 
	 * @param live
	 */
	public void setLive(boolean live) {
		this.live = live;
	}

	/**
	 * ����������
	 */
	public void dead() {
		this.live = false;
	}

	/**
	 * �Ƿ�����ͣ״̬
	 * 
	 * @return
	 */
	public boolean isPause() {
		return pause;
	}

	/**
	 * ������ͣ״̬
	 * 
	 * @param pause
	 */
	public void setPause(boolean pause) {
		this.pause = pause;
	}

	/**
	 * ������ͣ״̬<BR>
	 * ������ͣ״̬, ������ƶ�<BR>
	 * �������ƶ�, ����ͣ
	 */
	public void changePause() {
		pause = !pause;
	}

}