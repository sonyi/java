package cn.imcore.exercise;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Exercise {
	public Exercise() {
		JFrame frame = new JFrame("登入界面");
		frame.setLayout(new GridLayout(5,1));
		frame.setBounds(300, 100, 300, 300);
		
		JPanel jp1 = new JPanel();
		JLabel jb1 = new JLabel("用户名:");
		JTextField t1 = new JTextField(20);
		jp1.add(jb1);
		jp1.add(t1);
		
		JPanel jp2 = new JPanel();
		JLabel jb2 = new JLabel("密   码:");
		JTextField t2 = new JTextField(20);
		jp2.add(jb2);
		jp2.add(t2);
		
		JPanel jp3 = new JPanel();
		JLabel jb3 = new JLabel("备   注:");
		JTextArea t3 = new JTextArea(4,20);
		t3.setBackground(Color.CYAN);
		jp3.add(jb3);
		jp3.add(t3);
		
		JPanel jp4 = new JPanel();
		JCheckBox c = new JCheckBox("已经阅读条款，同意条款内容");
		jp4.add(c);
		
		JPanel jp5 = new JPanel();
		JButton button1 = new JButton("确定");
		JButton button2 = new JButton("取消");
		jp5.add(button1);
		jp5.add(button2);
		
		frame.add(jp1);
		frame.add(jp2);
		frame.add(jp3);
		frame.add(jp4);
		frame.add(jp5);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Exercise();
		
		
	}

}
