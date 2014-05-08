package sonyi.game;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import sonyi.controller.Controller;
import sonyi.entities.Food;
import sonyi.entities.Ground;
import sonyi.entities.Snake;
import sonyi.util.Global;
import sonyi.view.GamePanel;

public class Game {
	public static void main(String[] args){
		Snake snake = new Snake();
		Food food = new Food();
		Ground ground = new Ground();
		GamePanel gamePanel = new GamePanel();
		Controller controller = new Controller(snake, food, ground, gamePanel);
		
		javax.swing.JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gamePanel.setSize(Global.WIDTH*Global.CELL_SIZE,
				Global.HEIGHT*Global.CELL_SIZE);
		frame.setSize(Global.WIDTH*Global.CELL_SIZE + 10, 
				Global.HEIGHT*Global.CELL_SIZE + 35);
		frame.add(gamePanel,BorderLayout.CENTER);
		//gamePanel.addKeyListener(controller);
		snake.addSnakeListener(controller);
		
		frame.addKeyListener(controller);//¿ØÖÆÉß·½Ïò
		
		frame.setVisible(true);
		controller.newGame();
	}
}
