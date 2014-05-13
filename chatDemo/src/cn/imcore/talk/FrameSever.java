package cn.imcore.talk;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class FrameSever extends JFrame implements ActionListener{
	private MultServer server;
	
//	public static Vector<Socket> userList;
	public static Vector<User> userList;
	public static Vector<String> userNames;
	
	private JPanel northPanel, southPanel, westPanel, centerPanel;
	private JButton startBtn, sendBtn, endBtn;
	private JTextField port, sendText;
	public static JList user;
	public static JTextArea history;
	private JLabel portTxt;
	
	public FrameSever() {
		this.setTitle("服务器界面");
		
		userList = new Vector();
		userNames = new Vector();
		
		northPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		southPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		westPanel = new JPanel();
		centerPanel = new JPanel();
		
		//
		northPanel.setBorder(new TitledBorder(""));
		westPanel.setBorder(new TitledBorder("用户列表"));
		southPanel.setBorder(new TitledBorder(""));
		centerPanel.setBorder(new TitledBorder(""));
		
		startBtn = new JButton("启动");
		endBtn = new JButton("关闭");
		sendBtn = new JButton("发送");
		portTxt = new JLabel("端口号：");
		port = new JTextField("8001", 8);
		sendText = new JTextField(20);
		
		user = new JList(userList);
		JScrollPane usrPan = new JScrollPane(user);
		user.setFixedCellWidth(50);
//		user.setFixedCellHeight(50);
		
		history = new JTextArea(9,27);
		history.setBackground(Color.lightGray);
		history.setEditable(false);
		//
		northPanel.add(portTxt);
		northPanel.add(port);
		northPanel.add(startBtn);
		northPanel.add(endBtn);
		//
		southPanel.add(sendText);
		southPanel.add(sendBtn);
		//
		westPanel.add(usrPan);
		//
		centerPanel.add(history);
		
		//添加按钮事件
		startBtn.addActionListener(this);
		sendBtn.addActionListener(this);
		endBtn.addActionListener(this);
		
		
		
		
		
		add(northPanel, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);
		add(westPanel, BorderLayout.WEST);
		add(centerPanel, BorderLayout.CENTER);
		
		//设置窗口
		this.setBounds(200, 100, 400, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new FrameSever();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == startBtn) {//启动按钮
			String port1 = port.getText();
			//端口号为空判断
			if("".equals(port1)) {
				JOptionPane.showMessageDialog(null, "端口号不能为空！");
			} 
			else if(server != null) {
				JOptionPane.showMessageDialog(null, "服务器已经启动了，不要在点了！");
			}
			else{
			//创建服务线程
				server = new MultServer(Integer.parseInt(port1));
			//启动服务线程
				server.start();
				startBtn.setEnabled(false);
				endBtn.setEnabled(true);
				JOptionPane.showMessageDialog(null, "服务器已经启动！");
			}
			
		}
		
		if(e.getSource() == sendBtn) {//发送按钮
			String str = sendText.getText();
			if("".equals(str)){
				JOptionPane.showMessageDialog(null, "发送的信息不能为空！");
				
			} else if(server == null) {
				JOptionPane.showMessageDialog(null, "服务器未启动！");
				
			}
			else {
				server.sendToClients(null, "服务器:"+str);
				sendText.setText("");
			}
		}
		
		if(e.getSource() == endBtn) {//服务器关闭
			server.sendToClients(null, "关闭");
			server.close();
			startBtn.setEnabled(true);
			endBtn.setEnabled(false);
			server = null;
		}
	}

	//刷新用户列表
	public static void reFresh() {
		user.setListData(userNames);
	}
}
