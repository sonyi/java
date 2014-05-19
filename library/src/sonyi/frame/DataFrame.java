package sonyi.frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import sonyi.data.OperateFile;
import sonyi.util.FileLoad;

public class DataFrame extends JFrame{
	public static DefaultTableModel model;
	public static JTable table;
	public static Vector<String> names;
	public static Vector<Vector<String>> data;
	JButton addButton,reviseButton,deleButton;
	private static final long serialVersionUID = 2L;

	public DataFrame() {
		init();
	}
	
	public void init(){//��ʼ������������
		setTitle("�����б�");
		setLayout(null);
		setBounds(200, 100, 400, 300);
		
		model = new DefaultTableModel(getdata(), getHead());//���ñ������
		table = new JTable(model);
		table.setBounds(8, 5, 370, 180);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(8, 5, 370, 180);
		add(scrollPane);
		
		addButton = new JButton("���");
		reviseButton = new JButton("�޸�");
		deleButton = new JButton("ɾ��");
		addButton.setBounds(70, 200, 70, 30);
		reviseButton.setBounds(170, 200, 70, 30);
		deleButton.setBounds(270, 200, 70, 30);
		add(addButton);
		add(reviseButton);
		add(deleButton);
		
		myEvent();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void myEvent(){//���ü����¼�
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//������ӽ���
				new AddFrame();
			}
		});
		
		reviseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//�����޸Ľ���
				int row = table.getSelectedRow();//��ȡ��ǰ�б��ѡ����
				if(row == -1){
					JOptionPane.showMessageDialog(null, "û��ѡ��Ҫ�޸ĵ���Ϣ");
				}else {
					@SuppressWarnings("unchecked")
					Vector<String> v = (Vector<String>)model.getDataVector().get(row);//��ȡ��ǰ�е���Ϣ
					new ReviseFrame();//�����޸Ľ���
					ReviseFrame.title.setText(v.get(0));//����ǰ����Ϣ��ֵ���޸Ľ��洰����
					ReviseFrame.auth.setText(v.get(1));
					ReviseFrame.count.setText(v.get(2));	
				}
			}
		});
		
		deleButton.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {//ɾ����Ϣ
				int row = table.getSelectedRow();//��ȡ��ǰѡ����
				if(row == -1){
					JOptionPane.showMessageDialog(null, "û��ѡ��Ҫ�޸ĵ���Ϣ");
				}else {
					int i = JOptionPane.showConfirmDialog(null, "�Ƿ�ȷ��ɾ������Ϣ");//������Ϣ��0�����ǣ�1�����2����ȡ��
					if(i == 0){
						@SuppressWarnings("unchecked")
						Vector<String> getData = (Vector<String>)DataFrame.model.getDataVector().get(row);//��ȡѡ������Ϣ
						DataFrame.model.removeRow(row);//ɾ����̨��Ϣ�и�����Ϣ
						try {
							new OperateFile().reviseFile(FileLoad.dataFile, getData, null);//ɾ�����ݿ��и�����Ϣ
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
	}
	
	public Vector<Vector<String>> getdata(){//��ȡ���ݿ���������Ϣ
		try {
			data = new OperateFile().readOperate(FileLoad.dataFile);//��ȡ�ļ���Ϣ
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public Vector<String> getHead(){//��ȡ��ͷ��Ϣ
		names = new Vector<String>();
		names.add("����");
		names.add("����");
		names.add("��������");
		return names;
	}
}
