package cn.imcore.test;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ComponDemo2 extends JFrame{
	public static String[] list2 = new String[]{
		"厦门大学","福州大学","北京大学","北京清华","浙江大学"
		,"上海交大","武汉大学","南京大学"
	};
	public ComponDemo2() {
		JList jList = new JList(list2);
		JScrollPane jsp1 = new JScrollPane(jList);
		add(jsp1);
		
		this.setBounds(150, 100, 400, 100);
		this.setVisible(true);
		//this.setResizable(false);//窗口固定
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new ComponDemo2();

	}

}
