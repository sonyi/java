package cn.imcore.test;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AbsoluteDemo extends JFrame{
	JButton[] JBut;
	
	public AbsoluteDemo() {
		this.setTitle("���Բ���");
		this.setLayout(null);//ȥ���κβ���

		JBut = new JButton[5];
		for(int i=0; i<5; i++) {
			JBut[i] = new JButton("��ť" + i);
		}
		JBut[0].setBounds(20, 20, 80, 30);
		JBut[1].setBounds(120, 20, 80, 30);
		JBut[2].setBounds(20, 70, 80, 30);
		JBut[3].setBounds(120, 70, 80, 30);
		JBut[4].setBounds(120, 120, 80, 30);
		
		add(JBut[0]);
		add(JBut[1]);
		add(JBut[2]);
		add(JBut[3]);
		add(JBut[4]);
		this.setBounds(150, 100, 400, 300);
		this.setVisible(true);
		//this.setResizable(false);//���ڹ̶�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new AbsoluteDemo();

	}

}
