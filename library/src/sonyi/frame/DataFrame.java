package sonyi.frame;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import sonyi.data.LibraryData;

public class DataFrame extends JFrame{
	JButton addButton,reviseButton;
	private static final long serialVersionUID = 2L;

	public DataFrame() {
		init();
	}
	
	public void init(){
		setTitle("数据列表");
		setLayout(null);
		setBounds(200, 100, 400, 300);
		
		TableModel model = new LibraryData();
		JTable table = new JTable(model);
		table.setBounds(8, 5, 370, 180);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(8, 5, 370, 180);
		add(scrollPane);
		
		addButton = new JButton("添加");
		reviseButton = new JButton("修改");
		addButton.setBounds(170, 200, 70, 30);
		reviseButton.setBounds(270, 200, 70, 30);
		add(addButton);
		add(reviseButton);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
