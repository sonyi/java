package gui;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MouseAndKeyEvent {
	private Frame frame;
	private Button button;
	private TextField textField;
	public MouseAndKeyEvent() {
		init();
	}
	
	public void init(){//��ʼ������
		frame = new Frame("my Frame");
		frame.setBounds(300,100,600,500);
		frame.setLayout(new FlowLayout());
		button = new Button("my Button");
		textField = new TextField(20);
		frame.add(textField);
		frame.add(button);
		myEvent();
		frame.setVisible(true);	
	}
	
	public void myEvent(){//�����¼�
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		button.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e){
				System.out.println("����������");
			}
			
			public void mouseClicked(MouseEvent e){
				if(e.getClickCount() == 2)
					System.out.println("���˫��");
			}
		});
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("��ťaction");
			}
		});
		
		button.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e){
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
					System.exit(0);
				System.out.println(e.getKeyChar() + "-------" + e.getKeyCode());
				if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_ENTER)
					System.out.println("ctrl + enter is run");
			}
		});
		
		textField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e){
				int code = e.getKeyCode();
				if(!(code >= KeyEvent.VK_0 && code <= KeyEvent.VK_9)){
					System.out.println(code + "------�ǷǷ���");
					e.consume();//������������ϣ��¼����ᰴ��Ĭ�Ϸ�������(ȡ���¼�)
				}
			}
		});	
	}
	
	public static void main(String[] args) {
		new MouseAndKeyEvent();
	}
}
