package sonyi.client;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WindowClient {
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
		
		JTextField textField = new JTextField();
		textField.setBounds(60, 8, 150, 30);
		window.add(textField);
		
		
		JLabel label1 = new JLabel("�˿ں�:");
		label1.setBounds(215, 8, 50, 30);
		window.add(label1);
		
		JTextField textField1 = new JTextField();
		textField1.setBounds(260, 8, 100, 30);
		window.add(textField1);
		
		JButton button1 = new JButton("����");
		button1.setBounds(370, 8, 80, 30);
		window.add(button1);
		
		JLabel label2 = new JLabel("�û��б�");
		label2.setBounds(40, 40, 80, 30);
		window.add(label2);
		
		String[] data = {"one","two","three","one","two","three",
				"one","two","one","two","two","one"};
		JList list = new JList(data);
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(10, 70, 120, 220);
		window.add(scrollPane);
		
		JTextArea textArea1 = new JTextArea();
		textArea1.setBounds(135, 70, 340, 220);
		textArea1.setText("������Ϣ����������");
		textArea1.setEditable(false);
		window.add(textArea1);
		
		JTextField textField2 = new JTextField();
		textField2.setBounds(10, 300, 360, 50);
		window.add(textField2);
		
		JButton button2 = new JButton("����");
		button2.setBounds(380, 305, 70, 40);
		window.add(button2);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
	}
}
