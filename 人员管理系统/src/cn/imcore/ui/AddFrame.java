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
		this.setTitle("��ӽ���");
		this.setLayout(new GridLayout(5,1));
		this.person = p;
		this.jTable = jTable;
		
		idPanel = new JPanel();
		namePanel = new JPanel();
		agePanel = new JPanel();
		sexPanel = new JPanel();
		btnPanel = new JPanel();
		
		idsTxt = new JLabel("id��");
		nameTxt = new JLabel("����");
		ageTxt = new JLabel("����");
		sexTxt = new JLabel("�Ա�");
		ids = new JTextField(15);
		name = new JTextField(15);
		age = new JTextField(15);
		sex = new JTextField(15);
		
		saveBtn = new JButton("����"); 
		canelBtn = new JButton("�ر�");
		saveBtn.setActionCommand("add");//
		
		saveBtn.addActionListener(this);
		canelBtn.addActionListener(this);
		
		if(person != null) {//�޸Ľ���
			this.setTitle("�޸Ľ���");
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
			//��������
			if("add".equals(e.getActionCommand())) {
				//
				JOptionPane.showMessageDialog(this, "��ӳɹ�");
				this.dispose();
				
				personManage.addPerson(createPerson());
				jTable.setModel(new JTableModel(""));
				
			}
			
			if("upd".equals(e.getActionCommand())) {
				JOptionPane.showMessageDialog(this, "�޸ĳɹ�");
				jTable.setModel(new JTableModel(""));
				this.dispose();
				personManage.updPerson(createPerson());
				jTable.setModel(new JTableModel(""));
			}
		}
		
		if(e.getSource() == canelBtn) {
			//�رյ�ǰ����
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
