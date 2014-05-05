package cn.itcast.snake.controller;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JLabel;

import cn.itcast.snake.entities.Food;
import cn.itcast.snake.entities.Ground;
import cn.itcast.snake.entities.Snake;
import cn.itcast.snake.listener.GameListener;
import cn.itcast.snake.listener.SnakeListener;
import cn.itcast.snake.util.Global;
import cn.itcast.snake.view.GamePanel;

/**
 * 控制器<BR>
 * 控制Ground, Snake, Food<BR>
 * 负责游戏的逻辑<BR>
 * 处理按键事件<BR>
 * <BR>
 * 实现了SnakeListener接口, 可以处理Snake 触发的事件<BR>
 * 方法 snakeEatFood() 处理蛇吃到食物后触发的 snakeEatFood事件 但什么也没做<BR>
 * <BR>
 * 
 * @version 1.0, 01/01/08
 * 
 * @author 汤阳光
 * 
 */
public class Controller extends KeyAdapter implements SnakeListener {

	/* 地形 */
	private Ground ground;

	/* 蛇 */
	private Snake snake;

	/* 食物 */
	private Food food;

	/* 显示 */
	private GamePanel gamePanel;

	/* 提示信息 */
	private JLabel gameInfoLabel;

	private boolean playing;

	private int map;

	/* 控制器监听器 */
	private Set<GameListener> listeners = new HashSet<GameListener>();

