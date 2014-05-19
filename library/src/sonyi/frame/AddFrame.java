package sonyi.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import sonyi.data.OperateFile;
import sonyi.util.FileLoad;

public class AddFrame extends JFrame{
	JTextField title,auth,count;
	JButton save,exit;
	private static final long serialVersionUID = 3L;
	
	
	public AddFrame() {
		init();
	}
	
	public void init(){//��ʼ����ӽ���
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	
	}
	
	public void myEvent(){//��Ӽ�����Ϣ
		save.addActionListener(new ActionListener() {//������Ϣ
			public void actionPerformed(ActionEvent e) {
				Vector<String> v = saveMessage();//��ȡ������Ϣ
				if(v == null){
					JOptionPane.showMessageDialog(null, "��ϢΪ�ջ���Ϣ�Ѵ��ڣ����ܱ���");
				}else {
					DataFrame.model.addRow(v);//�����Ҫ�������Ϣ
					setVisible(false);//��Ӵ��ڲ��ɼ�
					try {
						new OperateFile().writeOperate(FileLoad.dataFile, v,true);//����ӵ���Ϣ��ӵ��ļ�
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "��ӳɹ�");
				}
			}
		});
		
		exit.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {//���ؽ���
				setVisible(false);
			}
		});
	}
	
	public Vector<String> saveMessage(){//��ȡ������Ϣ
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
