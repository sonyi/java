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
		this.setTitle("�߿򲼾�");//
		
		JButton jBut1 = new JButton("��");
//		JButton jBut2 = new JButton("��");
		JButton jBut3 = new JButton("��");
		JButton jBut4 = new JButton("��");
		JButton jBut5 = new JButton("�м�");
		
		JButton jBut21 = new JButton("ȷ��");
		JButton jBut22 = new JButton("ȡ��");
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
