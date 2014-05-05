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
 * 蛇<BR>
 * move()方法默认支持走到边以后从另一边出现<BR>
 * <BR>
 * 可以用setHeadColor(), 和 setBodyColor() 方法更改蛇头或蛇身体的颜色<BR>
 * <BR>
 * 也可以通过覆盖 drawHead(Graphics, int, int, int, int) 方法 改变蛇头的显示方式 和覆盖
 * drawBody(Graphics, int, int, int, int) 方法 改变蛇身体的显示方式<BR>
 * <BR>
 * 用内部类MoveDriver 驱动蛇定时移动<BR>
 * begin() 方法内部开启一个新的线程驱动蛇定时移动, 调用这个方法的时候要注意<BR>
 * 
 * 蛇的身体的初始长度必须大于等于2
 * 
 * @version 1.0, 01/01/08
 * 
 * @author 汤阳光
 * 
 */
public class Snake {

	/**
	 * 方向上
	 */
	public static final int UP = 1;

	/**
	 * 方向下
	 */
	public static final int DOWN = -1;

	/**
	 * 方向左
	 */
	public static final int LEFT = 2;
	/**
	 * 方向右
	 */
	public static final int RIGHT = -2;

	/* 蛇(多个节点) */
	private LinkedList<Point> body = new LinkedList<Point>();

	/* 上一次的移动方向 */
	private int oldDirection;

	/* 下一步的方向(有效方向) */
	private int newDirection;

	/* 临时存放蛇头的坐标 */
	private Point head;

	/* 临时存放蛇尾巴的坐标 */
	private Point tail;

	/* 移动速度 */
	private int speed;

	/* 生命, 是否活着 */
	private boolean live;

	/* 是否暂停 */
	private boolean pause;

	private Set<SnakeListener> listeners = new HashSet<SnakeListener>();

	public static final Color DEFAULT_HEAD_COLOR = new Color(0xcc0033);
	/* 蛇头的颜色 */
	private Color headColor = DEFAULT_HEAD_COLOR;

	public static final Color DEFAULT_BODY_COLOR = new Color(0xcc0033);
	/* 蛇身体的颜色 */
	private Color bodyColor = DEFAULT_BODY_COLOR;

	/**
	 * 移动一步, 会忽略相反方向
	 */
	public void move() {
		/* 忽略相反方向 */
		if (oldDirection + newDirection != 0)
			oldDirection = newDirection;
		/* 把蛇尾巴拿出来重新设置坐标作为新蛇头 */
		/* getLocation 将返回一个新的Point */
		/* tail把尾巴坐标保存下来, 吃到食物时再加上 */
		tail = (head = takeTail()).getLocation();
		/* 根据蛇头的坐标再 上下左右 */
		head.setLocation(getHead());
		/* 根据方向让蛇移动 */
		switch (oldDirection) {
		case UP:
			head.y--;
			/* 到边上了可以从另一边出现 */
			if (head.y < 0)
				head.y = Global.HEIGHT - 1;
			break;
		case DOWN:
			head.y++;
			/* 到边上了可以从另一边出现 */
			if (head.y == Global.HEIGHT)
				head.y = 0;
			break;
		case LEFT:
			head.x--;
			/* 到边上了可以从另一边出现 */
			if (head.x < 0)
				head.x = Global.WIDTH - 1;
			break;
		case RIGHT:
			head.x++;
			/* 到边上了可以从另一边出现 */
			if (head.x == Global.WIDTH)
				head.x = 0;
			break;
		}
		/* 添加到头上去 */
		body.addFirst(head);
	}

	/**
	 * 一个内部类, 驱动蛇定时移动
	 * 
	 * @author 汤阳光
	 * 
	 */
	private class SnakeDriver implements Runnable {

