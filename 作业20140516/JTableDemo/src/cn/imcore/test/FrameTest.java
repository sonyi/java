package cn.imcore.test;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class FrameTest extends JFrame{

	private static final long serialVersionUID = 1L;
	JTable jTable;
	TableModel dataModel;
	JScrollPane scrollpane;
	
	public FrameTest() {
		this.setTitle("JTable≤‚ ‘");
//		dataModel = new JJTableModel();
		dataModel = new VTableModel();
		jTable = new JTable(dataModel);
		scrollpane = new JScrollPane(jTable);
      
		add(scrollpane);
		this.setBounds(100, 100, 400, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new FrameTest();

	}

}
