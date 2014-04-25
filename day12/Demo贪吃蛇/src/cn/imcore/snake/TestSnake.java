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
		snake = new Snake().s;//�ߵĳ�ʼ��
		food = new Food(snake).f;//����ʳ��
		init();//��ͼ
		
		while(true) {
			String n = input.nextLine().toUpperCase();//���ռ���¼��
			move(n.charAt(0));//���ÿ��Ʒ���ķ���
		}
//		move('A');
//		move('S');
//		move('S');
//		move('S');
//		move('S');
	}
	
	public static void move(char ch) {//���߶��� ���Ʒ���ķ���
		Node head = snake.getFirst();
		switch(ch) {
			case 'W'://���ϣ������㷨���в��䣩
				snake.addFirst(new Node(head.getX()-1, head.getY()));
				snake.removeLast();
				break;
			case 'S'://����
				snake.addFirst(new Node(head.getX()+1, head.getY()));
				snake.removeLast();
				break;
			case 'A'://����
				snake.addFirst(new Node(head.getX(), head.getY()-1));
				snake.removeLast();
				break;
			case 'D'://����
				snake.addFirst(new Node(head.getX(), head.getY()+1));
				snake.removeLast();
				break;
			default:
				break;	
		}
		
		init();//���»�ͼ
		checkSnakeIsAlive();//�ж����Ƿ�ײǽ�ķ���
		
		if(snake.containsAll(food)) {//�ж�ʳ���Ƿ��߳Ե�������Ե�����������ʳ��
			food = new Food(snake).f;
		}
	}
	
	public static void checkSnakeIsAlive() {
		Node head = snake.getFirst();
		if(head.getX()==0 || head.getX()==row-1
				|| head.getY()==0 || head.getY()==col-1) {
			System.out.println("��ײǽ���ˡ�������");
			System.exit(0);//�����˳�����
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
//				else if(snake.contains(new Node(x, y))) {//��ӡ��
//					System.out.print("#");
//				}
//				else if(food.contains(new Node(x, y))) {//ʳ��
//					System.out.print("@");
//				}
				else if(food.contains(node)) {//ʳ��
					if(snake.containsAll(food)){
						System.out.print("#");
						snake.add(node);
					} else {
						System.out.print("@");
					}
				}
				else if(snake.contains(node)) {//��ӡ��
					System.out.print("#");
				}
				
				else {
					System.out.print(" ");
				}
			}
			System.out.println();//����
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
