package cn.imcore.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginFrame extends JFrame implements ActionListener{
	
	private JLabel userTxt, pwdTxt;
	private JTextField userName, userPwd;
	private JButton loginBtn, canelBtn;
	private JPanel userPanel, pwdPanel, loginPanel;
	
	public LoginFrame() {
		this.setTitle("��¼����");
		this.setLayout(new GridLayout(3,1));
		userPanel = new JPanel();
		pwdPanel = new JPanel();
		loginPanel = new JPanel();
		
		userTxt = new JLabel("��  ��");
		pwdTxt = new JLabel("��  ��");
		userName = new JTextField(10);
		userPwd = new JTextField(10);
		loginBtn = new JButton("��¼");
		canelBtn = new JButton("�ر�");
		loginBtn.addActionListener(this);
		canelBtn.addActionListener(this);
		
		userPanel.add(userTxt);
		userPanel.add(userName);
		
		pwdPanel.add(pwdTxt);
		pwdPanel.add(userPwd);
		
		loginPanel.add(loginBtn);
		loginPanel.add(canelBtn);
		
		add(userPanel);
		add(pwdPanel);
		add(loginPanel);
		
		this.setSize(350, 200);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == loginBtn) {
			if(checkUser()) {//true
				//1.�رյ�ǰ���ڣ� 2.���´���
				this.dispose();
				new ShowFrame();
			}
		}
		
		if(e.getSource() == canelBtn) {
			System.exit(1);
		}
		
	}

	public boolean checkUser() {
		if("".equals(userName.getText())) {
			JOptionPane.showMessageDialog(this, "�û�������Ϊ�գ�");
			return false;
		}
		if("".equals(userPwd.getText())) {
			JOptionPane.showMessageDialog(this, "���벻��Ϊ�գ�");
			return false;
		}
		
		return true;
	}
}
