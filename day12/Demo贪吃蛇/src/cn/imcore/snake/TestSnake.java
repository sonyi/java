package cn.imcore.snake;

import java.util.LinkedList;
import java.util.Scanner;

public class TestSnake {
	public static int row = 20;
	public static int col = 40;
	public static LinkedList<Node> snake = null;
	public static LinkedList<Node> food = null;
	public static Scanner input = null;
	public static void main(String[] args) {
		input = new Scanner(System.in);
		snake = new Snake().s;//蛇的初始化
		food = new Food(snake).f;//生成食物
		init();//画图
		
		while(true) {
			String n = input.nextLine().toUpperCase();//接收键盘录入
			move(n.charAt(0));//调用控制方向的方法
		}
//		move('A');
//		move('S');
//		move('S');
//		move('S');
//		move('S');
	}
	
	public static void move(char ch) {//蛇走动： 控制方向的方法
		Node head = snake.getFirst();
		switch(ch) {
			case 'W'://向上（其他算法自行补充）
				snake.addFirst(new Node(head.getX()-1, head.getY()));
				snake.removeLast();
				break;
			case 'S'://向下
				snake.addFirst(new Node(head.getX()+1, head.getY()));
				snake.removeLast();
				break;
			case 'A'://向左
				snake.addFirst(new Node(head.getX(), head.getY()-1));
				snake.removeLast();
				break;
			case 'D'://向右
				snake.addFirst(new Node(head.getX(), head.getY()+1));
				snake.removeLast();
				break;
			default:
				break;	
		}
		
		init();//重新画图
		checkSnakeIsAlive();//判断蛇是否撞墙的方法
		
		if(snake.containsAll(food)) {//判断食物是否被蛇吃掉，如果吃掉就重新生成食物
			food = new Food(snake).f;
		}
	}
	
	public static void checkSnakeIsAlive() {
		Node head = snake.getFirst();
		if(head.getX()==0 || head.getX()==row-1
				|| head.getY()==0 || head.getY()==col-1) {
			System.out.println("蛇撞墙死了。。。。");
			System.exit(0);//正常退出程序
		}
		
	}
	
	public static void init() {
		System.out.println(food);
		System.out.println(snake);
		for(int x=0; x<row; x++) {
			for(int y=0; y<col; y++) {
				Node node = new Node(x, y);
				
				if(x==0 || x==row-1) {
					System.out.print("-");
				} else if(y==0 || y==col-1){
					System.out.print("|");
				}
//				else if(snake.contains(new Node(x, y))) {//打印蛇
//					System.out.print("#");
//				}
//				else if(food.contains(new Node(x, y))) {//食物
//					System.out.print("@");
//				}
				else if(food.contains(node)) {//食物
					if(snake.containsAll(food)){
						System.out.print("#");
						snake.add(node);
					} else {
						System.out.print("@");
					}
				}
				else if(snake.contains(node)) {//打印蛇
					System.out.print("#");
				}
				
				else {
					System.out.print(" ");
				}
			}
			System.out.println();//换行
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
