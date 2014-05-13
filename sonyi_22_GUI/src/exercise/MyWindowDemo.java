package exercise;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

public class MyWindowDemo {
	private Frame frame;
	private TextField tField;
	private Button button;
	private TextArea tArea;
	private Button b;
	private Dialog d;
	public MyWindowDemo() {
		inti();
	}
	
	public void inti(){
		frame = new Frame("my window");
		frame.setBounds(300,100,600,500);
		frame.setLayout(new FlowLayout());
		tField = new TextField(60);
		button = new Button("ת��");
		b = new Button("ȷ��");
		tArea = new TextArea(25,70);
		
		frame.add(tField);
		frame.add(button);
		frame.add(tArea);
		myEvent();
		frame.setVisible(true);
	}
	
	private void myEvent(){
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
//		d.addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent e){
//				d.setVisible(false);
//			}
//		});
		
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				showdir();			
			}	
		});
		
		tField.addKeyListener(new KeyAdapter() {//�س������¼�
			public void keyPressed(KeyEvent e){
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					showdir();
				}
			}	
		});
		
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				d.setVisible(false);
			}
		});
	}
	
	private void showdir(){
		String dirPath = tField.getText();//��ȡ�ı���Ϣ
		File dir = new File(dirPath);
		if(dir.exists() && dir.isDirectory()){
			String[] names = dir.list();
			for(String name : names){
				tArea.append(name + "\r\n");
			}
			tField.setText(null);
		}
		else {
			d = new Dialog(frame, "��ʾ��Ϣ--self",true);//�Զ��嵯����Ϣ
			d.setBounds(400,200,240,100);
			d.setLayout(new FlowLayout());
			Label label = new Label();
			
			d.add(label);
			d.add(b);
			label.setText("���������Ϣ��"+ dirPath +"��������������");
			d.setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		new MyWindowDemo();
	}
}
