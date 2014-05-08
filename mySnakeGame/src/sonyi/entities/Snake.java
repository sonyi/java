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
	
	private int oldDirection,newDirection;
	private Point oldTail;
	
	public LinkedList<Point> body = new LinkedList<Point>();
	private Set<SnakeListener> listeners = new HashSet<SnakeListener>();
	
	private boolean life;
	public Snake(){
		init();
	}
	
	public void init(){
		int x = Global.WIDTH/2;
		int y = Global.HEIGHT/2;
		
		for(int i = 0; i < 3; i++){
			body.addLast(new Point(x,y));
			//Ground.rocks[x][y] = 1;
			x--;
		}
		oldDirection = newDirection = RIGHT;
		life = true;
	}
	
	//��Ϸ����
	public void die(){
		life = false;
	}
	
	public void move(){
		System.out.println("snake's move");
		//���»�ȡ�ķ�����ɷ���Ƚϣ��ж��Ƿ����෴����������ǽ��и�ֵ
		if(!(oldDirection + newDirection == 0)){
			oldDirection = newDirection;
		}
		
		//1��ȥβ
		oldTail = body.removeLast();
		//Ground.rocks[oldTail.x][oldTail.y] = 0;
		
		int x = body.getFirst().x;
		int y = body.getFirst().y;
		switch (oldDirection) {
			case UP:
				y--;
				if(y < 0){//�����߽�
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
		Point newHead = new Point(x,y);
		//Ground.rocks[x][y] = 1;
		
		//2����ͷ
		body.addFirst(newHead);
	}
	
	//�·�����ռ��̵Ŀ���
	public void changeDirection(int direction){
		System.out.println("sanke's changeDirection");
		newDirection = direction;
	}
	
	//�߳�ʳ��
	public void eatFood(){
		System.out.println("sanke's eatFood");
		body.addLast(oldTail);//��ԭ����β�ͼ���
	}
	
	//�ж��Ƿ�Ե�����
	public boolean isEatBody(){
		System.out.println("sanke's isEatBody");
		for(int i = 1; i < body.size(); i++){
			if(body.get(i).equals(this.getHead())){
				return true;
			}
		}
		return false;
	}
	
	//��ʾ����
	public void drawMe(Graphics g){
		System.out.println("sanke's drawMe");
		g.setColor(Color.blue);
		for(Point p : body){
			g.fill3DRect(p.x*Global.CELL_SIZE, p.y*Global.CELL_SIZE,
					Global.CELL_SIZE, Global.CELL_SIZE, true);
		}
	}
	
	//��ȡ��ͷ����
	public Point getHead(){
		return body.getFirst();
	}
	
	//���Զ���ǰ��
	private class SnakeDriver implements Runnable{
		public void run() {
			while(life){
				move();
				//��ÿ�ƶ�һ�¶�Ҫ�жϸ���������
				for(SnakeListener l : listeners){
					l.snakeMoved(Snake.this);
				}
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}	
	}
	
	//��ʼ��Ϸ
	public void start(){
		new Thread(new SnakeDriver()).start();
	}
	
	
	//����һ���������������뵽������
	public void addSnakeListener(SnakeListener l){
		if(l != null){
			this.listeners.add(l);
		}
	}
}
