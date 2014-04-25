package cn.imcore.snake;

import java.util.LinkedList;
import java.util.Random;

public class Food {
	LinkedList<Node> f = new LinkedList();
	
	public Food(LinkedList<Node> snake) {
		f.clear();//清空食物
		Random r = new Random();
		while(true) {
			int x = r.nextInt(10) + 1;
			int y = r.nextInt(20) + 1;
			Node n = new Node(x, y);
			
			if(snake.contains(n)){//如果食物和蛇身重了，要重新生成食物
				//继续重新生成食物
			} else {//蛇身与食物没有重，就退出循环
				f.add(n);
				break;
			}
		}
	}
}
