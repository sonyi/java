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
		setTitle("�޸Ľ���");
		setLayout(null);
		setBounds(200, 100, 400, 300);
		
		JLabel nameLabel = new JLabel("������");
		nameLabel.setBounds(90, 40, 60, 30);
		title = new JTextField("�����˼��");
		title.setBounds(140, 40, 150, 30);
		add(nameLabel);
		add(title);
		
		JLabel authName = new JLabel("���ߣ�");
		authName.setBounds(90, 90, 60, 30);
		auth = new JTextField("����");
		auth.setBounds(140, 90, 150, 30);
		add(authName);
		add(auth);
		
		JLabel countName = new JLabel("���飺");
		countName.setBounds(90, 140, 60, 30);
		count = new JTextField("5");
		count.setBounds(140, 140, 150, 30);
		add(countName);
		add(count);
		
		save = new JButton("��  ��");
		exit = new JButton("ȡ  ��");
		save.setBounds(110, 190, 70, 30);
		exit.setBounds(210, 190, 70, 30);
		add(save);
		add(exit);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}
