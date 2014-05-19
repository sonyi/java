package cn.imcore.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import cn.imcore.entity.Person;
import cn.imcore.manage.DataList;
import cn.imcore.manage.JTableModel;
import cn.imcore.manage.PersonManage;

public class ShowFrame extends JFrame implements ActionListener{
	
	private JTable jTable;
	private TableModel tableModel;
	private JScrollPane jScrollPane;
	private JButton addButton, updButton, delButton, searchButton; 
	private static final int NO_SELECTED = -1;
	private PersonManage personManage;
	private JTextField searchField;
	private JLabel searchTxt;
	
	public ShowFrame() {
		
		this.setTitle("数据界面");
		
		JPanel northJP = new JPanel();
//		tableModel = new DataList();
		tableModel = new JTableModel();
		
		jTable = new JTable(tableModel);
		jScrollPane = new JScrollPane(jTable);
		
		jTable.getTableHeader().setReorderingAllowed(false);
		
		JPanel southJP = new JPanel();
		
		searchTxt = new JLabel("姓名：");
		searchField = new JTextField(20);
		
		addButton = new JButton("添加");
		updButton = new JButton("修改");
		delButton = new JButton("删除");
		searchButton = new JButton("查询");
		
		addButton.addActionListener(this);
		updButton.addActionListener(this);
		delButton.addActionListener(this);
		searchButton.addActionListener(this);
		
		northJP.add(searchTxt);
		northJP.add(searchField);
		northJP.add(searchButton);
		
		southJP.add(addButton);
		southJP.add(updButton);
		southJP.add(delButton);
		
		add(northJP, BorderLayout.NORTH);
		add(jScrollPane,BorderLayout.CENTER);
		add(southJP,BorderLayout.SOUTH);
		
		personManage = new PersonManage();
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addButton) {
			new AddFrame(this,jTable, null);
		}
		
		if(e.getSource() == updButton) {
			int row = jTable.getSelectedRow();
			System.out.println(row+"~~~~~~~~");
			if(row != NO_SELECTED) {
				Object datas = tableModel.getValueAt(row, 0);
				System.out.println(datas);
				
				new AddFrame(this, jTable, personManage.getPerson((Integer)datas));
			} else {
				JOptionPane.showMessageDialog(this, "请选择修改的记录！");
			}
		}
		
		if(e.getSource() == delButton) {
			int row = jTable.getSelectedRow();
			if(row != NO_SELECTED) {
				//1.调用删除方法 2.刷新数据列表
				int ids = (Integer) tableModel.getValueAt(row, 0);				
				personManage.delPerson(ids);
				jTable.setModel(new JTableModel(""));
			} else {
				JOptionPane.showMessageDialog(this, "请选择要删除的记录！");
			}
		}
	}
	


}
