package cn.imcore.snake;

import java.util.LinkedList;
import java.util.Random;

public class Snake {

	LinkedList<Node> s = new LinkedList();
	
	public Snake() {
		Random r = new Random();
		int x = r.nextInt(10);
		int y = r.nextInt(20);
		for(int i=1; i<=7; i++) {
			s.add(new Node(x+i,y));
		}
	}
	
}
