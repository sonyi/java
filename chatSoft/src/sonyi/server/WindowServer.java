package sonyi.server;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WindowServer {
	public static void main(String[] args) {
		new WindowServer();
	}
	
	JButton button1;
	JButton button2;
	
	public WindowServer() {
		init();
	}
	
	public void init(){
		JFrame window = new JFrame("服务端");
		window.setLayout(null);
		window.setBounds(200, 200, 500, 400);
		window.setResizable(false);
		
		JLabel label1 = new JLabel("端口号:");
		label1.setBounds(10, 8, 50, 30);
		window.add(label1);
		
		JTextField textField1 = new JTextField();
		textField1.setBounds(60, 8, 120, 30);
		window.add(textField1);
		
		button1 = new JButton("启动");
		button1.setBounds(300, 8, 80, 30);
		window.add(button1);
		
		JLabel label2 = new JLabel("用户列表");
		label2.setBounds(40, 40, 80, 30);
		window.add(label2);
		
		String[] data = {"one","two","three","one","two","three","one",
				"two","one","two","one","two"};
		JList list = new JList(data);
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(10, 70, 120, 220);
		window.add(scrollPane);
		
		JTextArea textArea1 = new JTextArea();
		textArea1.setBounds(135, 70, 340, 220);
		textArea1.setText("接收信息，不能输入");
		textArea1.setEditable(false);
		window.add(textArea1);
		
		JTextField textField2 = new JTextField();
		textField2.setBounds(10, 300, 360, 50);
		window.add(textField2);
		
		button2 = new JButton("发送");
		button2.setBounds(380, 305, 70, 40);
		window.add(button2);
		
		myEvent();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
	
	public void myEvent(){
//		button1.addActionListener();
//		button2.addActionListener();
	}
	
}
