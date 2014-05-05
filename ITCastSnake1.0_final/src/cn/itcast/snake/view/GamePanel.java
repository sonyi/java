package cn.itcast.snake.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import cn.itcast.snake.entities.Food;
import cn.itcast.snake.entities.Ground;
import cn.itcast.snake.entities.Snake;
import cn.itcast.snake.util.Global;

/**
 * 游戏的显示界面<BR>
 * 可以用 setBackgroundColor() 设置游戏的背景色
 * 
 * @version 1.0, 01/01/08
 * 
 * @author 汤阳光
 * 
 */
public class GamePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Image oimg;

	private Graphics og;

	public static final Color DEFAULT_BACKGROUND_COLOR = new Color(0xcfcfcf);
	/**
	 * 背景颜色
	 */
	private Color backgroundColor = DEFAULT_BACKGROUND_COLOR;

	public GamePanel() {
		/* 设置大小和布局 */
		this.setSize(Global.WIDTH * Global.CELL_WIDTH, Global.HEIGHT
				* Global.CELL_HEIGHT);
		this.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		this.setFocusable(true);
	}

	/**
	 * 重新显示 Ground, Shape
	 * 
	 * @param ground
	 * @param snake
	 */
	public synchronized void redisplay(Ground ground, Snake snake, Food food) {

		/* 重新显示 */
		if (og == null) {
			oimg = createImage(getSize().width, getSize().height);
			if (oimg != null)
				og = oimg.getGraphics();
		}
		if (og != null) {
			og.setColor(backgroundColor);
			og.fillRect(0, 0, Global.WIDTH * Global.CELL_WIDTH, Global.HEIGHT
					* Global.CELL_HEIGHT);
			if (ground != null)
				ground.drawMe(og);
			snake.drawMe(og);
			if (food != null)
				food.drawMe(og);
			this.paint(this.getGraphics());
		}
	}


	public void paint(Graphics g) {
		g.drawImage(oimg, 0, 0, this);
	}

	/**
	 * 得到当前的背景颜色
	 * 
	 * @return
	 */
	public Color getBackgroundColor() {
		return backgroundColor;
	}

	/**
	 * 设置当前的背景颜色
	 * 
	 * @param backgroundColor
	 */
	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

}
