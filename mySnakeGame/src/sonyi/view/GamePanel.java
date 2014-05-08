package sonyi.view;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

import sonyi.entities.Food;
import sonyi.entities.Ground;
import sonyi.entities.Snake;
import sonyi.util.Global;
public class GamePanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Snake snake;
	private Food food;
	private Ground ground;
	public void display(Snake snake, Food food, Ground ground){
		System.out.println("GamePanel's display");
		this.snake = snake;
		this.food = food;
		this.ground = ground;
		this.repaint();
	}

	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		//÷ÿ–¬œ‘ æ
		g.setColor(new Color(0xcfcfcf));
		g.fillRect(0, 0, Global.WIDTH*Global.CELL_SIZE,
				Global.HEIGHT*Global.CELL_SIZE);
		if(ground != null && snake != null && food != null){
			this.ground.drawMe(g);
			this.food.drawMe(g);
			this.snake.drawMe(g);
		}
	}
}
