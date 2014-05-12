package sonyi.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class WindowClient {
	JTextField port,name,ip,message;
	JButton send;
	public static JFrame window;
	public static JButton link,exit;
	public static JTextArea textMessage;
	public static Socket socket = null;
	public static JList<String> user;
	
	//���������
	public static void main(String[] args) {
		new WindowClient();
	}
	
	//��ʼ������
	public WindowClient() {
		init();
	}
	
	//�����ʼ������
	public void init(){//���þ��Բ���
		window = new JFrame("�ͻ���");
		window.setLayout(null);
		window.setBounds(200, 200, 500, 400);
		window.setResizable(false);
		
		JLabel label = new JLabel("����IP:");
		label.setBounds(10, 8, 50, 30);
		window.add(label);
		
		ip = new JTextField();
		ip.setBounds(55, 8, 60, 30);
		ip.setText("127.0.0.1");
		window.add(ip);
		
		
		JLabel label1 = new JLabel("�˿ں�:");
		label1.setBounds(125, 8, 50, 30);
		window.add(label1);
		
		port = new JTextField();
		port.setBounds(170, 8, 40, 30);
		port.setText("30000");
		window.add(port);
		
		JLabel names = new JLabel("�û���:");
		names.setBounds(220, 8, 55, 30);
		window.add(names);
		
		name = new JTextField();
		name.setBounds(265, 8, 60, 30);
		name.setText("�ͻ���1");
		window.add(name);
		
		link = new JButton("����");
		link.setBounds(335, 8, 75, 30);
		window.add(link);
		
		exit = new JButton("�˳�");
		exit.setBounds(415, 8, 75, 30);
		window.add(exit);
		
		JLabel label2 = new JLabel("�û��б�");
		label2.setBounds(40, 40, 80, 30);
		window.add(label2);
		
		user = new JList<String>();
		JScrollPane scrollPane = new JScrollPane(user);//���ù�����
		scrollPane.setBounds(10, 70, 120, 220);
		window.add(scrollPane);
		
		textMessage = new JTextArea();
		textMessage.setBounds(135, 70, 340, 220);
		textMessage.setEditable(false);//�ı����ɱ༭
		textMessage.setBorder(new TitledBorder("�����¼"));//���ñ���
		//�ı����ݻ��е�������Ҫ�������
		textMessage.setLineWrap(true);//�����ı������Զ����У��ڳ����ı�����ʱ�����ܻ��жϵ���
		textMessage.setWrapStyleWord(true);//�������Զ����У��Ե���Ϊ���壬��֤���ʲ��ᱻ�ж�
		JScrollPane scrollPane1 = new JScrollPane(textMessage);//���ù�����
		scrollPane1.setBounds(135, 70, 340, 220);
		window.add(scrollPane1);
		
		message = new JTextField();
		message.setBounds(10, 300, 360, 50);
		message.setText(null);
		window.add(message);
		
		send = new JButton("����");
		send.setBounds(380, 305, 70, 40);
		window.add(send);
		
		myEvent();//��Ӽ����¼�
		window.setVisible(true);//���ô���ɼ�	
	}
	
	
	public void myEvent(){//�¼�����
		window.addWindowListener(new WindowAdapter() {//�˳�����
			public void windowClosing(WindowEvent e){
				//����������ӣ�����Ϣ������ˣ����˳�
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
		
		//�ر�����
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//����������ӣ�����Ϣ���������
				if(socket == null){
					JOptionPane.showMessageDialog(window, "�ѹر�����");
				}else if(socket != null && socket.isConnected()){
					try {
						new SendClient(socket, getName(), "3");//������Ϣ�������
						link.setText("����");
						exit.setText("���˳�");
						socket.close();//�ر�socket
						socket = null;
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		//��������
		link.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				//�ж��Ƿ��Ѿ����ӳɹ�
				if(socket != null && socket.isConnected()){	
					JOptionPane.showMessageDialog(window, "�Ѿ����ӳɹ���");
				}else {
					String ipString = ip.getText();//��ȡip��ַ
					String portClinet = port.getText();//��ȡ�˿ں�
					
					if("".equals(ipString) || "".equals(portClinet)){//�жϻ�ȡ�����Ƿ�Ϊ��
						JOptionPane.showMessageDialog(window, "ip��˿ں�Ϊ�գ�");
					}else {
						try {
							int ports = Integer.parseInt(portClinet);//���˿ں�תΪ����
							socket = new Socket(ipString,ports);//��������
							link.setText("������");//����button��ʾ��Ϣ
							exit.setText("�˳�");
							new SendClient(socket, getName(), 2 + "");//���͸ÿͻ���������������
							new Thread(new ReceiveClient(socket)).start();//���������߳�
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(window, "����δ�ɹ���������ip��˿ںŸ�ʽ���ԣ��������δ������");
						}
					}
				}
			}
		});
		
		//�����ť������Ϣ
		send.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				sendMsg();
			}
		});	
		
		//���س�������Ϣ
		message.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					sendMsg();
				}
			}
		});
	}
	
	//������Ϣ�ķ���
	public void sendMsg(){
		String messages = message.getText();//��ȡ�ı�������
		if("".equals(messages)){//�ж���Ϣ�Ƿ�Ϊ��
			JOptionPane.showMessageDialog(window, "���ݲ���Ϊ�գ�");
		}
		else if(socket == null || !socket.isConnected()){//�ж��Ƿ��Ѿ����ӳɹ�
			JOptionPane.showMessageDialog(window, "δ���ӳɹ������ܷ�����Ϣ��");
		}else {
			try {
				//������Ϣ
				new SendClient(socket,getName() + "��" + messages,"1");
				message.setText(null);//�ı�����������Ϊ��
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(window, "��Ϣ����ʧ�ܣ�");
			}
		}	
	}
	
	//��ȡ�ͻ�������
	public String getName(){
		return name.getText();
	}
}
