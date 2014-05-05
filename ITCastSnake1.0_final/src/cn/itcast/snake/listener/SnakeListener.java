package cn.itcast.snake.listener;

/**
 * 
 * 蛇的监听器
 * 
 * @version 1.0, 01/01/08
 * 
 * @author 汤阳光
 * 
 */
public interface SnakeListener {
	/**
	 * 蛇移动事件
	 */
	void snakeMoved();

	/**
	 * 蛇吃到食物事件
	 */
	void snakeEatFood();
}
