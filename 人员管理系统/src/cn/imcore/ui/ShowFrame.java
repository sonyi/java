package cn.imcore.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import cn.imcore.entity.Person;
import cn.imcore.oper.JDataModel;
import cn.imcore.oper.PersonOper;
/**
 * 显示人员数据列表
 * 1.创建人员表
 * 2.加入一些数据
 * @author user
 *
 */
public class ShowFrame extends JFrame implements ActionListener{
	private JLabel searchTxt;
	private JTextField searchField;
	private JTable jList;
	private JButton addBtn, updBtn, delBtn, searchBtn;
	private JPanel northPanel, centerPanel, southPanel;
	
	private JDataModel dataModel;
	private PersonOper oper;
	
	public ShowFrame() {
		this.setTitle("显示界面");
		
		northPanel = new JPanel();
		centerPanel = new JPanel();
		southPanel = new JPanel();
		
		searchTxt = new JLabel("姓名：");
		searchField = new JTextField(15);
		addBtn = new JButton("增加");
		updBtn = new JButton("修改");
		delBtn = new JButton("删除");
		searchBtn = new JButton("查询");
		
		dataModel = new JDataModel();
		jList = new JTable(dataModel);
		JScrollPane jScrollPane = new JScrollPane(jList);
		jList.getTableHeader().setReorderingAllowed(false);
		northPanel.add(searchTxt);
		northPanel.add(searchField);
		northPanel.add(searchBtn);
		centerPanel.add(jScrollPane);
		southPanel.add(addBtn);
		southPanel.add(delBtn);
		southPanel.add(updBtn);
		
		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		
		searchBtn.addActionListener(this);
		addBtn.addActionListener(this);
		updBtn.addActionListener(this);
		
		this.setSize(600,400);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		oper = new PersonOper();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == searchBtn) {//查询
			jList.setModel(new JDataModel(searchField.getText()));
		}
		
		if(e.getSource() == addBtn) {
			new AddFrame(this, null);//弹出新增窗口
		}
		
		if(e.getSource() == updBtn) {
			int rowIndex = jList.getSelectedRow();
			if(rowIndex == -1) {
				JOptionPane.showMessageDialog(this, "请选择要修改的记录！！！");
			}
			String pId = (String) dataModel.getValueAt(rowIndex, 0);
			System.out.println("rowIndex~~~~" + rowIndex);
			Person p = oper.getPerson(Integer.parseInt(pId));
			new AddFrame(this, p);//弹出修改窗口
		}
	}

}
