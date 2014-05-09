package cn.imcore.test;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BorderLayoutDemo2 extends JFrame{
	public BorderLayoutDemo2() {
		this.setTitle("边框布局");//
		
		JButton jBut1 = new JButton("北");
//		JButton jBut2 = new JButton("南");
		JButton jBut3 = new JButton("西");
		JButton jBut4 = new JButton("东");
		JButton jBut5 = new JButton("中间");
		
		JButton jBut21 = new JButton("确定");
		JButton jBut22 = new JButton("取消");
		//
		add(jBut1, BorderLayout.NORTH);
		add(jBut3, BorderLayout.WEST);
		add(jBut4, BorderLayout.EAST);
		add(jBut5, BorderLayout.CENTER);
		
//		Container c = new Container();
//		c.setLayout(new FlowLayout());
//		c.add(jBut21);
//		c.add(jBut22);
//		add(c, BorderLayout.SOUTH);
		
		JPanel jP1 = new JPanel();
		jP1.add(jBut21);
		jP1.add(jBut22);
		add(jP1, BorderLayout.SOUTH);
		
		this.setBounds(150, 100, 400, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new BorderLayoutDemo2();

	}

}
