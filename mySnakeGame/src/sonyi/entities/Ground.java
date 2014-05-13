package sonyi.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import sonyi.util.Global;

public class Ground {
	public static int[][] rocks = new int[Global.WIDTH][Global.HEIGHT];
	public Ground() {//初始化石头
		for(int x = 0; x < Global.WIDTH; x++){//1代表石头，0代表没有东西
			for(int y = 0; y < Global.HEIGHT; y++){
				rocks[x][0] = 1;
				rocks[x][Global.HEIGHT - 1] = 1;	
			}
		}
	}
	
	public boolean isSnakeEatRock(Snake snake){//判断蛇是否吃到石头
		System.out.println("Ground's isSnakeEatRock");
		for(int x = 0; x < Global.WIDTH; x++){
			for(int y = 0; y < Global.HEIGHT; y++){
				if(rocks[x][y] == 1 &&
						x == snake.getHead().x && y == snake.getHead().y){
					return true;
				}
			}
		}
		return false;
	}
	
	public Point getPoint(){	//产生新坐标	
		Random random = new Random();
		int x = 0, y = 0;	
		do{		
			x = random.nextInt(Global.WIDTH);
			y = random.nextInt(Global.HEIGHT);	
		}while(rocks[x][y] == 1);
		return new Point(x,y);
	}

	
	public void drawMe(Graphics g){//在画板上画出石头地图
		System.out.println("Ground's drawMe");
		g.setColor(Color.black);
		for(int x = 0; x < Global.WIDTH; x++){
			for(int y = 0; y < Global.HEIGHT; y++){
				if(rocks[x][y] == 1){
					g.fill3DRect(x * Global.CELL_SIZE, y * Global.CELL_SIZE, 
							Global.CELL_SIZE,Global.CELL_SIZE,true);
					
				}
			}
		}
	}
	
	
}
