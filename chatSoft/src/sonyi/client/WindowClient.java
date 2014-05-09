package sonyi.client;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WindowClient {
	public static JTextArea textArea1;
	JTextField port;
	JTextField name;
	JTextField ip;
	JButton link;
	JButton send;
	JTextField message;
	public static Socket socket;
	
	public static void main(String[] args) {
		new WindowClient();
	}
	
	public WindowClient() {
		init();
	}
	
	public void init(){
		JFrame window = new JFrame("�ͻ���");
		window.setLayout(null);
		window.setBounds(200, 200, 500, 400);
		window.setResizable(false);
		
		JLabel label = new JLabel("����IP:");
		label.setBounds(10, 8, 50, 30);
		window.add(label);
		
		ip = new JTextField();
		ip.setBounds(60, 8, 80, 30);
		ip.setText("127.0.0.1");
		window.add(ip);
		
		
		JLabel label1 = new JLabel("�˿ں�:");
		label1.setBounds(150, 8, 50, 30);
		window.add(label1);
		
		port = new JTextField();
		port.setBounds(200, 8, 60, 30);
		port.setText("30000");
		window.add(port);
		
		JLabel names = new JLabel("�ǳ�:");
		names.setBounds(270, 8, 45, 30);
		window.add(names);
		
		name = new JTextField();
		name.setBounds(305, 8, 60, 30);
		name.setText("�ͻ���1");
		window.add(name);
		
		link = new JButton("����");
		link.setBounds(380, 8, 80, 30);
		window.add(link);
		
		JLabel label2 = new JLabel("�û��б�");
		label2.setBounds(40, 40, 80, 30);
		window.add(label2);
		
		String[] data = {"one","two","three","one","two","three",
				"one","two","one","two","two","one"};
		JList<String> list = new JList<String>(data);
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(10, 70, 120, 220);
		window.add(scrollPane);
		
		textArea1 = new JTextArea();
		textArea1.setBounds(135, 70, 340, 220);
//		textArea1.setText("������Ϣ����������");
		textArea1.setEditable(false);//���ɱ༭
		JScrollPane scrollPane1 = new JScrollPane(textArea1);//���ù�����
		scrollPane1.setBounds(135, 70, 340, 220);
		window.add(scrollPane1);
		
		message = new JTextField();
		message.setBounds(10, 300, 360, 50);
		window.add(message);
		
		send = new JButton("����");
		send.setBounds(380, 305, 70, 40);
		window.add(send);
		
		myEvent();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
	}
	
	
	public void myEvent(){
		
		link.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				socket = socket();
			
				new Thread(new ReceiveClientThread(socket)).start();
//				try {
//					new SendClient(socket, getName());//����ʱ�����ͻ����ǳƷ��͸������
//				} catch (IOException e1) {
//					e1.printStackTrace();
//				}
			}
		});
		
		send.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				String messages = message.getText();
				try {
					new SendClient(socket,getName() + "��" + messages);
					message.setText(null);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});	
	}
	
	public Socket socket(){
		int ports = Integer.parseInt(port.getText());
		String ipString = ip.getText();
		Socket s = null;
		try {
			s = new Socket(ipString,ports);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	public String getName(){
		return name.getText();
	}
}
