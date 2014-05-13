package exercise;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class JScrollPaneDemo {
	JTextField sendMessage;
	JTextArea getMessage;
	public static void main(String[] args) {
		new JScrollPaneDemo().frameInit();
	}
	
	public void frameInit() {
		JFrame frame = new JFrame("���������ı���ʾ��");
		frame.setLayout(null);
		frame.setBounds(200, 200, 280,250);
		
		getMessage = new JTextArea();
		getMessage.setBounds(5, 0, 250, 160);
		getMessage.setText("�ı��������Ϣ ");
		getMessage.setEditable(false);//���ɱ༭
		getMessage.setBorder(new TitledBorder("�ı�����"));//���ñ���
		getMessage.setLineWrap(true);//�����Զ�����
		getMessage.setWrapStyleWord(true);//�����Ե���Ϊ���廻�У�(�����Ὣ�����и������)
		JScrollPane scrollPane = new JScrollPane(getMessage);//��ӹ�����
		scrollPane.setBounds(5, 0, 250, 160);
		
		
		sendMessage = new JTextField();
		sendMessage.setBounds(5, 170, 250, 30);
		sendMessage.setText("���س�������Ϣ���������ϢҪ���������࣬�ſ��Կ����Զ����к͹���������������ʾ��ĩβ�������������һ���У�");
		
		frame.add(scrollPane);
		frame.add(sendMessage);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myEvent();
		frame.setVisible(true);
	}
	
	public void myEvent(){
		sendMessage.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					String msg = sendMessage.getText();
					getMessage.append("\r\n��Ϣ����" + msg);
					//ÿ�������Ϣʱˢ���ı����򣬽���������ʾ��ĩβ������ʾ����һ������
					getMessage.setCaretPosition(getMessage.getText().length());
					sendMessage.setText(null);	
				}
			}
		});
	}
}
