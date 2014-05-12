package sonyi.client;


import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WindowClient {
	JFrame window;
	public static JTextArea textArea1;
	JTextField port;
	JTextField name;
	JTextField ip;
	JButton link;
	JButton send;
	JTextField message;
	public static Socket socket = null;
	public static JList<String> user;
	public JDialog dialog;
	public JButton button = new JButton("确定");
	
	public static void main(String[] args) {
		new WindowClient();
	}
	
	public WindowClient() {
		init();
	}
	
	public void init(){
		window = new JFrame("客户端");
		window.setLayout(null);
		window.setBounds(200, 200, 500, 400);
		window.setResizable(false);
		
		JLabel label = new JLabel("主机IP:");
		label.setBounds(10, 8, 50, 30);
		window.add(label);
		
		ip = new JTextField();
		ip.setBounds(60, 8, 80, 30);
		ip.setText("127.0.0.1");
		window.add(ip);
		
		
		JLabel label1 = new JLabel("端口号:");
		label1.setBounds(150, 8, 50, 30);
		window.add(label1);
		
		port = new JTextField();
		port.setBounds(200, 8, 60, 30);
		port.setText("30000");
		window.add(port);
		
		JLabel names = new JLabel("用户名:");
		names.setBounds(270, 8, 55, 30);
		window.add(names);
		
		name = new JTextField();
		name.setBounds(315, 8, 60, 30);
		name.setText("客户端1");
		window.add(name);
		
		link = new JButton("连接");
		link.setBounds(390, 8, 80, 30);
		window.add(link);
		
		JLabel label2 = new JLabel("用户列表");
		label2.setBounds(40, 40, 80, 30);
		window.add(label2);
		
		user = new JList<String>();
		JScrollPane scrollPane = new JScrollPane(user);
		scrollPane.setBounds(10, 70, 120, 220);
		window.add(scrollPane);
		
		textArea1 = new JTextArea();
		textArea1.setBounds(135, 70, 340, 220);
		textArea1.setEditable(false);//不可编辑
		JScrollPane scrollPane1 = new JScrollPane(textArea1);//设置滚动条
		scrollPane1.setBounds(135, 70, 340, 220);
		window.add(scrollPane1);
		
		message = new JTextField();
		message.setBounds(10, 300, 360, 50);
		message.setText(null);
		window.add(message);
		
		send = new JButton("发送");
		send.setBounds(380, 305, 70, 40);
		window.add(send);
		
		myEvent();
		window.setVisible(true);
		
	}
	
	
	public void myEvent(){
		window.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				if(socket != null && socket.isConnected()){
					try {
						new SendClient(socket, getName(), 3 + "");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				System.exit(0);
			}
		});
		
		
		link.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				socket = socket();
				if(socket != null && socket.isConnected()){	
					try {
						new SendClient(socket, getName(), 2 + "");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					new Thread(new ReceiveClientThread(socket)).start();
				}	
			}
		});
		
		send.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				String messages = message.getText();
				System.out.println(messages + "------");
				if(messages == ""){
					showMessage("内容为空，请输入信息");
				}
				else if(socket != null && socket.isConnected()){
					try {
						new SendClient(socket,getName() + "：" + messages,1 + "");
						message.setText(null);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				
			}
		});	
		
		button.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(false);
			}
		});
		
	}
	

	@SuppressWarnings({ "finally", "resource" })
	public Socket socket(){
		int ports = Integer.parseInt(port.getText());
		String ipString = ip.getText();
		Socket s = null;
		//对ip和port做相应判断
		
		try {
			s = new Socket(ipString,ports);
		} catch (Exception e) {
			showMessage("Socket连接失败");
		}
		finally{
			return s;
		}
		
	}
	
	public String getName(){
		return name.getText();
	}
	
	public void showMessage(String point) {
		dialog = new JDialog(window, "提示信息",true);
		dialog.setBounds(300,300,240,100);
		dialog.setLayout(new FlowLayout());
		Label label = new Label();
		
		dialog.add(label);
		dialog.add(button);
		label.setText(point);
		dialog.setVisible(true);
	}
}
