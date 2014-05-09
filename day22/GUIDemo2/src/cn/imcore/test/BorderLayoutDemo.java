package cn.imcore.test;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutDemo extends JFrame{
	public BorderLayoutDemo() {
		this.setTitle("边框布局");//
		
		JButton jBut1 = new JButton("北");
		JButton jBut2 = new JButton("南");
		JButton jBut3 = new JButton("西");
		JButton jBut4 = new JButton("东");
		JButton jBut5 = new JButton("中间");
		
		//
		add(jBut1, BorderLayout.NORTH);
		add(jBut2, BorderLayout.SOUTH);
		add(jBut3, BorderLayout.WEST);
		add(jBut4, BorderLayout.EAST);
		add(jBut5, BorderLayout.CENTER);
		
		this.setBounds(150, 100, 400, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new BorderLayoutDemo();

	}

}
