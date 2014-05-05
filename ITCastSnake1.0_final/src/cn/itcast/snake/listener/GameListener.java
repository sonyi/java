package cn.itcast.snake.listener;

/**
 * 
 * 游戏监听器
 * 
 * @version 1.0, 01/01/08
 * 
 * @author 汤阳光
 * 
 */
public interface GameListener {

	/**
	 * 游戏开始了
	 */
	void gameStart();

	/**
	 * 游戏结束了
	 */
	void gameOver();

	/**
	 * 游戏暂停了
	 */

	void gamePause();

	/**
	 * 游戏继续
	 */
	void gameContinue();
}