		public void run() {
			// TODO Auto-generated method stub
			while (live) {
				if (!pause) {
					move();
					/* 触发 ControllerListener 的状态改变事件 */
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
	 * 在尾巴上增加一个节点
	 */
	public void eatFood() {
		/* 把上一次移动拿掉的节点再加上 */
		body.addLast(tail.getLocation());
		/* 触发SnakeListener 的 snakeEatFood 事件 */
		for (SnakeListener l : listeners)
			l.snakeEatFood();
	}

	/**
	 * 改变方向
	 * 
	 * @param direction
	 */
	public void changeDirection(int direction) {
		this.newDirection = direction;
	}

	/**
	 * 得到蛇头节点
	 * 
	 * @return
	 */
	public Point getHead() {
		/* 自己约定哪个是蛇头 */
		return body.getFirst();
	}

	/**
	 * 拿掉蛇尾巴节点
	 * 
	 * @return
	 */
	public Point takeTail() {
		/* 去掉蛇尾巴 */
		return body.removeLast();
	}

	/**
	 * 得到蛇的长度
	 * 
	 * @return
	 */
	public int getLength() {
		return body.size();
	}

	/**
	 * 让蛇开始运动<BR>
	 * 开启一个新的线程
	 */
	public void begin() {
		new Thread(new SnakeDriver()).start();
	}

	/**
	 * 让蛇复活, 并开始运动<BR>
	 * 将调用 begin() 方法
	 */
	public void reNew() {
		init();
		begin();
	}

	/**
	 * 初始化蛇的信息<BR>
	 * 长度, 位置, 方向, 速度, 生命和暂停状态
	 */
	public void init() {
		body.clear();
		/* 初始化位置在中间 */
		int x = Global.WIDTH / 2 - Global.INIT_LENGTH / 2;
		int y = Global.HEIGHT / 2;
		for (int i = 0; i < Global.INIT_LENGTH; i++)
			this.body.addFirst(new Point(x++, y));
		/* 设置默认方向为向右 */
		oldDirection = newDirection = RIGHT;
		/* 初始化速度 */
		speed = Global.SPEED;
		/* 初始化生命和暂停状态 */
		live = true;
		pause = false;
	}

	/**
	 * 是否吃到自己的身体<BR>
	 * 
	 * @return 蛇头的坐标是否和自己的身体的某一个坐标重合
	 */
	public boolean isEatBody() {
		/* 要把蛇头排除, body.get(0) 是蛇头 */
		for (int i = 1; i < body.size(); i++)
			if (getHead().equals(body.get(i)))
				return true;
		return false;
	}

	/**
	 * 画自己<BR>
	 * 将调用 drawHead(Graphics, int, int, int, int) 方法 和 drawBody(Graphics, int,
	 * int, int, int) 方法
	 * 
	 * @param g
	 */
	public void drawMe(Graphics g) {
		for (Point p : body) {
			/* 画蛇身体 */
			g.setColor(bodyColor);
			drawBody(g, p.x * Global.CELL_WIDTH, p.y * Global.CELL_HEIGHT,
					Global.CELL_WIDTH, Global.CELL_HEIGHT);
		}
		/* 画蛇头 */
		g.setColor(headColor);
		drawHead(g, getHead().x * Global.CELL_WIDTH, getHead().y
				* Global.CELL_HEIGHT, Global.CELL_WIDTH, Global.CELL_HEIGHT);
	}

	/**
	 * 画蛇头, 可以覆盖这个方法改变蛇头的显示
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
	public void drawHead(Graphics g, int x, int y, int width, int height) {
		g.fill3DRect(x, y, width, height, true);
	}

	/**
	 * 画蛇的一节身体, 可以覆盖这个方法改变蛇的身体节点的显示
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
	public void drawBody(Graphics g, int x, int y, int width, int height) {
		g.fill3DRect(x, y, width, height, true);
	}

	/**
	 * 得到蛇头的颜色
	 * 
	 * @return
	 */
	public Color getHeadColor() {
		return headColor;
	}

	/**
	 * 设置蛇头的颜色
	 * 
	 * @param headColor
	 */
	public void setHeadColor(Color headColor) {
		this.headColor = headColor;
	}

	/**
	 * 得到蛇身体的颜色
	 * 
	 * @return
	 */
	public Color getBodyColor() {
		return bodyColor;
	}

	/**
	 * 设置蛇身体的颜色
	 * 
	 * @param bodyColor
	 */
	public void setBodyColor(Color bodyColor) {
		this.bodyColor = bodyColor;
	}

	/**
	 * 添加监听器
	 * 
	 * @param l
	 */
	public synchronized void addSnakeListener(SnakeListener l) {
		if (l == null)
			return;
		this.listeners.add(l);
	}

	/**
	 * 移除监听器
	 * 
	 * @param l
	 */
	public synchronized void removeSnakeListener(SnakeListener l) {
		if (l == null)
			return;
		this.listeners.remove(l);
	}

	/**
	 * 加速, 幅度为 Global 中设置的 SPEED_STEP <BR>
	 * 在有效的速度范围之内(增加后速度大于 0毫秒/格)
	 */
	public void speedUp() {
		if (speed > Global.SPEED_STEP)
			speed -= Global.SPEED_STEP;
	}

	/**
	 * 减速, 幅度为 Global 中设置的 SPEED_STEP
	 */
	public void speedDown() {
		speed += Global.SPEED_STEP;
	}

	/**
	 * 得到蛇的移动速度
	 * 
	 * @return
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * 设置蛇的移动速度
	 * 
	 * @param speed
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * 蛇是否死掉了
	 * 
	 * @return
	 */
	public boolean isLive() {
		return live;
	}

	/**
	 * 设置蛇是否死掉
	 * 
	 * @param live
	 */
	public void setLive(boolean live) {
		this.live = live;
	}

	/**
	 * 设置蛇死掉
	 */
	public void dead() {
		this.live = false;
	}

	/**
	 * 是否是暂停状态
	 * 
	 * @return
	 */
	public boolean isPause() {
		return pause;
	}

	/**
	 * 设置暂停状态
	 * 
	 * @param pause
	 */
	public void setPause(boolean pause) {
		this.pause = pause;
	}

	/**
	 * 更改暂停状态<BR>
	 * 若是暂停状态, 则继续移动<BR>
	 * 若正在移动, 则暂停
	 */
	public void changePause() {
		pause = !pause;
	}

}