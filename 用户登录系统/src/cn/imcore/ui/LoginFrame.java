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

import cn.imcore.oper.UserOper;

public class LoginFrame extends JFrame implements ActionListener{
	JLabel userTxt, pwdTxt;
	JTextField userField, pwdField;
	JButton loginBtn, canelBtn;
	JPanel userPanel, pwdPanel, btnPanel;
	private UserOper userOper;
	
	public LoginFrame() {
		this.setTitle("用户登录");
		this.setLayout(new GridLayout(3,1));
		
		userPanel = new JPanel();
		pwdPanel = new JPanel();
		btnPanel = new JPanel();
		
		userTxt = new JLabel("用  户:");
		pwdTxt = new JLabel("密  码:");
		
		userField = new JTextField(10);
		pwdField = new JTextField(10);
		
		loginBtn = new JButton("登录");
		canelBtn = new JButton("取消");
		loginBtn.addActionListener(this);
		userPanel.add(userTxt);
		userPanel.add(userField);
		pwdPanel.add(pwdTxt);
		pwdPanel.add(pwdField);
		btnPanel.add(loginBtn);
		btnPanel.add(canelBtn);
		
		add(userPanel);
		add(pwdPanel);
		add(btnPanel);
		this.setSize(300,200);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		userOper = new UserOper();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == loginBtn) {
			//登录的用户和密码是否为空的判断
			if(checkUser()) {
				//不为空就去数据库里面做判断
				int flag = userOper.getUser(userField.getText(), pwdField.getText());
				if(flag>0) {
					//进入数据的展示界面
					new ShowFrame();
				} else {
					JOptionPane.showMessageDialog(this, "用户或密码不存在！");
					
				}
			}
		}
		
	}

	
	public boolean checkUser() {
		if("".equals(userField.getText())
				|| "".equals(pwdField.getText())) {
			JOptionPane.showMessageDialog(this, "用户或密码没有录入！");
			return false;
		}
		
		return true;
	}
}
