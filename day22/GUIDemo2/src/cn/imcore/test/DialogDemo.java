package cn.imcore.test;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class DialogDemo extends JFrame implements ActionListener{
	static DialogDemo jFrame;
	
	public DialogDemo() {
		JButton btn = new JButton("µ¯³ö¶Ô»°¿ò");
		btn.addActionListener(this);
		
		add(btn);
		this.setBounds(200, 100, 400, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	public static void main(String[] args) {
		
		jFrame = new DialogDemo();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JDialog d = new JDialog(jFrame,"Dialog",true);
		Container c = d.getContentPane();
		c.add(new JButton("hello"));
		d.setSize(400, 200);
		d.setLocation(200, 200);
		d.setVisible(true);
		
	}

}
