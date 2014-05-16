package sonyi.frame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UserFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	JTextField userName;
	JPasswordField password;
	JButton login,exit;
	public UserFrame() {
		init();
	}
	
	public void init(){
		setTitle("�������");
		setLayout(null);
		setBounds(200, 100, 400, 300);
		
		JLabel nameLabel = new JLabel("�û�����");
		nameLabel.setBounds(70, 50, 60, 30);
		userName = new JTextField("zhangsan");
		userName.setBounds(130, 50, 150, 30);
		add(nameLabel);
		add(userName);
		
		JLabel passLabel = new JLabel(" ��  �룺");
		passLabel.setBounds(70, 100, 60, 30);
		password = new JPasswordField("12345");
		password.setBounds(130, 100, 150, 30);
		add(passLabel);
		add(password);
		
		login = new JButton("��   ��");
		exit = new JButton("ȡ   ��");
		login.setBounds(100, 150, 70, 30);
		exit.setBounds(200, 150, 70, 30);
		add(login);
		add(exit);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
