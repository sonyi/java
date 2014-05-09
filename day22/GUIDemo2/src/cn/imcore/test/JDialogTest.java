package cn.imcore.test;

import javax.swing.JButton;
import javax.swing.JDialog;

public class JDialogTest {

	public JDialogTest() {
		JDialog d = new JDialog();
//		d.getContentPane();
		d.add(new JButton("µ„Œ“∞°"));
		
		d.setBounds(200, 200, 400, 300);
		d.setVisible(true);
		d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new JDialogTest();

	}

}
