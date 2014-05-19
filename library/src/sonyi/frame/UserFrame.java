package sonyi.frame;

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
	JTextField userName;
	JPasswordField password;
	JButton login,exit;
	public UserFrame() {
		init();
	}
	
	public static void main(String[] args){
		new UserFrame();
	}
	
	
	public void init(){//初始化登入界面
		setTitle("登入界面");
		setLayout(null);
		setBounds(200, 100, 400, 300);
		
		JLabel nameLabel = new JLabel("用户名：");
		nameLabel.setBounds(70, 50, 60, 30);
		userName = new JTextField("zhangsan");
		userName.setBounds(130, 50, 150, 30);
		add(nameLabel);
		add(userName);
		
		JLabel passLabel = new JLabel(" 密  码：");
		passLabel.setBounds(70, 100, 60, 30);
		password = new JPasswordField("12345");
		password.setBounds(130, 100, 150, 30);
		add(passLabel);
		add(password);
		
		login = new JButton("登   入");
		exit = new JButton("取   消");
		login.setBounds(100, 150, 70, 30);
		exit.setBounds(200, 150, 70, 30);
		add(login);
		add(exit);
		
		myEvent();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void myEvent(){//设置监听事件
		login.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				String name = userName.getText();
				String pass = new String(password.getPassword());
				
				if(checkPassword(name, pass)){//验证用户信息
					new DataFrame();
					setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "账号或密码错误");
				}
			}
		});
		
		exit.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {//退出系统
				System.exit(0);
			}
		});
	}
	
	public boolean checkPassword(String name,String password){//验证用户信息
		Vector<String> user = new Vector<>();
		user.add(name);
		user.add(password);
		try {
			Vector<Vector<String>> userList = new OperateFile().readOperate(FileLoad.file);//获取用户列表
			if(userList.contains(user)){
				return true;
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
