package sonyi.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import sonyi.operation.BookDataOper;

public class OpeJDialog extends JDialog{
	public static JTextField bookName,auth,count;
	JButton save,exit;
	int row;
	private String title,saveText;
	BookDataOper bdo = new BookDataOper();
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
		
		if(title.equals("�޸Ľ���")){//��Ҫ�޸ĵ�ѡ������Ϣ��ӵ��Ի�����
			row = DataFrame.table.getSelectedRow();
			@SuppressWarnings("unchecked")
			Vector<String> v = (Vector<String>)DataFrame.model.getDataVector().get(row);
			//System.out.println(v.get(0));
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
				if(title.equals("��ӽ���")){
					Vector<String> v = getMessage();//���������Ϣ
					Vector<Vector<String>> data = DataFrame.data;
					boolean flag = false;
					if(v != null){
						for(int i = 0; i < DataFrame.data.size(); i++){//�ж��Ƿ��Ѿ�������������
							if(data.get(i).get(1).equals(v.get(0)) && data.get(i).get(2).equals(v.get(1))
									&& data.get(i).get(3).equals(v.get(2))){
								flag = true;
								break;
							}
						}

						if (flag) {
							JOptionPane.showMessageDialog(null, "�����Ѿ�����");
						}else {
							v.add(0,DataFrame.data.size() + 1 + "");//��ӱ�ţ�
							DataFrame.model.addRow(v);//��ӵ�������
							bdo.insertData(v);//��ӵ����ݿ���
							disJDiolog();//�رնԻ���
						}
					}
				}
				
				if(title.equals("�޸Ľ���")){
					row = DataFrame.table.getSelectedRow();
					Vector<String> v = getMessage();
					if(v != null){
						//System.out.println(reviseData);
						v.add(0,row + 1 + "");
						if (DataFrame.data.contains(v)) {//�ж��Ƿ��޸�
							JOptionPane.showMessageDialog(null, "����δ�޸�");
						}else {
							for(int i = 0; i < v.size(); i++){//�޸�����������
								DataFrame.model.setValueAt(v.get(i), row, i);
							}
							//System.out.println(reviseData);
							bdo.updateData(v);//�޸����ݿ��е�����
							disJDiolog();//�رնԻ���
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
	
	public Vector<String> getMessage(){
		String titleText = bookName.getText();
		String authText = auth.getText();
		String countText = count.getText();
		
		if(titleText.length() >45 || authText.length() > 25 || countText.length() > 20){//�ж�������Ϣ�Ƿ񹻳�
			JOptionPane.showMessageDialog(null, "������Ϣ����");
			return null;
		}
		
		try {
			int i = Integer.parseInt(countText);//�ж������ʽ�Ƿ���ȷ
			if(i < 0){
				JOptionPane.showMessageDialog(null, "���鲻��Ϊ������");
				return null;
			}
		} catch (Exception e) {		
			JOptionPane.showMessageDialog(null, "�������Ϊ���֣���������");
			return null;
		}
		
		Vector<String> al = new Vector<>();
		al.add(titleText);
		al.add(authText);
		al.add(countText);
		if(titleText.equals("") || authText.equals("") || countText.equals("")){
			JOptionPane.showMessageDialog(null,"����Ϊ�գ�");
			return null;
		}else {
			return al;//���������Ϣ	
		}
	}
}
