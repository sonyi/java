package cn.imcore.test1;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutDemo extends JFrame{

	public BorderLayoutDemo() {
		//JFrame默认布局是边框布局 BorderLayout
		JButton jButton1 = new JButton("东");
		JButton jButton2 = new JButton("南");
		JButton jButton3 = new JButton("西");
		JButton jButton4 = new JButton("北");
		JButton jButton5 = new JButton("中间");
		add(jButton1, BorderLayout.EAST);
		add(jButton2, BorderLayout.SOUTH);
		add(jButton3, BorderLayout.WEST);
		add(jButton4, BorderLayout.NORTH);
		add(jButton5, BorderLayout.CENTER);
		
		this.setBounds(200, 200, 400, 300);//设置窗体大小和位置
		this.setVisible(true);//设置窗体可见;默认是不可见
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new BorderLayoutDemo();

	}

}
