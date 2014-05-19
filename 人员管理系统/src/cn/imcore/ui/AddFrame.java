package cn.imcore.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import cn.imcore.entity.Person;
import cn.imcore.manage.JTableModel;
import cn.imcore.manage.PersonManage;

public class AddFrame extends JDialog implements ActionListener{
	private JLabel idsTxt, nameTxt, ageTxt, sexTxt;
	private JTextField ids, name, age, sex;
	private JButton saveBtn, canelBtn;
	private JPanel idPanel, namePanel, agePanel, sexPanel, btnPanel;
	
	private Person person;
	private JTable jTable;
	PersonManage personManage;
	
	public AddFrame(JFrame parent, JTable jTable, Person p) {
		super(parent, true);
		this.setTitle("添加界面");
		this.setLayout(new GridLayout(5,1));
		this.person = p;
		this.jTable = jTable;
		
		idPanel = new JPanel();
		namePanel = new JPanel();
		agePanel = new JPanel();
		sexPanel = new JPanel();
		btnPanel = new JPanel();
		
		idsTxt = new JLabel("id号");
		nameTxt = new JLabel("姓名");
		ageTxt = new JLabel("年龄");
		sexTxt = new JLabel("性别");
		ids = new JTextField(15);
		name = new JTextField(15);
		age = new JTextField(15);
		sex = new JTextField(15);
		
		saveBtn = new JButton("保存"); 
		canelBtn = new JButton("关闭");
		saveBtn.setActionCommand("add");//
		
		saveBtn.addActionListener(this);
		canelBtn.addActionListener(this);
		
		if(person != null) {//修改界面
			this.setTitle("修改界面");
			saveBtn.setActionCommand("upd");//
			
			ids.setText(String.valueOf(person.getIds()));
			name.setText(person.getName());
			age.setText(String.valueOf(person.getAge()));
			sex.setText(person.getSex());
		}
		idPanel.add(idsTxt);
		idPanel.add(ids);
		namePanel.add(nameTxt);
		namePanel.add(name);
		agePanel.add(ageTxt);
		agePanel.add(age);
		sexPanel.add(sexTxt);
		sexPanel.add(sex);
		btnPanel.add(saveBtn);
		btnPanel.add(canelBtn);
		
		add(idPanel);
		add(namePanel);
		add(agePanel);
		add(sexPanel);
		add(btnPanel);
		personManage = new PersonManage();
		
		this.setSize(400,300);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == saveBtn) {
			//保存数据
			if("add".equals(e.getActionCommand())) {
				//
				JOptionPane.showMessageDialog(this, "添加成功");
				this.dispose();
				
				personManage.addPerson(createPerson());
				jTable.setModel(new JTableModel(""));
				
			}
			
			if("upd".equals(e.getActionCommand())) {
				JOptionPane.showMessageDialog(this, "修改成功");
				jTable.setModel(new JTableModel(""));
				this.dispose();
				personManage.updPerson(createPerson());
				jTable.setModel(new JTableModel(""));
			}
		}
		
		if(e.getSource() == canelBtn) {
			//关闭当前界面
			this.dispose();
		}
	}

	public Person createPerson() {
		Person p = new Person();
		p.setIds(Integer.parseInt(ids.getText()));
		p.setName(name.getText());
		p.setAge(Integer.parseInt(age.getText()));
		p.setSex(sex.getText());
		return p;
	}
}
