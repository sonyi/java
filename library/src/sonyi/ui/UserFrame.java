package sonyi.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import sonyi.data.OperateFile;
import sonyi.util.FileLoad;

public class UserFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTextField userName;
	private JPasswordField password;
	JButton login,exit;
	public UserFrame() {
		init();
	}
	
	public static void main(String[] args){
		new UserFrame();
	}
	
	
	public void init(){
		setTitle("�������");
		setLayout(null);

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
		
		myEvent();
		setSize(400, 300);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void myEvent(){
		login.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				String name = userName.getText();
				String pass = new String(password.getPassword());
				
				if(checkPassword(name, pass)){
					new DataFrame();
					setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "�˺Ż��������");
				}
			}
		});
		
		exit.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	public boolean checkPassword(String name,String password){
		Vector<String> user = new Vector<>();
		user.add(name);
		user.add(password);
		try {
			Vector<Vector<String>> userList = new OperateFile().readOperate(FileLoad.file);
			if(userList.contains(user)){
				return true;
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
