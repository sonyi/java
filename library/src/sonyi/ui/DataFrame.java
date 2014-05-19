package sonyi.ui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import sonyi.data.OperateFile;
import sonyi.util.FileLoad;

public class DataFrame extends JFrame{
	JButton addButton,modifyButton,deleButton;
	public static DefaultTableModel model;
	public static JTable table;
	
	public static Vector<String> names;
	public static Vector<Vector<String>> data;
	private static final long serialVersionUID = 2L;

	public DataFrame() {
		init();
	}
	
	public void init(){
		setTitle("数据列表");
		setLayout(null);
		setBounds(200, 100, 400, 300);
		
		model = new DefaultTableModel(getdata(), getHead());
		
		table = new JTable(model);
		table.setBounds(8, 5, 370, 180);
		table.getTableHeader().setReorderingAllowed(false);//固定列
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(8, 5, 370, 180);
		add(scrollPane);
		
		addButton = new JButton("添加");
		modifyButton = new JButton("修改");
		deleButton = new JButton("删除");
		addButton.setBounds(70, 200, 70, 30);
		modifyButton.setBounds(170, 200, 70, 30);
		deleButton.setBounds(270, 200, 70, 30);
		add(addButton);
		add(modifyButton);
		add(deleButton);
		
		myEvent();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void myEvent(){
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddFrame();
			}
		});
		
		modifyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row == -1){
					JOptionPane.showMessageDialog(null, "没有选中要修改的信息");
				}else {
					@SuppressWarnings("unchecked")
					Vector<String> v = (Vector<String>)model.getDataVector().get(row);
					System.out.println(v.get(0));
					new ReviseFrame();
					ReviseFrame.title.setText(v.get(0));
					ReviseFrame.auth.setText(v.get(1));
					ReviseFrame.count.setText(v.get(2));	
				}
			}
		});
		
		deleButton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row == -1){
					JOptionPane.showMessageDialog(null, "没有选中要修改的信息");
				}else {
					@SuppressWarnings("unchecked")
					Vector<String> getData = (Vector<String>)DataFrame.model.getDataVector().get(row);
					DataFrame.model.removeRow(row);
					try {
						new OperateFile().reviseFile(FileLoad.dataFile, getData, null);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
	}
	
	public Vector<Vector<String>> getdata(){
		try {
			data = new OperateFile().readOperate(FileLoad.dataFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public Vector<String> getHead(){
		names = new Vector<String>();
		names.add("书名");
		names.add("作者");
		names.add("藏书数量");
		return names;
	}
}
