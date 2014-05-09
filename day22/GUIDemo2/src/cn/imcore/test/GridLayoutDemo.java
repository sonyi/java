package cn.imcore.test;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutDemo extends JFrame{

	public GridLayoutDemo() {
		this.setTitle("网格布局");
		this.setLayout(new GridLayout(3,2));
		for(int i=1; i<=6; i++) {
			JButton JBut1 = new JButton("按钮" + i);
			add(JBut1);
		}
		
		this.setBounds(150, 100, 400, 300);
		this.setVisible(true);
		//this.setResizable(false);//窗口固定
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new GridLayoutDemo();

	}

}
