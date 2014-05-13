package sonyi.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import sonyi.listener.SnakeListener;
import sonyi.util.Global;

public class Snake {
	public static final int UP = -1;
	public static final int DOWN = 1;
	public static final int LEFT = 2;
	public static final int RIGHT = -2;
	
	private int oldDirection,newDirection;//控制蛇方法
	private Point oldTail;//蛇尾
	private boolean life;//蛇生命值
	public LinkedList<Point> body = new LinkedList<Point>();//蛇身容器
	private Set<SnakeListener> listeners = new HashSet<SnakeListener>();//蛇身监听器容器
	
	public Snake(){//初始化蛇身
		init();
	}
	
	public void init(){//初始化内容
		int x = Global.WIDTH/2;
		int y = Global.HEIGHT/2;
		for(int i = 0; i < 3; i++){//3个长度的蛇身
			body.addLast(new Point(x,y));
			//Ground.rocks[x][y] = 1;
			x--;
		}
		oldDirection = newDirection = RIGHT;//初始化向右
		life = true;//生命为活着
	}
	
	public void die(){//游戏结束
		life = false;
	}
	
	public void move(){//蛇的移动
		System.out.println("snake's move");
		//用新获取的方向与旧方向比较，判断是否是相反反向，如果不是进行赋值
		if(!(oldDirection + newDirection == 0)){
			oldDirection = newDirection;
		}
		
		//1、先去尾
		oldTail = body.removeLast();//去尾，并记录尾巴位置
		//Ground.rocks[oldTail.x][oldTail.y] = 0;
		
		//2、再加头
		int x = body.getFirst().x;
		int y = body.getFirst().y;
		switch (oldDirection) {
			case UP:
				y--;
				if(y < 0){//穿过边界
					y = Global.HEIGHT -1;
				}
				break;
			case DOWN:
				y++;
				if(y > Global.HEIGHT){
					y = 0;
				}
				break;
			case LEFT:
				x--;
				if(x < 0){
					x = Global.WIDTH -1;
				}
				break;
			case RIGHT:
				x++;
				if(x > Global.WIDTH){
					x = 0;
				}
				break;
			default:
				break;
		}
		Point newHead = new Point(x,y);//得到新蛇头的位置
		//Ground.rocks[x][y] = 1;
		body.addFirst(newHead);//添加新蛇头
	}
	
	//新方向接收键盘的控制
	public void changeDirection(int direction){
		System.out.println("sanke's changeDirection");
		newDirection = direction;
	}
	
	//蛇吃食物
	public void eatFood(){
		System.out.println("sanke's eatFood");
		body.addLast(oldTail);//把原来的尾巴加上，想当于蛇变长一格
	}
	
	//判断是否吃到身体
	public boolean isEatBody(){
		System.out.println("sanke's isEatBody");
		for(int i = 1; i < body.size(); i++){
			if(body.get(i).equals(this.getHead())){
				return true;
			}
		}
		return false;
	}
	
	//显示蛇身
	public void drawMe(Graphics g){
		System.out.println("sanke's drawMe");
		g.setColor(Color.blue);
		for(Point p : body){
			g.fill3DRect(p.x*Global.CELL_SIZE, p.y*Global.CELL_SIZE,
					Global.CELL_SIZE, Global.CELL_SIZE, true);
		}
	}
	
	//获取蛇头坐标
	public Point getHead(){
		return body.getFirst();
	}
	
	//蛇自动向前走
	private class SnakeDriver implements Runnable{
		public void run() {
			while(life){
				move();
				//蛇每移动一下都要判断各个监听器
				for(SnakeListener l : listeners){
					l.snakeMoved(Snake.this);
				}
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}	
	}
	
	//开始游戏
	public void start(){
		new Thread(new SnakeDriver()).start();
	}
	
	
	//接收一个监听器，并加入到集合中
	public void addSnakeListener(SnakeListener l){
		if(l != null){
			this.listeners.add(l);
		}
	}
}