	/**
	 * 处理按键事件<BR>
	 * 接受按键, 根据按键不同, 发出不同的指令<BR>
	 * UP: 改变蛇的移动方向为向上<BR>
	 * DOWN: 改变蛇的移动方向为向下<BR>
	 * LEFT: 改变蛇的移动方向为向左 <BR>
	 * RIGHT: 改变蛇的移动方向为向右<BR>
	 * SPACE: 暂停/继续<BR>
	 * PAGE UP: 加快蛇的移动速度<BR>
	 * PAGE DOWN: 减慢蛇的移动速度<BR>
	 * Y: 重新开始游戏
	 */
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() != KeyEvent.VK_Y && !playing)
			return;
		// TODO Auto-generated method stub
		/* 根据按键不同, 让蛇改变不同的方向 */
		switch (e.getKeyCode()) {

		/* 方向键 上 */
		case KeyEvent.VK_UP:
			if (snake.isPause()) {
				snake.changePause();
				for (GameListener l : listeners)
					l.gameContinue();
			}
			snake.changeDirection(Snake.UP);
			break;
		/* 方向键 下 */
		case KeyEvent.VK_DOWN:
			if (snake.isPause()) {
				snake.changePause();
				for (GameListener l : listeners)
					l.gameContinue();
			}
			snake.changeDirection(Snake.DOWN);
			break;
		/* 方向键 左 */
		case KeyEvent.VK_LEFT:
			if (snake.isPause()) {
				snake.changePause();
				for (GameListener l : listeners)
					l.gameContinue();
			}
			snake.changeDirection(Snake.LEFT);
			break;
		/* 方向键 右 */
		case KeyEvent.VK_RIGHT:
			if (snake.isPause()) {
				snake.changePause();
				for (GameListener l : listeners)
					l.gameContinue();
			}
			snake.changeDirection(Snake.RIGHT);
			break;
		/* 回车或空格 (暂停) */
		case KeyEvent.VK_ENTER:
		case KeyEvent.VK_SPACE:
			snake.changePause();
			/* === */
			for (GameListener l : listeners)
				if (snake.isPause())
					l.gamePause();
				else
					l.gameContinue();
			break;
		/* PAGE_UP 加速 */
		case KeyEvent.VK_PAGE_UP:
			snake.speedUp();
			break;
		/* PAGE_DOWN 减速 */
		case KeyEvent.VK_PAGE_DOWN:
			snake.speedDown();
			break;
		/* 字母键 Y (重新开始游戏) */
		case KeyEvent.VK_Y:
			if (!isPlaying())
				newGame();
			break;
		}

		/* 重新显示 */
		if (gamePanel != null)
			gamePanel.redisplay(ground, snake, food);
		/* 更新提示 */
		if (gameInfoLabel != null)
			gameInfoLabel.setText(getNewInfo());
	}

	/**
	 * 处理Snake 触发的 snakeMoved 事件<BR>
	 */
	public void snakeMoved() {

		/* 判断是否吃到食物 */
		if (food != null && food.isSnakeEatFood(snake)) {
			/* 吃到食物后, 蛇增加身体, 再重新丢一个食物 */
			snake.eatFood();
			food.setLocation(ground == null ? food.getNew() : ground
					.getFreePoint());

		}/* 如果吃到食物, 就肯定不会吃到石头 */
		else if (ground != null && ground.isSnakeEatRock(snake)) {
			/* 如果吃到的是石头, 或吃到自己的身体, 就让蛇死掉 */
			stopGame();
		}
		if (snake.isEatBody())
			stopGame();
		if (gamePanel != null)
			gamePanel.redisplay(ground, snake, food);
		/* 更新提示 */
		if (gameInfoLabel != null)
			gameInfoLabel.setText(getNewInfo());
	}

	/**
	 * 开始一个新游戏
	 */
	public void newGame() {

		if (ground != null) {
			switch (map) {
			case 2:
				ground.clear();
				ground.generateRocks2();
				break;
			default:
				ground.init();
				break;
			}
		}
		playing = true;

		snake.reNew();
		for (GameListener l : listeners)
			l.gameStart();
	}

	/**
	 * 结束游戏
	 */
	public void stopGame() {
		if (playing) {
			playing = false;
			snake.dead();
			for (GameListener l : listeners)
				l.gameOver();
		}
	}

	/**
	 * 暂停游戏
	 */
	public void pauseGame() {
		snake.setPause(true);
		for (GameListener l : listeners)
			l.gamePause();
	}

	/**
	 * 继续游戏
	 */
	public void continueGame() {
		snake.setPause(false);
		for (GameListener l : listeners)
			l.gameContinue();
	}

	/**
	 * 接受Snake,Food,Ground 的构造器<BR>
	 * 
	 * @param snake
	 * @param food
	 * @param ground
	 */
	public Controller(Snake snake, Food food, Ground ground, GamePanel gamePanel) {
		this.snake = snake;
		this.food = food;
		this.ground = ground;
		this.gamePanel = gamePanel;
		/* 先丢一个食物 */
		if (ground != null && food != null)
			food.setLocation(ground.getFreePoint());
		/* 注册监听器 */
		this.snake.addSnakeListener(this);
	}

	/**
	 * 多接受一个显示提示信息的JLabel
	 * 
	 * @param snake
	 * @param food
	 * @param ground
	 * @param gameInfoLabel
	 */
	public Controller(Snake snake, Food food, Ground ground,
			GamePanel gamePanel, JLabel gameInfoLabel) {

		this(snake, food, ground, gamePanel);
		this.setGameInfoLabel(gameInfoLabel);

		if (gameInfoLabel != null)
			gameInfoLabel.setText(getNewInfo());
	}

	/**
	 * 得到最新的提示信息
	 * 
	 * @return 蛇的最新信息
	 */
	public String getNewInfo() {
		if (!snake.isLive())
			return " ";// " 提示: 按 Y 开始新游戏";
		else
			return new StringBuffer().append("提示: ").append("速度 ").append(
					snake.getSpeed()).toString()
					+ " 毫秒/格";
	}

	/**
	 * 添加监听器
	 * 
	 * @param l
	 */
	public synchronized void addGameListener(GameListener l) {
		if (l != null)
			this.listeners.add(l);
	}

	/**
	 * 移除监听器
	 * 
	 * @param l
	 */
	public synchronized void removeGameListener(GameListener l) {
		if (l != null)
			this.listeners.remove(l);
	}

	/**
	 * 得到蛇的引用
	 * 
	 * @return
	 */
	public Snake getSnake() {
		return this.snake;
	}

	/**
	 * 得到食物的引用
	 * 
	 * @return
	 */
	public Food getFood() {
		return this.food;
	}

	/**
	 * 得到地形的引用
	 * 
	 * @return
	 */
	public Ground getGround() {
		return this.ground;
	}

	/**
	 * 处理蛇吃到食物后触发的 snakeEatFood事件, 但什么也没做<BR>
	 * 可以覆盖这个方法增加功能, 例如, 增加记分功能
	 */
	public void snakeEatFood() {
		// TODO Auto-generated method stub
		System.out.println("吃到食物!");
	}

	public GamePanel getGamePanel() {
		return gamePanel;
	}

	/**
	 * 设置GamePanel
	 * 
	 * @param gamePanel
	 */
	public void setGamePanel(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	public JLabel getGameInfoLabel() {
		return gameInfoLabel;
	}

	public void setGameInfoLabel(JLabel gameInfoLabel) {
		this.gameInfoLabel = gameInfoLabel;
		this.gameInfoLabel.setSize(Global.WIDTH * Global.CELL_WIDTH, 20);
		this.gameInfoLabel.setFont(new Font("宋体", Font.PLAIN, 12));
		gameInfoLabel.setText(this.getNewInfo());
	}

	public void setGround(Ground ground) {
		this.ground = ground;
	}

	public void setSnake(Snake snake) {
		this.snake = snake;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public int getMap() {
		return map;
	}

	public void setMap(int map) {
		this.map = map;
	}

	public boolean isPlaying() {
		return playing;
	}

	public void setPlaying(boolean playing) {
		this.playing = playing;
	}

	public boolean isPausingGame() {
		// TODO Auto-generated method stub
		return snake.isPause();
	}

}
