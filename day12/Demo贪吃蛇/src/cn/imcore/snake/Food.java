package cn.imcore.snake;

import java.util.LinkedList;
import java.util.Random;

public class Food {
	LinkedList<Node> f = new LinkedList();
	
	public Food(LinkedList<Node> snake) {
		f.clear();//���ʳ��
		Random r = new Random();
		while(true) {
			int x = r.nextInt(10) + 1;
			int y = r.nextInt(20) + 1;
			Node n = new Node(x, y);
			
			if(snake.contains(n)){//���ʳ����������ˣ�Ҫ��������ʳ��
				//������������ʳ��
			} else {//������ʳ��û���أ����˳�ѭ��
				f.add(n);
				break;
			}
		}
	}
}
