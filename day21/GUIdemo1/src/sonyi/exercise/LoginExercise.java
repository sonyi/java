package sonyi.exercise;

import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class LoginExercise {
	public static void main(String[] args) {
		new FrameDemo();
	}

}

class FrameDemo {
	public FrameDemo() {
		JFrame frame = new JFrame("�������");
		frame.setLayout(new FlowLayout());
		frame.setBounds(300, 200, 250, 300);
		
		JPanel jP1 = new JPanel();
		Label label1 = new Label("�û���:");
		TextField tField1 = new TextField(20);
		jP1.add(label1);
		jP1.add(tField1);
		
		JPanel jP2 = new JPanel();
		Label label2 = new Label("��   ��:");
		JPasswordField jPasswordField = new JPasswordField(14);
		//TextField tField2 = new TextField(20);
		jP2.add(label2);
		jP2.add(jPasswordField);
		
		JPanel jP3 = new JPanel();
		JLabel label3 = new JLabel("��   ע:");
		label3.setVerticalAlignment(SwingConstants.TOP);
		//System.out.println(label3.getAlignment());
		
		TextArea tArea = new TextArea(4,20);
		jP3.add(label3);
		jP3.add(tArea);
		
		JPanel jP4 = new JPanel();
		Checkbox checkbox = new Checkbox("�Ѿ��Ķ������ͬ����������");
		jP4.add(checkbox);
		
		JPanel jP5 = new JPanel();
		JButton jButton1 = new JButton("ȷ��");
		JButton jButton2 = new JButton("ȡ��");
		jP5.add(jButton1);
		jP5.add(jButton2);
		
		frame.add(jP1);
		frame.add(jP2);
		frame.add(jP3);
		frame.add(jP4);
		frame.add(jP5);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
}