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
		setSize(600, 400);//先设置大小
		setLocationRelativeTo(null);//再设置居中，（排版顺序有很大关系）
		
		model = new DefaultTableModel(getdata(), getHead());
		table = new JTable(model);
		table.setBounds(8, 5, 570, 280);
		table.getTableHeader().setReorderingAllowed(false);//固定列
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(8, 5, 570, 280);
		add(scrollPane);
		
		addButton = new JButton("添加");
		modifyButton = new JButton("修改");
		deleButton = new JButton("删除");
		addButton.setBounds(160, 300, 70, 30);
		modifyButton.setBounds(260, 300, 70, 30);
		deleButton.setBounds(360, 300, 70, 30);
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
				new OpeJDialog(null,"添加界面","保存");
				
			}
		});
		
		modifyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row == -1){
					JOptionPane.showMessageDialog(null, "没有选中要修改的信息");
				}else {
					new OpeJDialog(null,"修改界面","修改");
				}
			}
		});
		
		deleButton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row == -1){
					JOptionPane.showMessageDialog(null, "没有选中要删除的信息");
				}else {
					int rec = JOptionPane.showConfirmDialog(null, "是否删除该选中行！");//返回值：0代表是，1代表否，2代表取消
					if(rec == 0){
						for(int i = row+1; i < table.getRowCount(); i++){//删除时改变删除行之后的编号(编号减一)
							DataFrame.model.setValueAt(i, i, 0);
						}
						@SuppressWarnings("unchecked")
						Vector<String> getData = (Vector<String>)DataFrame.model.getDataVector().get(row);//获取删除行内容
						Vector<String> delData = new Vector<>();
						for(int i = 1; i < getData.size(); i++){//去掉编号
							delData.add(getData.get(i));
						}
						DataFrame.model.removeRow(row);
						try {
							new OperateFile().reviseFile(FileLoad.dataFile, delData, null);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
	}
	
	public Vector<Vector<String>> getdata(){
		data = new Vector<Vector<String>>();
		int index = 1;
		try {
			Vector<Vector<String>> vdata = new OperateFile().readOperate(FileLoad.dataFile);
			for(Vector<String> v : vdata){
				Vector<String> vec = new Vector<>();
				vec.add((index++) + "");
				vec.addAll(v);
				data.add(vec);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public Vector<String> getHead(){
		names = new Vector<String>();
		names.add("编号");
		names.add("书名");
		names.add("作者");
		names.add("藏书数量");
		return names;
	}
}
