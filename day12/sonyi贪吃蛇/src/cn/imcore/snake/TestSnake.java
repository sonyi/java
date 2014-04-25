package cn.imcore.snake;

import java.util.LinkedList;
import java.util.Scanner;

public class TestSnake {
	//������Ϸ�����Ⱥ͸߶�
	private static int row = 16;
	private static int col = 40;
	public static int getrow(){
		return row;
	}
	public static int getcol(){
		return col;
	}
	
	//����ʳ����߶���
	private static LinkedList<Point> food = null;
	private static LinkedList<Point> snake = null;
	
	//������
	public static void main(String[] args) {
		startSnakeGame();
	}
	
	//����̰������Ϸ
	public static void startSnakeGame(){
		snake = new Snake().s;//��ʼ����
		prodeuceFood();//��ʼ��ʳ��
		
		init();//��ʼ���������̨����
		while(true){//����������ƣ���ʼ��Ϸ
			char ch = control();//��ȡ���ư�ť���жϲ����ز������
			if(!(ch == 'A' || ch == 'W' || ch == 'D' || ch == 'S')){
				continue;
			}
			else {
				move(ch);//�ƶ�һ���ߣ����ж��Ƿ�Ե�ʳ������µ���Ϸ����
				//�ж��ƶ�����ͷ�Ƿ����ڻ����������ǽ�����Ϸ���Ǽ�����Ϸ
				if(deadOrContinue())
					break;
			}
		}
		
	}
	
	//����������Ƽ�
	@SuppressWarnings("resource")
	public static char control(){
		Scanner scanner = new Scanner(System.in);
		String string = scanner.next().toUpperCase();
		return string.charAt(0);
	}
	
	//�ƶ��߲����ж�
	public static void move(char m) {
		Point snakeHead = snake.getLast();//��ȡ����������������Ϊ��ͷ����X�����У�Y������
		switch(m) {
			case 'A'://����
				if(snake.get(snake.size()-2).getY() == (snake.getLast().getY()-1))//��ֹ�ߵ�����
					break;
				snake.addLast(new Point(snakeHead.getX(),snakeHead.getY()-1));//��ͷ��ǰ�ߣ���һ��
				eatOrNot();//�ж��Ƿ�Ե�������Ե�����������ʳ���ĩβ���Ƴ������û�гԵ����Ƴ���ĩ
				break;
			case 'D'://����
				if(snake.get(snake.size()-2).getY() == (snake.getLast().getY()+1))
						break;
				snake.addLast(new Point(snakeHead.getX(),snakeHead.getY()+1));
				eatOrNot();
				break;
			case 'W'://����		
				if(snake.get(snake.size()-2).getX() == (snake.getLast().getX()-1))
					break;
				snake.addLast(new Point(snakeHead.getX()-1,snakeHead.getY()));
				eatOrNot();
				break;
			case 'S'://����
				if(snake.get(snake.size()-2).getX() == (snake.getLast().getX()+1))
					break;
				snake.addLast(new Point(snakeHead.getX()+1,snakeHead.getY()));
				eatOrNot();
				break;
			default:
				break;
		}
		init();//�γ��µ���Ϸ����
	}
	
	//�ж��Ƿ�Ե�ʳ��
	public static void eatOrNot(){//�ж��Ƿ�Ե�ʳ�
		if(snake.containsAll(food)){
			prodeuceFood();//������ʳ��
		}else {
			snake.pop();//ȥ����β	
		}
	}
	
	//������ʳ��
	public static void prodeuceFood(){
		food = new Food().f;
		while (true) {//�ж�������ɵ�ʳ���Ƿ������ص�������ص�����������
			if(snake.containsAll(food))
				food = new Food().f;
			else 
				break;			
		}
	}
	
	//�ж��Ƿ�ײǽ����ײ��������ǣ���Ϸ����
	public static boolean deadOrContinue(){
		//�ж��Ƿ�ײǽ
		if(snake.getLast().getX() == 0 || snake.getLast().getX() == (row-1)
				|| snake.getLast().getY() == 0 || snake.getLast().getY() == (col-1)){
			System.out.println("��Ϸ����");
			return true;
		}
		//�ж��Ƿ�ײ������ʽһ�����ü��ϽǱ��ж�
		if(snake.indexOf(snake.getLast()) != snake.size()-1){
			System.out.println("��Ϸ����");
			return true;
		}		
		//�ж��Ƿ�ײ������ʽ��������ѭ���ж�ֵ
		/*
		for(int i =0; i < snake.size()-1; i++){//ײ����
			if(snake.getLast().equals(snake.get(i))){
				System.out.println("��Ϸ����");
				return true;
			}
		}
		*/
		return false;
	}
	
	//��ʾ��Ϸ����
	public static void init() {
		System.out.println("ʳ�" + food);//��ӡʳ������
		System.out.println("����" + snake);//��ӡ������
		//������Ϸ���棬����ӡ��Ӧ��ֵ
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
			System.out.println();//����
		}
	}
}
