package cn.itcast.snake.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * 工具类<BR>
 * <BR>
 * 此类中存放了其他类中用到的一些常量<BR>
 * 并且支持配置文件<BR>
 * 配置文件的路径为游戏运行的目录, 文件名为 snake.ini<BR>
 * <BR>
 * 配置文件的写法请参见字段的注释<BR>
 * <BR>
 * 配置文件中设置项可以只写需要配置的, 没有写的设置项默认为缺省值<BR>
 * 各配置项的缺省值请参见字段的注释<BR>
 * <BR>
 * 每个配置项都有设置值范围, 超出范围(无效)的设置值将不起作用<BR>
 * 设置值的范围请参见字段的注释<BR>
 * 
 * @version 1.0, 01/01/08
 * 
 * @author 汤阳光
 * 
 */
public class Global {

	private static Properties properties = new Properties();

	/**
	 * 配置文件的路径(默认为当前目录下的 snake.ini文件)
	 */
	private static String CONFIG_FILE = "snake.ini";

	/**
	 * 一个格子的宽度, 单位:像素 <BR>
	 * 对应的配置文件中的关键字为: cell_width, 或用 cell_size指定<BR>
	 * 范围1 至 100<BR>
	 * 缺省值为 23
	 */
	public static final int CELL_WIDTH;

	/**
	 * 一个格子的高度, 单位:像素 <BR>
	 * 对应的配置文件中的关键字为: cell_width, 或用 cell_size指定<BR>
	 * 范围1 至 100<BR>
	 * 缺省值为 23
	 */
	public static final int CELL_HEIGHT;
	/**
	 * 用格子表示的宽度, (宽度为多少个格子) 单位:格 <BR>
	 * 对应的配置文件中的关键字为: width<BR>
	 * 范围10 至 80<BR>
	 * 缺省值为 30
	 */
	public static final int WIDTH;

	/**
	 * 用格子表示的高度, (高度为多少个格子), 单位:格)<BR>
	 * 对应的配置文件中的关键字为: height<BR>
	 * 范围10 至 60<BR>
	 * 缺省值为20
	 */
	public static final int HEIGHT;

	/**
	 * 显示的像素宽度 (格子宽度度 * 每一格的宽度)
	 */
	public static final int CANVAS_WIDTH;
	/**
	 * 显示的像素高度 (格子高度 * 每一格的高度)
	 */
	public static final int CANVAS_HEIGHT;

	/**
	 * 蛇的初始长度, 对应的配置文件中的关键字为: init_length<BR>
	 * 范围2 至 最大宽度<BR>
	 * (单位:格) 缺省值为 2
	 */
	public static final int INIT_LENGTH;

	/**
	 * 蛇的初始速度 (单位: 毫秒/格)<BR>
	 * 对应的配置文件中的关键字为: speed<BR>
	 * 范围10 至 无限大<BR>
	 * 缺省值为 200
	 */
	public static final int SPEED;

	/**
	 * 蛇每次加速或减速的幅度 (单位: 毫秒/格)<BR>
	 * 对应的配置文件的关键字为: speed_step<BR>
	 * 范围1 至 无限大<BR>
	 * 缺省值为 25
	 */
	public static final int SPEED_STEP;

	public static final String TITLE_LABEL_TEXT;

	public static final String INFO_LABEL_TEXT;

	/**
	 * 默认的构造器, 私有的, 不能生成这个类的实例
	 */
	private Global() {
	}

	/**
	 * 初始化常量
	 */
	static {
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(CONFIG_FILE);
			properties.load(inputStream);
		} catch (Exception e) {
			System.out.println("没有配置文件");
		} finally {
			try {
				if (inputStream != null)
					inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Integer temp = null;
		/* 没有设置或设置的无效时要有一个默认值 */
		WIDTH = (temp = getIntValue("width")) != null && temp <= 80 
				&& temp >= 10 ? temp : 35;
		HEIGHT = (temp = getIntValue("height")) != null && temp <= 60
				&& temp >= 10 ? temp : 20;
		INIT_LENGTH = (temp = getIntValue("init_length")) != null && temp > 1
				&& temp < WIDTH ? temp : 2;
		SPEED = (temp = getIntValue("speed")) != null && temp >= 10 ? temp
				: 200;
		SPEED_STEP = (temp = getIntValue("speed_step")) != null && temp >= 1 ? temp
				: 25;

		int defaultCellSize = (temp = getIntValue("cell_size")) != null
				&& temp > 0 && temp <= 100 ? temp : 20;
		CELL_WIDTH = (temp = getIntValue("cell_width")) != null && temp > 0
				&& temp <= 100 ? temp : defaultCellSize;
		CELL_HEIGHT = (temp = getIntValue("cell_height")) != null && temp > 0
				&& temp <= 100 ? temp : defaultCellSize;

		CANVAS_WIDTH = WIDTH * CELL_WIDTH;
		CANVAS_HEIGHT = HEIGHT * CELL_HEIGHT;

		String tempStr = null;
		TITLE_LABEL_TEXT = (tempStr = getValue("title")) == null ? "说明："
				: tempStr;
		INFO_LABEL_TEXT = (tempStr = getValue("info")) == null ? "方向键控制方向, 回车键暂停/继续\nPAGE UP, PAGE DOWN 加速或减速\n\n更多请看 www.itcast.cn "
				: tempStr;
	}

	/**
	 * 要考虑多种情况<BR>
	 * 1. 没有这个key和value<BR>
	 * 2 有key 没有 value
	 */
	private static Integer getIntValue(String key) {
		if (key == null)
			throw new RuntimeException("key 不能为空");
		try {
			return new Integer(properties.getProperty(key));
		} catch (NumberFormatException e) {
			return null;
		}
	}

	private static String getValue(String key) {
		try {
			return new String(properties.getProperty(key).getBytes("iso8859-1"));
		} catch (Exception e) {
			return null;
		}
	}
}
