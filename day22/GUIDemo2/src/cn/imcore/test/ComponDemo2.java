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
		"���Ŵ�ѧ","���ݴ�ѧ","������ѧ","�����廪","�㽭��ѧ"
		,"�Ϻ�����","�人��ѧ","�Ͼ���ѧ"
	};
	public ComponDemo2() {
		JList jList = new JList(list2);
		JScrollPane jsp1 = new JScrollPane(jList);
		add(jsp1);
		
		this.setBounds(150, 100, 400, 100);
		this.setVisible(true);
		//this.setResizable(false);//���ڹ̶�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new ComponDemo2();

	}

}
