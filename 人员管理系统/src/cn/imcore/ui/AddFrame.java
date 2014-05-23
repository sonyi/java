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
import javax.swing.JTextField;

import cn.imcore.entity.Person;
import cn.imcore.oper.PersonOper;

public class AddFrame extends JDialog implements ActionListener{
	private PersonOper oper;
	private JLabel nameTxt, ageTxt, sexTxt, addrTxt;
	private JTextField name, age, sex, addr;
	private JButton saveBtn, canelBtn;
	private JPanel namePanel, agePanel, sexPanel, addrPanel, btnPanel;
	
	public AddFrame(JFrame parent, Person p) {
		super(parent, true);
		
		this.setTitle("��������");
		this.setLayout(new GridLayout(5,1));
		namePanel = new JPanel();
		agePanel = new JPanel();
		sexPanel = new JPanel();
		addrPanel = new JPanel();
		btnPanel = new JPanel();
		
		nameTxt = new JLabel("����:");
		ageTxt = new JLabel("����:");
		sexTxt = new JLabel("�Ա�:");
		addrTxt = new JLabel("��ַ:");
		
		name = new JTextField(15);
		age = new JTextField(15);
		sex = new JTextField(15);
		addr = new JTextField(15);
		
		saveBtn = new JButton("����");
		canelBtn = new JButton("ȡ��");
		saveBtn.addActionListener(this);
		saveBtn.setActionCommand("add");
		
		if(p != null) {//�޸�
			this.setTitle("�޸Ľ���");
			name.setText(p.getpName());
			age.setText(p.getpAge());
			sex.setText(p.getpSex());
			addr.setText(p.getpAddr());
			saveBtn.setActionCommand("upd");
		}
		
		namePanel.add(nameTxt);
		namePanel.add(name);
		agePanel.add(ageTxt);
		agePanel.add(age);
		sexPanel.add(sexTxt);
		sexPanel.add(sex);
		addrPanel.add(addrTxt);
		addrPanel.add(addr);
		btnPanel.add(saveBtn);
		btnPanel.add(canelBtn);
		
		add(namePanel);
		add(agePanel);
		add(sexPanel);
		add(addrPanel);
		add(btnPanel);
		
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if("add".equals(e.getActionCommand())) {
			JOptionPane.showMessageDialog(this, "�����ɹ�������");
		}
		if("upd".equals(e.getActionCommand())) {
			JOptionPane.showMessageDialog(this, "�޸ĳɹ�������");
		}
	}

}
