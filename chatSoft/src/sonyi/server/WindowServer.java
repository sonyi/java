package sonyi.server;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class WindowServer {
	public static JFrame window;
	public static JTextArea textMessage;//�����¼
	public static JList<String> user;//�û��б�
	public static int ports;
	JButton start,send,exit;
	JTextField portServer,message,name;
	
	//���������
	public static void main(String[] args) {
		new WindowServer();
	}

	//��ʼ������
	public WindowServer() {
		init();
	}
	
	//��ʼ������
	public void init(){//���þ��Բ���
		window = new JFrame("�����");
		window.setLayout(null);
		window.setBounds(200, 200, 500, 400);
		window.setResizable(false);//���ɸı��С
		
		JLabel label1 = new JLabel("�˿ں�:");
		label1.setBounds(10, 8, 50, 30);
		window.add(label1);
		
		portServer = new JTextField();
		portServer.setBounds(60, 8, 100, 30);
		portServer.setText("30000");
		window.add(portServer);
		
		JLabel names = new JLabel("�û���:");
		names.setBounds(180, 8, 55, 30);
		window.add(names);
		
		name = new JTextField();
		name.setBounds(230, 8, 60, 30);
		name.setText("�����");
		window.add(name);
		
		start = new JButton("����");
		start.setBounds(300, 8, 80, 30);
		window.add(start);
		
		exit = new JButton("�ر�");
		exit.setBounds(390, 8, 80, 30);
		window.add(exit);
		
		
		JLabel label2 = new JLabel("�û��б�");
		label2.setBounds(40, 40, 80, 30);
		window.add(label2);
		
		
		user = new JList<String>();
		JScrollPane scrollPane = new JScrollPane(user);//��ӹ�����
		scrollPane.setBounds(10, 70, 120, 220);
		window.add(scrollPane);
		
		textMessage = new JTextArea();
		textMessage.setBounds(135, 70, 340, 220);
		textMessage.setBorder(new TitledBorder("�����¼"));//���ñ���
		textMessage.setEditable(false);//���ɱ༭
		//�ı����ݻ��е�������Ҫ�������
		textMessage.setLineWrap(true);//�����ı������Զ����У��ڳ����ı�����ʱ�����ܻ��жϵ���
		textMessage.setWrapStyleWord(true);//�������Զ����У��Ե���Ϊ���壬��֤���ʲ��ᱻ�ж�
		JScrollPane scrollPane1 = new JScrollPane(textMessage);//���ù�����
		scrollPane1.setBounds(135, 70, 340, 220);
		window.add(scrollPane1);
		
		message = new JTextField();
		message.setBounds(10, 300, 360, 50);
		
		window.add(message);
		
		send = new JButton("����");
		send.setBounds(380, 305, 70, 40);
		window.add(send);
		
		myEvent();	//��Ӽ����¼�
		window.setVisible(true);
	}
	
	public void myEvent(){
		window.addWindowListener(new WindowAdapter() {//�رմ���
			public void windowClosing(WindowEvent e){
				//����пͻ��˴��ڣ�����Ϣ���ͻ��ˣ����˳�
				if(StartServer.userList != null && StartServer.userList.size() != 0){
					try {
						new SendServer(StartServer.userList, "" , "4");//4���������˳�
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				System.exit(0);//�˳�����
			}
		});
		
		exit.addActionListener(new ActionListener() {	//�˳�����
			public void actionPerformed(ActionEvent e) {
				if(StartServer.ss == null || StartServer.ss.isClosed()){//������˳�����������
					JOptionPane.showMessageDialog(window, "�������ѹر�");
				}else {
					//����Ϣ���߿ͻ��ˣ�Ҫ�˳�
					if(StartServer.userList != null && StartServer.userList.size() != 0){
						try {
							new SendServer(StartServer.userList, "" , 4 + "");	
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
					try {
						start.setText("����");
						exit.setText("�ѹر�");
						StartServer.ss.close();//�رշ����
						StartServer.ss = null;
						StartServer.userList = null;
						StartServer.flag = false;//�ı�����ѭ�����
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}	
			}
		});
		
		//���������
		start.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				//���������Ѿ��������������ѷ�����ѿ���
				if(StartServer.ss != null && !StartServer.ss.isClosed()){
					JOptionPane.showMessageDialog(window, "�������Ѿ�����");
				}else {
					ports = getPort();//��ȡ�˿ں�
					if(ports != 0){
						try {
							StartServer.flag = true;//�ı����˽���ѭ�����
							new Thread(new StartServer(ports)).start(); //��������˽����߳�
							start.setText("������");
							exit.setText("�ر�");
						} catch (IOException e1) {
							JOptionPane.showMessageDialog(window, "����ʧ��");
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
	
	//������Ϣ����
	public void sendMsg(){
		String messages = message.getText();
		//�ж������Ƿ�Ϊ��
		if("".equals(messages)){
			JOptionPane.showMessageDialog(window, "���ݲ���Ϊ�գ�");
		}else if(StartServer.userList == null || StartServer.userList.size() == 0){//�ж��Ƿ��Ѿ����ӳɹ�
			JOptionPane.showMessageDialog(window, "δ���ӳɹ������ܷ�����Ϣ��");
		}else {
			try {
				//����Ϣ���͸����пͻ���
				new SendServer(StartServer.userList, getName() + "��" + messages, 1 + "");
				//����Ϣ��ӵ��ͻ��������¼��
				WindowServer.textMessage.append(getName() + "��" + messages + "\r\n");
				message.setText(null);//��Ϣ������Ϊ��
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(window, "����ʧ�ܣ�");
			}
		}
	}
	
	//��ȡ�˿ں�
	public int getPort(){
		String port = portServer.getText();
		if("".equals(port)){//�ж϶˿ں��Ƿ�Ϊ��
			JOptionPane.showMessageDialog(window, "�˿ں�Ϊ��");
			return 0;
		}else {
			return Integer.parseInt(port);//�������εĶ˿ں�
		}	
	}	
	
	//��ȡ���������
	public String getName(){
		return name.getText();
	}
}


