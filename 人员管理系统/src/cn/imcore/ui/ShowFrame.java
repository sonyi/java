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
 * ��ʾ��Ա�����б�
 * 1.������Ա��
 * 2.����һЩ����
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
		this.setTitle("��ʾ����");
		
		northPanel = new JPanel();
		centerPanel = new JPanel();
		southPanel = new JPanel();
		
		searchTxt = new JLabel("������");
		searchField = new JTextField(15);
		addBtn = new JButton("����");
		updBtn = new JButton("�޸�");
		delBtn = new JButton("ɾ��");
		searchBtn = new JButton("��ѯ");
		
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
		if(e.getSource() == searchBtn) {//��ѯ
			jList.setModel(new JDataModel(searchField.getText()));
		}
		
		if(e.getSource() == addBtn) {
			new AddFrame(this, null);//������������
		}
		
		if(e.getSource() == updBtn) {
			int rowIndex = jList.getSelectedRow();
			if(rowIndex == -1) {
				JOptionPane.showMessageDialog(this, "��ѡ��Ҫ�޸ĵļ�¼������");
			}
			String pId = (String) dataModel.getValueAt(rowIndex, 0);
			System.out.println("rowIndex~~~~" + rowIndex);
			Person p = oper.getPerson(Integer.parseInt(pId));
			new AddFrame(this, p);//�����޸Ĵ���
		}
	}

}
