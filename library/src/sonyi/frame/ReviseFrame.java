package sonyi.frame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ReviseFrame extends JFrame{
	JTextField title,auth,count;
	JButton save,exit;
	private static final long serialVersionUID = 4L;
	
	public ReviseFrame() {
		init();
	}
	
	public void init(){
		setTitle("修改界面");
		setLayout(null);
		setBounds(200, 100, 400, 300);
		
		JLabel nameLabel = new JLabel("书名：");
		nameLabel.setBounds(90, 40, 60, 30);
		title = new JTextField("计算机思想");
		title.setBounds(140, 40, 150, 30);
		add(nameLabel);
		add(title);
		
		JLabel authName = new JLabel("作者：");
		authName.setBounds(90, 90, 60, 30);
		auth = new JTextField("张三");
		auth.setBounds(140, 90, 150, 30);
		add(authName);
		add(auth);
		
		JLabel countName = new JLabel("藏书：");
		countName.setBounds(90, 140, 60, 30);
		count = new JTextField("5");
		count.setBounds(140, 140, 150, 30);
		add(countName);
		add(count);
		
		save = new JButton("修  改");
		exit = new JButton("取  消");
		save.setBounds(110, 190, 70, 30);
		exit.setBounds(210, 190, 70, 30);
		add(save);
		add(exit);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}
