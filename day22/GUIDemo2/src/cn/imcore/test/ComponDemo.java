package cn.imcore.test;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ComponDemo extends JFrame{
	public static String[] list = new String[]{
		"厦门大学","福州大学","北京大学","北京清华","浙江大学"
	};
	public static String[] list2 = new String[]{
		"厦门大学","福州大学","北京大学","北京清华","浙江大学"
		,"上海交大","武汉大学","南京大学"
		,"厦门大学","福州大学","北京大学","北京清华","浙江大学"
		,"上海交大","武汉大学","南京大学"
	};
	public ComponDemo() {
		this.setLayout(new FlowLayout());
		
		JPanel jp1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel jp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel jp3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel jp4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel jp5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		JTextField jTextField = new JTextField("测试文本框",20);
		JCheckBox jChk1 = new JCheckBox("看电视", true);
		JCheckBox jChk2 = new JCheckBox("打游戏");
		JCheckBox jChk3 = new JCheckBox("睡觉");
		
		ButtonGroup sex = new ButtonGroup();
		JRadioButton sex1 = new JRadioButton("男");
		JRadioButton sex2 = new JRadioButton("女");
		sex.add(sex1);
		sex.add(sex2);
		
		JComboBox cbox = new JComboBox(list);
		
		JList jList = new JList(list2);
		JScrollPane scrollPane = new JScrollPane(jList);

		jp1.add(jChk1);
		jp1.add(jChk2);
		jp1.add(jChk3);
		
		jp2.add(sex1);
		jp2.add(sex2);
		
		jp3.add(jTextField);
		jp4.add(cbox);
		jp5.add(scrollPane);
		//
		add(jp3);
		add(jp1);
		add(jp2);
		add(jp4);
		add(jp5);
		this.setBounds(150, 100, 400, 400);
		this.setVisible(true);
		//this.setResizable(false);//窗口固定
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new ComponDemo();

	}

}
