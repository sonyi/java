package cn.imcore.test;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutDemo extends JFrame{

	public FlowLayoutDemo() {
		this.setTitle("流式布局");
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		for(int i=1; i<=10; i++) {
			JButton JBut1 = new JButton("按钮" + i);
			add(JBut1);
		}
		
		this.setBounds(150, 100, 400, 300);
		this.setVisible(true);
		this.setResizable(false);//窗口固定
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new FlowLayoutDemo();

	}

}
