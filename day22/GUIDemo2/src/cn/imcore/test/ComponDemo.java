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
		"���Ŵ�ѧ","���ݴ�ѧ","������ѧ","�����廪","�㽭��ѧ"
	};
	public static String[] list2 = new String[]{
		"���Ŵ�ѧ","���ݴ�ѧ","������ѧ","�����廪","�㽭��ѧ"
		,"�Ϻ�����","�人��ѧ","�Ͼ���ѧ"
		,"���Ŵ�ѧ","���ݴ�ѧ","������ѧ","�����廪","�㽭��ѧ"
		,"�Ϻ�����","�人��ѧ","�Ͼ���ѧ"
	};
	public ComponDemo() {
		this.setLayout(new FlowLayout());
		
		JPanel jp1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel jp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel jp3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel jp4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel jp5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		JTextField jTextField = new JTextField("�����ı���",20);
		JCheckBox jChk1 = new JCheckBox("������", true);
		JCheckBox jChk2 = new JCheckBox("����Ϸ");
		JCheckBox jChk3 = new JCheckBox("˯��");
		
		ButtonGroup sex = new ButtonGroup();
		JRadioButton sex1 = new JRadioButton("��");
		JRadioButton sex2 = new JRadioButton("Ů");
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
		//this.setResizable(false);//���ڹ̶�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new ComponDemo();

	}

}
