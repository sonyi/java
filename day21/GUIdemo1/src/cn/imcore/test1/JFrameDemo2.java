package cn.imcore.test1;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameDemo2 extends JFrame{
	public JFrameDemo2() {
		this.setTitle("����һ�����Դ���");//���������ñ���
		ImageIcon icon = new ImageIcon("logo.png");
		this.setIconImage(icon.getImage());//���ô���ͼ����ʾ��ͼ��
		
		
//		Container c = this.getContentPane();
		JButton jbutton1 = new JButton("���Ұ�",new ImageIcon("book.png"));
		JButton jbutton2 = new JButton("��������ѽ");
		
		add(jbutton1, BorderLayout.CENTER);
		add(jbutton2, BorderLayout.SOUTH);
//		this.setSize(400, 300);//���ô����С
//		this.setLocation(200, 200);//���ô���λ��
		this.setBounds(200, 200, 400, 300);//���ô����С��λ��
		this.setVisible(true);//���ô���ɼ�;Ĭ���ǲ��ɼ�
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new JFrameDemo2();
		
	}

}
