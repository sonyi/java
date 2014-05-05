package cn.itcast.snake.game;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 游戏的设置项面板
 * 
 * @version 1.0, 01/01/08
 * 
 * @author 汤阳光
 * 
 */
public class GameOptionPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ButtonGroup buttonGroup = new ButtonGroup();
	private ImageIcon czbkIcon = new ImageIcon(GameOptionPanel.class
			.getResource("/czbk.png"));

	private JFrame frame;

	private final JButton newGameButton = new JButton();

	private final JButton stopGameButton = new JButton();

	private final JButton pauseButton = new JButton();

	private final JCheckBox checkBox_drawGridding = new JCheckBox();

	private final JRadioButton radioButton_map1;
	private final JRadioButton radioButton_map2;
	
	private final JButton button_griddingColor;
	private final JButton button_backgroundColor;
	private final JButton button_foodColor;
	private final JButton button_headColor;
	private final JButton button_bodyColor;
	
	private final JButton button_default;

	/**
	 * Create the panel
	 */
	public GameOptionPanel() {
		super();
		setSize(450, 185);
		setLayout(null);
		setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		setFocusable(false);

		final JSeparator separator = new JSeparator();
		separator.setBounds(140, 55, 156, 50);
		add(separator);

		button_griddingColor = new JButton();
		button_griddingColor.setBounds(85, 10, 60, 23);
		separator.add(button_griddingColor);

		button_griddingColor.setFont(new Font("宋体", Font.PLAIN, 12));
		button_griddingColor.setFocusable(false);
		button_griddingColor.setText("颜色");

		button_griddingColor.setVisible(false);

		checkBox_drawGridding.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				button_griddingColor.setVisible(checkBox_drawGridding
						.isSelected());
			}
		});
		checkBox_drawGridding.setBounds(5, 10, 78, 23);
		separator.add(checkBox_drawGridding);

		checkBox_drawGridding.setText("显示网格");
		checkBox_drawGridding.setFont(new Font("宋体", Font.PLAIN, 12));

		final JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(10, 55, 119, 33);
		add(separator_6);

		button_backgroundColor = new JButton();
		button_backgroundColor.setBounds(5, 10, 110, 23);
		separator_6.add(button_backgroundColor);

		button_backgroundColor.setFont(new Font("宋体", Font.PLAIN, 12));
		button_backgroundColor.setFocusable(false);
		button_backgroundColor.setText("设置背景颜色");

		final JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(10, 135, 286, 39);
		add(separator_4);

		button_foodColor = new JButton();
		button_foodColor.setBounds(5, 10, 111, 23);
		separator_4.add(button_foodColor);

		button_foodColor.setFont(new Font("宋体", Font.PLAIN, 12));
		button_foodColor.setFocusable(false);
		button_foodColor.setText("设置食物颜色");

		radioButton_map1 = new JRadioButton();
		radioButton_map1.setFont(new Font("宋体", Font.PLAIN, 12));
		radioButton_map1.setSelected(true);
		buttonGroup.add(radioButton_map1);
		radioButton_map1.setText("地图1");
		radioButton_map1.setBounds(135, 10, 63, 23);
		separator_4.add(radioButton_map1);

		radioButton_map2 = new JRadioButton();
		radioButton_map2.setFont(new Font("宋体", Font.PLAIN, 12));
		buttonGroup.add(radioButton_map2);
		radioButton_map2.setText("地图2");
		radioButton_map2.setBounds(198, 10, 63, 23);
		separator_4.add(radioButton_map2);

		final JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 95, 286, 39);
		add(separator_1);

		button_headColor = new JButton();
		button_headColor.setBounds(5, 10, 110, 23);
		separator_1.add(button_headColor);

		button_headColor.setFont(new Font("宋体", Font.PLAIN, 12));
		button_headColor.setFocusable(false);
		button_headColor.setText("设置蛇头颜色");

		button_bodyColor = new JButton();
		button_bodyColor.setBounds(135, 10, 113, 23);
		separator_1.add(button_bodyColor);

		button_bodyColor.setFont(new Font("宋体", Font.PLAIN, 12));
		button_bodyColor.setFocusable(false);
		button_bodyColor.setText("设置蛇身颜色");

		final JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(302, 10, 140, 165);
		add(separator_2);

		final JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(10, 70, 125, 95);
		separator_2.add(separator_5);

		stopGameButton.setText("停止游戏");

		stopGameButton.setBounds(11, 10, 101, 23);
		separator_5.add(stopGameButton);
		stopGameButton.setFont(new Font("宋体", Font.PLAIN, 12));
		stopGameButton.setFocusable(false);

		pauseButton.setBounds(10, 40, 101, 23);
		separator_5.add(pauseButton);
		pauseButton.setText("暂停/继续");
		pauseButton.setFont(new Font("宋体", Font.PLAIN, 12));
		pauseButton.setFocusable(false);

		newGameButton.setFont(new Font("宋体", Font.PLAIN, 12));
		newGameButton.setBounds(11, 70, 101, 23);
		separator_5.add(newGameButton);
		newGameButton.setFocusable(false);
		newGameButton.setText("开始新游戏");

		final JLabel label_logo = new JLabel(czbkIcon);
		label_logo.setBounds(10, 10, 125, 50);
		separator_2.add(label_logo);

		final JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 20, 286, 34);
		add(separator_3);

		final JLabel label_2 = new JLabel();
		label_2.setFont(new Font("宋体", Font.PLAIN, 12));
		label_2.setText("选项：");
		label_2.setBounds(10, 10, 60, 15);
		separator_3.add(label_2);

		button_default = new JButton();
		button_default.setText("恢复默认设置");
		button_default.setFont(new Font("宋体", Font.PLAIN, 12));
		button_default.setBounds(139, 6, 137, 23);
		button_default.setFocusable(false);
		separator_3.add(button_default);
		
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JCheckBox getCheckBox_drawGridding() {
		return checkBox_drawGridding;
	}

	public ImageIcon getCzbkIcon() {
		return czbkIcon;
	}

	public void setCzbkIcon(ImageIcon czbkIcon) {
		this.czbkIcon = czbkIcon;
	}

	public JButton getNewGameButton() {
		return newGameButton;
	}

	public JButton getPauseButton() {
		return pauseButton;
	}

	public JButton getStopGameButton() {
		return stopGameButton;
	}

	public JButton getButton_griddingColor() {
		return button_griddingColor;
	}

	public JButton getButton_backgroundColor() {
		return button_backgroundColor;
	}

	public JButton getButton_foodColor() {
		return button_foodColor;
	}

	public JButton getButton_headColor() {
		return button_headColor;
	}

	public JButton getButton_bodyColor() {
		return button_bodyColor;
	}

	public JRadioButton getRadioButton_map2() {
		return radioButton_map2;
	}

	public JRadioButton getRadioButton_map1() {
		return radioButton_map1;
	}

	public JButton getButton_default() {
		return button_default;
	}

	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}

	public void setButtonGroup(ButtonGroup buttonGroup) {
		this.buttonGroup = buttonGroup;
	}

}
