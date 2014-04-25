package cn.imcore.snake;

import java.util.LinkedList;
import java.util.Scanner;

public class TestSnake {
	//设置游戏界面宽度和高度
	private static int row = 16;
	private static int col = 40;
	public static int getrow(){
		return row;
	}
	public static int getcol(){
		return col;
	}
	
	//声明食物和蛇对象
	private static LinkedList<Point> food = null;
	private static LinkedList<Point> snake = null;
	
	//主函数
	public static void main(String[] args) {
		startSnakeGame();
	}
	
	//启动贪吃蛇游戏
	public static void startSnakeGame(){
		snake = new Snake().s;//初始化蛇
		prodeuceFood();//初始化食物
		
		init();//初始化载入控制台界面
		while(true){//键盘输入控制，开始游戏
			char ch = control();//获取控制按钮，判断并返回操作结果
			if(!(ch == 'A' || ch == 'W' || ch == 'D' || ch == 'S')){
				continue;
			}
			else {
				move(ch);//移动一格蛇，并判断是否吃到食物，返回新的游戏界面
				//判断移动后，蛇头是否碰壁或碰到自身，是结束游戏还是继续游戏
				if(deadOrContinue())
					break;
			}
		}
		
	}
	
	//键盘输入控制键
	@SuppressWarnings("resource")
	public static char control(){
		Scanner scanner = new Scanner(System.in);
		String string = scanner.next().toUpperCase();
		return string.charAt(0);
	}
	
	//移动蛇并做判断
	public static void move(char m) {
		Point snakeHead = snake.getLast();//获取链表集合内最后对象作为蛇头，，X代表行，Y代表列
		switch(m) {
			case 'A'://向左
				if(snake.get(snake.size()-2).getY() == (snake.getLast().getY()-1))//防止蛇倒退走
					break;
				snake.addLast(new Point(snakeHead.getX(),snakeHead.getY()-1));//蛇头往前走，加一格
				eatOrNot();//判断是否吃到，如果吃到，重新生成食物，蛇末尾不移除，如果没有吃到，移除蛇末
				break;
			case 'D'://向右
				if(snake.get(snake.size()-2).getY() == (snake.getLast().getY()+1))
						break;
				snake.addLast(new Point(snakeHead.getX(),snakeHead.getY()+1));
				eatOrNot();
				break;
			case 'W'://向上		
				if(snake.get(snake.size()-2).getX() == (snake.getLast().getX()-1))
					break;
				snake.addLast(new Point(snakeHead.getX()-1,snakeHead.getY()));
				eatOrNot();
				break;
			case 'S'://向下
				if(snake.get(snake.size()-2).getX() == (snake.getLast().getX()+1))
					break;
				snake.addLast(new Point(snakeHead.getX()+1,snakeHead.getY()));
				eatOrNot();
				break;
			default:
				break;
		}
		init();//形成新的游戏界面
	}
	
	//判断是否吃到食物
	public static void eatOrNot(){//判断是否吃到食物，
		if(snake.containsAll(food)){
			prodeuceFood();//产生新食物
		}else {
			snake.pop();//去除蛇尾	
		}
	}
	
	//产生新食物
	public static void prodeuceFood(){
		food = new Food().f;
		while (true) {//判断随机生成的食物是否与蛇重叠，如果重叠，重新生成
			if(snake.containsAll(food))
				food = new Food().f;
			else 
				break;			
		}
	}
	
	//判断是否撞墙或者撞本身，如果是，游戏结束
	public static boolean deadOrContinue(){
		//判断是否撞墙
		if(snake.getLast().getX() == 0 || snake.getLast().getX() == (row-1)
				|| snake.getLast().getY() == 0 || snake.getLast().getY() == (col-1)){
			System.out.println("游戏结束");
			return true;
		}
		//判断是否撞本身：方式一：利用集合角标判断
		if(snake.indexOf(snake.getLast()) != snake.size()-1){
			System.out.println("游戏结束");
			return true;
		}		
		//判断是否撞本身：方式二：利用循环判断值
		/*
		for(int i =0; i < snake.size()-1; i++){//撞本身
			if(snake.getLast().equals(snake.get(i))){
				System.out.println("游戏结束");
				return true;
			}
		}
		*/
		return false;
	}
	
	//显示游戏界面
	public static void init() {
		System.out.println("食物：" + food);//打印食物坐标
		System.out.println("蛇身：" + snake);//打印蛇坐标
		//遍历游戏界面，并打印相应的值
		for(int m=0; m<row; m++) {
			for(int n=0; n<col; n++) {
				Point point = new Point(m,n);
				if(m==0 || m==row-1) {
					System.out.print("-");
				} else if(n==0 || n==col-1) {
					System.out.print("|");
				} else if(food.contains(point)) {
					System.out.print("@");
				} else if(snake.getLast().equals(point)){
					System.out.print("S");
				}else if(snake.contains(point)) {
					System.out.print("#");
				}else{
					System.out.print(" ");
				}
			}
			System.out.println();//换行
		}
	}
}
