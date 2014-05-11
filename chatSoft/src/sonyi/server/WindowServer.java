package sonyi.server;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WindowServer {
	JFrame window;
	public static JTextArea textMessage;
	JButton startButton;
	JButton send;
	JTextField portServer;
	JTextField message;
	JTextField name;
	public static JList<String> user;
	
	public static int ports;
	
	
	public static void main(String[] args) {
		new WindowServer();
	}

	public WindowServer() {
		init();
	}
	
	public void init(){
		window = new JFrame("�����");
		window.setLayout(null);
		window.setBounds(200, 200, 500, 400);
		window.setResizable(false);
		
		JLabel label1 = new JLabel("�˿ں�:");
		label1.setBounds(10, 8, 50, 30);
		window.add(label1);
		
		portServer = new JTextField();
		portServer.setBounds(60, 8, 100, 30);
		portServer.setText("30000");
		window.add(portServer);
		
		JLabel names = new JLabel("�ǳ�:");
		names.setBounds(180, 8, 45, 30);
		window.add(names);
		
		name = new JTextField();
		name.setBounds(220, 8, 60, 30);
		name.setText("�����");
		window.add(name);
		
		startButton = new JButton("����");
		startButton.setBounds(300, 8, 80, 30);
		window.add(startButton);
		
		JLabel label2 = new JLabel("�û��б�");
		label2.setBounds(40, 40, 80, 30);
		window.add(label2);
		
		
		user = new JList<String>();
		JScrollPane scrollPane = new JScrollPane(user);
		
		scrollPane.setBounds(10, 70, 120, 220);
		window.add(scrollPane);
		
		textMessage = new JTextArea();
		textMessage.setBounds(135, 70, 340, 220);
//		textMessage.setText("������Ϣ����������");
		textMessage.setEditable(false);
		JScrollPane scrollPane1 = new JScrollPane(textMessage);//���ù�����
		scrollPane1.setBounds(135, 70, 340, 220);
		window.add(scrollPane1);
		
		message = new JTextField();
		message.setBounds(10, 300, 360, 50);
		window.add(message);
		
		send = new JButton("����");
		send.setBounds(380, 305, 70, 40);
		window.add(send);
		
		myEvent();	
		window.setVisible(true);
	}
	
	public void myEvent(){
		window.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				if(StartServer.userList != null && StartServer.userList.size() != 0){
					try {
						new SendServer(StartServer.userList, "" , 4 + "");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				System.exit(0);
			}
		});
		
		startButton.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				ports = getPort();
				try {
					new Thread(new StartServer(ports)).start(); 
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String messages = message.getText();
				try {
					new SendServer(StartServer.userList, getName() + "��" + messages, 1 + "");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				WindowServer.textMessage.append(getName() + "��" + messages + "\r\n");
				message.setText(null);
			}
		});
	}
	
	public int getPort(){
		String port = portServer.getText();
		if(port == null)
			System.out.println("�˿ڲ���Ϊ��");
		
		return Integer.parseInt(port);
	}	
	
	public String getName(){
		return name.getText();
	}
}


