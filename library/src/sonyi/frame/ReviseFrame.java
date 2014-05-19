package sonyi.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import sonyi.data.OperateFile;
import sonyi.util.FileLoad;

public class ReviseFrame extends JFrame{
	private static final long serialVersionUID = 4L;
	public static JTextField title,auth,count;
	JButton revise,exit;
	
	public ReviseFrame() {
		init();
	}
	
	public void init(){//��ʼ���޸Ľ���
		setTitle("�޸Ľ���");
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
		
		revise = new JButton("��  ��");
		exit = new JButton("ȡ  ��");
		revise.setBounds(110, 190, 70, 30);
		exit.setBounds(210, 190, 70, 30);
		add(revise);
		add(exit);
		
		myEvent();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void myEvent(){//��Ӽ�����Ϣ
		revise.addActionListener(new ActionListener() {//�������
			public void actionPerformed(ActionEvent e) {
				int row = DataFrame.table.getSelectedRow();//��ȡ��Ҫ�޸ĵĵ�ǰѡ����
				@SuppressWarnings("unchecked")
				Vector<String> getData = (Vector<String>)DataFrame.model.getDataVector().get(row);//��ȡѡ������Ϣ
				Vector<String> reviseData = rev();//��ȡ�޸���Ϣ
				if(reviseData == null){
					JOptionPane.showMessageDialog(null,"����Ϊ�ջ�δ�޸�");
				}else {
					
					DataFrame.model.removeRow(row);//�Ƴ����޸ĵ���
					DataFrame.model.addRow(reviseData);//����޸ĺ����
					setVisible(false);//�޸Ľ��治�ɼ�
					try {
						new OperateFile().reviseFile(FileLoad.dataFile, getData, reviseData);//���޸ĺ����Ϣд���ļ���
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
				}
			}
		});
		
		exit.addActionListener(new ActionListener() {//�޸Ľ��治�ɼ�
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}
	
	public Vector<String> rev(){//��ȡ�޸Ľ�����Ϣ
		String titleText = title.getText();
		String authText = auth.getText();
		String countText = count.getText();//δ�ж������ʽ�Ƿ���ȷ
		Vector<String> al = new Vector<>();
		al.add(titleText);
		al.add(authText);
		al.add(countText);
		if("".equals(titleText) || "".equals(authText) || "".equals(countText)){//�ж���Ϣ�Ƿ�Ϊ��
			return null;
		}else if(DataFrame.data.contains(al)){//�ж���Ϣ�Ƿ��Ѿ����������У����Ƿ�δ�޸Ļ��������ظ���
			return null;
		}else {
			return al;//���ظ��������Ϣ	
		}
	}
}
