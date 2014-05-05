package cn.itcast.snake.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * ������<BR>
 * <BR>
 * �����д�������������õ���һЩ����<BR>
 * ����֧�������ļ�<BR>
 * �����ļ���·��Ϊ��Ϸ���е�Ŀ¼, �ļ���Ϊ snake.ini<BR>
 * <BR>
 * �����ļ���д����μ��ֶε�ע��<BR>
 * <BR>
 * �����ļ������������ֻд��Ҫ���õ�, û��д��������Ĭ��Ϊȱʡֵ<BR>
 * ���������ȱʡֵ��μ��ֶε�ע��<BR>
 * <BR>
 * ÿ�������������ֵ��Χ, ������Χ(��Ч)������ֵ����������<BR>
 * ����ֵ�ķ�Χ��μ��ֶε�ע��<BR>
 * 
 * @version 1.0, 01/01/08
 * 
 * @author ������
 * 
 */
public class Global {

	private static Properties properties = new Properties();

	/**
	 * �����ļ���·��(Ĭ��Ϊ��ǰĿ¼�µ� snake.ini�ļ�)
	 */
	private static String CONFIG_FILE = "snake.ini";

	/**
	 * һ�����ӵĿ��, ��λ:���� <BR>
	 * ��Ӧ�������ļ��еĹؼ���Ϊ: cell_width, ���� cell_sizeָ��<BR>
	 * ��Χ1 �� 100<BR>
	 * ȱʡֵΪ 23
	 */
	public static final int CELL_WIDTH;

	/**
	 * һ�����ӵĸ߶�, ��λ:���� <BR>
	 * ��Ӧ�������ļ��еĹؼ���Ϊ: cell_width, ���� cell_sizeָ��<BR>
	 * ��Χ1 �� 100<BR>
	 * ȱʡֵΪ 23
	 */
	public static final int CELL_HEIGHT;
	/**
	 * �ø��ӱ�ʾ�Ŀ��, (���Ϊ���ٸ�����) ��λ:�� <BR>
	 * ��Ӧ�������ļ��еĹؼ���Ϊ: width<BR>
	 * ��Χ10 �� 80<BR>
	 * ȱʡֵΪ 30
	 */
	public static final int WIDTH;

	/**
	 * �ø��ӱ�ʾ�ĸ߶�, (�߶�Ϊ���ٸ�����), ��λ:��)<BR>
	 * ��Ӧ�������ļ��еĹؼ���Ϊ: height<BR>
	 * ��Χ10 �� 60<BR>
	 * ȱʡֵΪ20
	 */
	public static final int HEIGHT;

	/**
	 * ��ʾ�����ؿ�� (���ӿ�ȶ� * ÿһ��Ŀ��)
	 */
	public static final int CANVAS_WIDTH;
	/**
	 * ��ʾ�����ظ߶� (���Ӹ߶� * ÿһ��ĸ߶�)
	 */
	public static final int CANVAS_HEIGHT;

	/**
	 * �ߵĳ�ʼ����, ��Ӧ�������ļ��еĹؼ���Ϊ: init_length<BR>
	 * ��Χ2 �� �����<BR>
	 * (��λ:��) ȱʡֵΪ 2
	 */
	public static final int INIT_LENGTH;

	/**
	 * �ߵĳ�ʼ�ٶ� (��λ: ����/��)<BR>
	 * ��Ӧ�������ļ��еĹؼ���Ϊ: speed<BR>
	 * ��Χ10 �� ���޴�<BR>
	 * ȱʡֵΪ 200
	 */
	public static final int SPEED;

	/**
	 * ��ÿ�μ��ٻ���ٵķ��� (��λ: ����/��)<BR>
	 * ��Ӧ�������ļ��Ĺؼ���Ϊ: speed_step<BR>
	 * ��Χ1 �� ���޴�<BR>
	 * ȱʡֵΪ 25
	 */
	public static final int SPEED_STEP;

	public static final String TITLE_LABEL_TEXT;

	public static final String INFO_LABEL_TEXT;

	/**
	 * Ĭ�ϵĹ�����, ˽�е�, ��������������ʵ��
	 */
	private Global() {
	}

	/**
	 * ��ʼ������
	 */
	static {
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(CONFIG_FILE);
			properties.load(inputStream);
		} catch (Exception e) {
			System.out.println("û�������ļ�");
		} finally {
			try {
				if (inputStream != null)
					inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Integer temp = null;
		/* û�����û����õ���ЧʱҪ��һ��Ĭ��ֵ */
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
		TITLE_LABEL_TEXT = (tempStr = getValue("title")) == null ? "˵����"
				: tempStr;
		INFO_LABEL_TEXT = (tempStr = getValue("info")) == null ? "��������Ʒ���, �س�����ͣ/����\nPAGE UP, PAGE DOWN ���ٻ����\n\n�����뿴 www.itcast.cn "
				: tempStr;
	}

	/**
	 * Ҫ���Ƕ������<BR>
	 * 1. û�����key��value<BR>
	 * 2 ��key û�� value
	 */
	private static Integer getIntValue(String key) {
		if (key == null)
			throw new RuntimeException("key ����Ϊ��");
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
