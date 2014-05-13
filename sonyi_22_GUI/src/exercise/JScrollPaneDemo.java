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
		JFrame frame = new JFrame("滚动条及文本域示例");
		frame.setLayout(null);
		frame.setBounds(200, 200, 280,250);
		
		getMessage = new JTextArea();
		getMessage.setBounds(5, 0, 250, 160);
		getMessage.setText("文本域接收信息 ");
		getMessage.setEditable(false);//不可编辑
		getMessage.setBorder(new TitledBorder("文本区域"));//设置标题
		getMessage.setLineWrap(true);//设置自动换行
		getMessage.setWrapStyleWord(true);//设置以单词为整体换行，(即不会将单词切割成两半)
		JScrollPane scrollPane = new JScrollPane(getMessage);//添加滚动条
		scrollPane.setBounds(5, 0, 250, 160);
		
		
		sendMessage = new JTextField();
		sendMessage.setBounds(5, 170, 250, 30);
		sendMessage.setText("按回车发送信息：输入的信息要够长，够多，才可以看到自动换行和滚动条，滚动条显示在末尾，即最新输入的一行中！");
		
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
					getMessage.append("\r\n信息：：" + msg);
					//每次添加信息时刷新文本区域，将滚动条显示在末尾，即显示最新一次输入
					getMessage.setCaretPosition(getMessage.getText().length());
					sendMessage.setText(null);	
				}
			}
		});
	}
}
