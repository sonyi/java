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

public class FrameClient extends JFrame implements ActionListener{
	private MultClient client;
	
	public static Vector<Socket> userList;
	public static Vector<String> userNames;
	
	private JPanel northPanel, southPanel, westPanel, centerPanel;
	public static JButton connectBtn, sendBtn;
	private JTextField ip, port, userName, sendText;
	public static JList user;
	public static JTextArea history;
	private JLabel ipTxt, portTxt, userTxt;
	
	public FrameClient() {
		this.setTitle("客户端界面");
		
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
		
		connectBtn = new JButton("连接");
		sendBtn = new JButton("发送");
		portTxt = new JLabel("端口号：");
		ipTxt = new JLabel("服务器IP：");
		userTxt = new JLabel("用户名：");
		
		port = new JTextField("8001", 6);
		sendText = new JTextField(30);
		ip = new JTextField("127.0.0.1", 10);
		userName = new JTextField(8);
		
		user = new JList(userNames);
		JScrollPane usrPan = new JScrollPane(user);
		user.setFixedCellWidth(50);
//		user.setFixedCellHeight(50);
		
		history = new JTextArea(9,45);
		history.setBackground(Color.lightGray);
		history.setEditable(false);
		//
		northPanel.add(ipTxt);
		northPanel.add(ip);
		northPanel.add(portTxt);
		northPanel.add(port);
		northPanel.add(userTxt);
		northPanel.add(userName);
		northPanel.add(connectBtn);
		//
		southPanel.add(sendText);
		southPanel.add(sendBtn);
		//
		westPanel.add(usrPan);
		//
		centerPanel.add(history);
		
		//添加按钮事件
		connectBtn.addActionListener(this);
		sendBtn.addActionListener(this);
		
		
		add(northPanel, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);
		add(westPanel, BorderLayout.WEST);
		add(centerPanel, BorderLayout.CENTER);
		
		//设置窗口
		this.setBounds(200, 100, 600, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new FrameClient();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == connectBtn) {//连接
			String cIp = ip.getText();
			String cPort = port.getText();
			String name = userName.getText();
			if("".equals(cIp) || "".equals(cPort)
					|| "".equals(name)) {
				JOptionPane.showMessageDialog(null, "请填写连接信息！");
			} else {
				//创建客户线程
				client = new MultClient(cIp, Integer.parseInt(cPort), name);
				//启动客户线程
				client.start();
				connectBtn.setEnabled(false);
				JOptionPane.showMessageDialog(null, "客户端已经连接上服务器！");
			}
		}
		
		if(e.getSource() == sendBtn) {
			if(client == null) {
				JOptionPane.showMessageDialog(null, "未连接服务器！");
			} else {
				String str = sendText.getText();
				if("".equals(str)) {
					JOptionPane.showMessageDialog(null, "发送信息不能为空！");
				} else if(client == null) {
					JOptionPane.showMessageDialog(null, "未连接服务器！");
				}
				else {
					//发送信息
					client.sendMsg(str);
					sendText.setText("");
				}
			}
		}
		
	}
	//刷新用户列表
	public static void reFresh(String[] datas) {
		if(datas != null){
			user.setListData(datas);
		} else {
			user.setListData(userNames);
		}
	}

	
}
