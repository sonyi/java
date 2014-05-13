package sonyi.exercise;

import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class LoginExercise {
	public static void main(String[] args) {
		new FrameDemo();
	}
}

class FrameDemo {
	JFrame frame;
	JButton jButton1,jButton2;
	public FrameDemo() {
		frame = new JFrame("登入界面");
		frame.setLayout(new FlowLayout());
		frame.setBounds(300, 200, 250, 300);
		
		JPanel jP1 = new JPanel();
		Label label1 = new Label("用户名:");
		TextField tField1 = new TextField(20);
		jP1.add(label1);
		jP1.add(tField1);
		
		JPanel jP2 = new JPanel();
		Label label2 = new Label("密   码:");
		JPasswordField jPasswordField = new JPasswordField(14);
		jP2.add(label2);
		jP2.add(jPasswordField);
		
		JPanel jP3 = new JPanel();
		JLabel label3 = new JLabel("备   注:");
		label3.setVerticalAlignment(SwingConstants.TOP);
		
		TextArea tArea = new TextArea(4,20);
		jP3.add(label3);
		jP3.add(tArea);
		
		JPanel jP4 = new JPanel();
		Checkbox checkbox = new Checkbox("已经阅读条款，并同意条款内容");
		jP4.add(checkbox);
		
		JPanel jP5 = new JPanel();
		jButton1 = new JButton("确定");
		jButton2 = new JButton("取消");
		jP5.add(jButton1);
		jP5.add(jButton2);
		
		frame.add(jP1);
		frame.add(jP2);
		frame.add(jP3);
		frame.add(jP4);
		frame.add(jP5);
		myEvent();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
	public void myEvent() {
		jButton1.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "测试弹窗，没有链接信息");//弹窗信息
			}
		});
	}
}