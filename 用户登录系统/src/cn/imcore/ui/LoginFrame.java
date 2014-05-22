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
		this.setTitle("�û���¼");
		this.setLayout(new GridLayout(3,1));
		
		userPanel = new JPanel();
		pwdPanel = new JPanel();
		btnPanel = new JPanel();
		
		userTxt = new JLabel("��  ��:");
		pwdTxt = new JLabel("��  ��:");
		
		userField = new JTextField(10);
		pwdField = new JTextField(10);
		
		loginBtn = new JButton("��¼");
		canelBtn = new JButton("ȡ��");
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
			//��¼���û��������Ƿ�Ϊ�յ��ж�
			if(checkUser()) {
				//��Ϊ�վ�ȥ���ݿ��������ж�
				int flag = userOper.getUser(userField.getText(), pwdField.getText());
				if(flag>0) {
					//�������ݵ�չʾ����
					new ShowFrame();
				} else {
					JOptionPane.showMessageDialog(this, "�û������벻���ڣ�");
					
				}
			}
		}
		
	}

	
	public boolean checkUser() {
		if("".equals(userField.getText())
				|| "".equals(pwdField.getText())) {
			JOptionPane.showMessageDialog(this, "�û�������û��¼�룡");
			return false;
		}
		
		return true;
	}
}
