package sonyi.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import sonyi.data.OperateFile;
import sonyi.util.FileLoad;

public class AddFrame extends JDialog{
	JTextField title,auth,count;
	JButton save,exit;
	private static final long serialVersionUID = 3L;
	
	
	public AddFrame() {
		init();
	}
	
	public void init(){
		setTitle("��ӽ���");
		setLayout(null);
		setBounds(200, 100, 400, 300);
		
		JLabel nameLabel = new JLabel("������");
		nameLabel.setBounds(90, 40, 60, 30);
		title = new JTextField();
		title.setBounds(140, 40, 150, 30);
		add(nameLabel);
		add(title);
		
		JLabel authName = new JLabel("���ߣ�");
		authName.setBounds(90, 90, 60, 30);
		auth = new JTextField();
		auth.setBounds(140, 90, 150, 30);
		add(authName);
		add(auth);
		
		JLabel countName = new JLabel("���飺");
		countName.setBounds(90, 140, 60, 30);
		count = new JTextField();
		count.setBounds(140, 140, 150, 30);
		add(countName);
		add(count);
		
		save = new JButton("��  ��");
		exit = new JButton("ȡ  ��");
		save.setBounds(110, 190, 70, 30);
		exit.setBounds(210, 190, 70, 30);
		add(save);
		add(exit);
		
		myEvent();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);	
	}
	
	public void myEvent(){
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Vector<String> v = saveMessage();
				if(v == null){
					JOptionPane.showMessageDialog(null, "��ϢΪ�ջ���Ϣ�Ѵ��ڣ����ܱ���");
				}else {
					//DataFrame.data.add(v);
					DataFrame.model.addRow(v);
				//	DataFrame.model.setDataVector(DataFrame.data, DataFrame.names);
					setVisible(false);
					try {
						new OperateFile().writeOperate(FileLoad.dataFile, v,true);//��ӵ��ļ�
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		exit.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				
			}
		});
	}
	
	public Vector<String> saveMessage(){
		String titleText = title.getText();
		String authText = auth.getText();
		String countText = count.getText();//δ�ж������ʽ�Ƿ���ȷ
		Vector<String> al = new Vector<>();
		al.add(titleText);
		al.add(authText);
		al.add(countText);
		if("".equals(titleText) || "".equals(authText) || "".equals(countText)){
			return null;
		}else if(DataFrame.data.contains(al)){
			return null;
		}else {
			return al;//���ظ��������Ϣ	
		}
	}
}
