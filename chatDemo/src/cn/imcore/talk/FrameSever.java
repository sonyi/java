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
		this.setTitle("����������");
		
		userList = new Vector();
		userNames = new Vector();
		
		northPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		southPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		westPanel = new JPanel();
		centerPanel = new JPanel();
		
		//
		northPanel.setBorder(new TitledBorder(""));
		westPanel.setBorder(new TitledBorder("�û��б�"));
		southPanel.setBorder(new TitledBorder(""));
		centerPanel.setBorder(new TitledBorder(""));
		
		startBtn = new JButton("����");
		endBtn = new JButton("�ر�");
		sendBtn = new JButton("����");
		portTxt = new JLabel("�˿ںţ�");
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
		
		//��Ӱ�ť�¼�
		startBtn.addActionListener(this);
		sendBtn.addActionListener(this);
		endBtn.addActionListener(this);
		
		
		
		
		
		add(northPanel, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);
		add(westPanel, BorderLayout.WEST);
		add(centerPanel, BorderLayout.CENTER);
		
		//���ô���
		this.setBounds(200, 100, 400, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new FrameSever();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == startBtn) {//������ť
			String port1 = port.getText();
			//�˿ں�Ϊ���ж�
			if("".equals(port1)) {
				JOptionPane.showMessageDialog(null, "�˿ںŲ���Ϊ�գ�");
			} 
			else if(server != null) {
				JOptionPane.showMessageDialog(null, "�������Ѿ������ˣ���Ҫ�ڵ��ˣ�");
			}
			else{
			//���������߳�
				server = new MultServer(Integer.parseInt(port1));
			//���������߳�
				server.start();
				startBtn.setEnabled(false);
				endBtn.setEnabled(true);
				JOptionPane.showMessageDialog(null, "�������Ѿ�������");
			}
			
		}
		
		if(e.getSource() == sendBtn) {//���Ͱ�ť
			String str = sendText.getText();
			if("".equals(str)){
				JOptionPane.showMessageDialog(null, "���͵���Ϣ����Ϊ�գ�");
				
			} else if(server == null) {
				JOptionPane.showMessageDialog(null, "������δ������");
				
			}
			else {
				server.sendToClients(null, "������:"+str);
				sendText.setText("");
			}
		}
		
		if(e.getSource() == endBtn) {//�������ر�
			server.sendToClients(null, "�ر�");
			server.close();
			startBtn.setEnabled(true);
			endBtn.setEnabled(false);
			server = null;
		}
	}

	//ˢ���û��б�
	public static void reFresh() {
		user.setListData(userNames);
	}
}
