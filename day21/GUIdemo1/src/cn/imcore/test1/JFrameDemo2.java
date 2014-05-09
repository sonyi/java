package cn.imcore.test1;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameDemo2 extends JFrame{
	public JFrameDemo2() {
		this.setTitle("这是一个测试窗口");//给窗体设置标题
		ImageIcon icon = new ImageIcon("logo.png");
		this.setIconImage(icon.getImage());//设置窗口图标显示的图像
		
		
//		Container c = this.getContentPane();
		JButton jbutton1 = new JButton("点我啊",new ImageIcon("book.png"));
		JButton jbutton2 = new JButton("我在这里呀");
		
		add(jbutton1, BorderLayout.CENTER);
		add(jbutton2, BorderLayout.SOUTH);
//		this.setSize(400, 300);//设置窗体大小
//		this.setLocation(200, 200);//设置窗体位置
		this.setBounds(200, 200, 400, 300);//设置窗体大小和位置
		this.setVisible(true);//设置窗体可见;默认是不可见
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new JFrameDemo2();
		
	}

}
