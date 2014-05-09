package cn.imcore.test;

import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class TitleBorderDemo extends JFrame{

	public TitleBorderDemo() {
		JPanel panel = new JPanel(); 
		panel.setBorder(new TitledBorder("用户列表"));
		
		panel.add(new JButton("dddddddddd"));
		
		add(panel);
		
		setBounds(200, 200, 400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	public static void main(String[] args) {
		new TitleBorderDemo();

	}

}
