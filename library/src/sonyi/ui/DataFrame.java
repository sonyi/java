package sonyi.ui;
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
	JButton addButton,modifyButton,deleButton;
	public static DefaultTableModel model;
	public static JTable table;
	public static Vector<String> names;
	public static Vector<Vector<String>> data;
	private static final long serialVersionUID = 2L;

	public DataFrame() {
		init();
	}
	
	public void init(){
		setTitle("�����б�");
		setLayout(null);
		setSize(600, 400);//�����ô�С
		setLocationRelativeTo(null);//�����þ��У����Ű�˳���кܴ��ϵ��
		
		model = new DefaultTableModel(getdata(), getHead());
		table = new JTable(model);
		table.setBounds(8, 5, 570, 280);
		table.getTableHeader().setReorderingAllowed(false);//�̶���
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(8, 5, 570, 280);
		add(scrollPane);
		
		addButton = new JButton("���");
		modifyButton = new JButton("�޸�");
		deleButton = new JButton("ɾ��");
		addButton.setBounds(160, 300, 70, 30);
		modifyButton.setBounds(260, 300, 70, 30);
		deleButton.setBounds(360, 300, 70, 30);
		add(addButton);
		add(modifyButton);
		add(deleButton);
		
		myEvent();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void myEvent(){
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new OpeJDialog(null,"��ӽ���","����");
				
			}
		});
		
		modifyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row == -1){
					JOptionPane.showMessageDialog(null, "û��ѡ��Ҫ�޸ĵ���Ϣ");
				}else {
					new OpeJDialog(null,"�޸Ľ���","�޸�");
				}
			}
		});
		
		deleButton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row == -1){
					JOptionPane.showMessageDialog(null, "û��ѡ��Ҫɾ������Ϣ");
				}else {
					int rec = JOptionPane.showConfirmDialog(null, "�Ƿ�ɾ����ѡ���У�");//����ֵ��0�����ǣ�1�����2����ȡ��
					if(rec == 0){
						for(int i = row+1; i < table.getRowCount(); i++){//ɾ��ʱ�ı�ɾ����֮��ı��(��ż�һ)
							DataFrame.model.setValueAt(i, i, 0);
						}
						@SuppressWarnings("unchecked")
						Vector<String> getData = (Vector<String>)DataFrame.model.getDataVector().get(row);//��ȡɾ��������
						Vector<String> delData = new Vector<>();
						for(int i = 1; i < getData.size(); i++){//ȥ�����
							delData.add(getData.get(i));
						}
						DataFrame.model.removeRow(row);
						try {
							new OperateFile().reviseFile(FileLoad.dataFile, delData, null);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
	}
	
	public Vector<Vector<String>> getdata(){
		data = new Vector<Vector<String>>();
		int index = 1;
		try {
			Vector<Vector<String>> vdata = new OperateFile().readOperate(FileLoad.dataFile);
			for(Vector<String> v : vdata){
				Vector<String> vec = new Vector<>();
				vec.add((index++) + "");
				vec.addAll(v);
				data.add(vec);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public Vector<String> getHead(){
		names = new Vector<String>();
		names.add("���");
		names.add("����");
		names.add("����");
		names.add("��������");
		return names;
	}
}
