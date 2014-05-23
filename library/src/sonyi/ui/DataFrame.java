package sonyi.ui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import sonyi.operation.BookDataOper;

public class DataFrame extends JFrame{
	JButton addButton,modifyButton,deleButton;
	JComboBox<String> cb;
	JTextField seText;
	JButton seButton;
	public static DefaultTableModel model;
	public static JTable table;
	public static Vector<String> names;
	public static Vector<Vector<String>> data;
	BookDataOper bdo = new BookDataOper();
	private static final long serialVersionUID = 2L;

	public DataFrame() {
		init();
	}
	
	public void init(){
		setTitle("�����б�");
		setLayout(null);
		setSize(600, 400);//�����ô�С
		setLocationRelativeTo(null);//�����þ��У����Ű�˳���кܴ��ϵ��
		
		String[] s = {"����","����","��������"};
		cb = new JComboBox<String>(s);
		cb.setBounds(80, 10, 100, 45);
		cb.setBorder(BorderFactory.createTitledBorder("��ѯ����"));
		cb.setMaximumRowCount(3);
		add(cb);
		
		seText = new JTextField();
		seText.setBounds(190, 20, 210, 34);
		add(seText);
		
		seButton = new JButton("ȷ��");
		seButton.setBounds(415, 20, 80, 34);
		add(seButton);
		
		model = new Model(getdata(), getHead());
		table = new JTable(model);
		table.setBounds(8, 65, 570, 230);
		table.getTableHeader().setReorderingAllowed(false);//�̶���
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(8, 65, 570, 230);
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
				//System.out.println("row------" + row);
				if(row == -1){
					JOptionPane.showMessageDialog(null, "û��ѡ��Ҫɾ������Ϣ");
				}else {
					int rec = JOptionPane.showConfirmDialog(null, "�Ƿ�ɾ����ѡ���У�");//����ֵ��0�����ǣ�1�����2����ȡ��
					if(rec == 0){
						
						@SuppressWarnings("unchecked")
						Vector<String> getData = (Vector<String>)DataFrame.model.getDataVector().get(row);//��ȡɾ��������
						bdo.deleteData(getData);
						DataFrame.model.removeRow(row);
						//System.out.println("row------" + row);
						for(int i = row; i < table.getRowCount(); i++){//ɾ��ʱ�ı�ɾ����֮��ı��(��ż�һ)
							DataFrame.model.setValueAt(i+1+"", i, 0);
							bdo.changeIndex(i+2);
						}
					}
				}
			}
		});
		
		seButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String comText = (String) cb.getSelectedItem();
				String sText = seText.getText();
				
				System.out.println(comText);
				System.out.println(sText);
				
				if(comText.equals("") || sText.equals("")){
					JOptionPane.showMessageDialog(null, "��ѯ����Ϊ�գ�");
				}else {
					data = bdo.getdata(comText, sText);
				}
				
			}
		});
	}
	
	public Vector<Vector<String>> getdata(){
		data = new BookDataOper().getdata(null,null);
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

class Model extends DefaultTableModel{
	private static final long serialVersionUID = 1L;
	public Model(Vector<Vector<String>> getdata,Vector<String> getHead){
		super(getdata, getHead);
	}
	@Override
	public boolean isCellEditable(int row, int column) {//�����к��� ��ѡ�е����ܱ༭
		// TODO Auto-generated method stub
		return false;
	}
	
}
