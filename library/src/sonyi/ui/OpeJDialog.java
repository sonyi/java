package sonyi.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import sonyi.data.OperateFile;
import sonyi.util.FileLoad;

public class OpeJDialog extends JDialog{
	public static JTextField bookName,auth,count;
	JButton save,exit;
	int rowSelect;
	private String title,saveText;
	private static final long serialVersionUID = 3L;
	
	
	public OpeJDialog(JFrame parent,String title,String saveText) {
		super(parent,true);
		this.title = title;
		this.saveText = saveText;
		init();
	}
	
	public void init(){
		setTitle(title);
		setLayout(null);
		setSize(400, 300);//�����ô�С
		setLocationRelativeTo(null);//�����þ��У����Ű�˳���кܴ��ϵ��
		//setBounds(200, 100, 400, 300);
		
		JLabel nameLabel = new JLabel("������");
		nameLabel.setBounds(90, 40, 60, 30);
		bookName = new JTextField();
		bookName.setBounds(140, 40, 150, 30);
		add(nameLabel);
		add(bookName);
		
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
		
		save = new JButton(saveText);
		exit = new JButton("ȡ  ��");
		save.setBounds(110, 190, 70, 30);
		exit.setBounds(210, 190, 70, 30);
		add(save);
		add(exit);
		
		if("�޸Ľ���".equals(title)){
			rowSelect = DataFrame.table.getSelectedRow();
			@SuppressWarnings("unchecked")
			Vector<String> v = (Vector<String>)DataFrame.model.getDataVector().get(rowSelect);
			System.out.println(v.get(0));
			bookName.setText(v.get(1));
			auth.setText(v.get(2));
			count.setText(v.get(3));	
		}
		
		myEvent();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);	
		
	}
	
	public void myEvent(){
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if("��ӽ���".equals(title)){
					Vector<String> v = saveMessage();
					if(v == null){
						JOptionPane.showMessageDialog(null, "��ϢΪ�ջ���Ϣ�Ѵ��ڣ����ܱ���");
					}else {
						//DataFrame.data.add(v);
						Vector<String> vec = new Vector<>();
						vec.add(DataFrame.data.size() + 1 + "");
						vec.addAll(v);
						DataFrame.model.addRow(vec);
					//	DataFrame.model.setDataVector(DataFrame.data, DataFrame.names);
						setVisible(false);
						try {
							new OperateFile().writeOperate(FileLoad.dataFile, v,true);//��ӵ��ļ�
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						}
					}
				}
				if("�޸Ľ���".equals(title)){
					rowSelect = DataFrame.table.getSelectedRow();
					@SuppressWarnings("unchecked")
					Vector<String> getData = (Vector<String>)DataFrame.model.getDataVector().get(rowSelect);
					Vector<String> vec = new Vector<>();
					for(int i = 1; i < getData.size(); i++){//ȥ�����
						vec.add(getData.get(i));
					}
					Vector<String> reviseData = saveMessage();
					if(reviseData == null){
						JOptionPane.showMessageDialog(null,"����Ϊ�ջ�δ�޸�");
					}else {
						for(int i = 0; i < reviseData.size(); i++){
							DataFrame.model.setValueAt(reviseData.get(i), rowSelect, i+1);
						}
						//DataFrame.model.removeRow(rowSelect);
						//DataFrame.model.addRow(reviseData);
						disJDiolog();
						try {
							new OperateFile().reviseFile(FileLoad.dataFile, vec, reviseData);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		
		exit.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				disJDiolog();
			}
		});
	}
	
	public void disJDiolog(){//�رնԻ���
		this.dispose();
	}
	
	public Vector<String> saveMessage(){
		String titleText = bookName.getText();
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
