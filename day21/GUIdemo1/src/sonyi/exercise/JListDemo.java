package sonyi.exercise;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class JListDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new JListDemo().list();
		
		
	}
	
	public void list(){
		JFrame frame = new JFrame();
		frame.setLayout(new FlowLayout(FlowLayout.LEFT));
		frame.setBounds(300, 200, 300, 300);
		String[] data = {"one","two","three","one","two","three","one","two","three","one","two","three"};
		JList<String> list = new JList<String>(data);	
		JScrollPane sp = new JScrollPane(list);
		
		
		
		frame.add(sp);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void titledBorder(){
		JFrame frame = new JFrame();
		frame.setLayout(new FlowLayout(FlowLayout.LEFT));
		frame.setBounds(300, 200, 300, 300);
		
		TitledBorder tb = new TitledBorder(new EmptyBorder(10,10,10,10));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
}
