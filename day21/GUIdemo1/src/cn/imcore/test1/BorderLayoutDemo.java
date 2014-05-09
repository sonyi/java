package cn.imcore.test1;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutDemo extends JFrame{

	public BorderLayoutDemo() {
		//JFrameĬ�ϲ����Ǳ߿򲼾� BorderLayout
		JButton jButton1 = new JButton("��");
		JButton jButton2 = new JButton("��");
		JButton jButton3 = new JButton("��");
		JButton jButton4 = new JButton("��");
		JButton jButton5 = new JButton("�м�");
		add(jButton1, BorderLayout.EAST);
		add(jButton2, BorderLayout.SOUTH);
		add(jButton3, BorderLayout.WEST);
		add(jButton4, BorderLayout.NORTH);
		add(jButton5, BorderLayout.CENTER);
		
		this.setBounds(200, 200, 400, 300);//���ô����С��λ��
		this.setVisible(true);//���ô���ɼ�;Ĭ���ǲ��ɼ�
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new BorderLayoutDemo();

	}

}
