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
		setSize(400, 300);//先设置大小
		setLocationRelativeTo(null);//再设置居中，（排版顺序有很大关系）
		
		JLabel nameLabel = new JLabel("书名：");
		nameLabel.setBounds(90, 40, 60, 30);
		bookName = new JTextField();
		bookName.setBounds(140, 40, 150, 30);
		add(nameLabel);
		add(bookName);
		
		JLabel authName = new JLabel("作者：");
		authName.setBounds(90, 90, 60, 30);
		auth = new JTextField();
		auth.setBounds(140, 90, 150, 30);
		add(authName);
		add(auth);
		
		JLabel countName = new JLabel("藏书：");
		countName.setBounds(90, 140, 60, 30);
		count = new JTextField();
		count.setBounds(140, 140, 150, 30);
		add(countName);
		add(count);
		
		save = new JButton(saveText);
		exit = new JButton("取  消");
		save.setBounds(110, 190, 70, 30);
		exit.setBounds(210, 190, 70, 30);
		add(save);
		add(exit);
		
		if(title.equals("修改界面")){//将要修改的选中行信息添加到对话框中
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
				if(title.equals("添加界面")){
					Vector<String> v = getMessage();//接收添加信息
					Vector<Vector<String>> data = DataFrame.data;
					boolean flag = false;
					if(v != null){
						for(int i = 0; i < DataFrame.data.size(); i++){//判断是否已经存在于数据中
							if(data.get(i).get(1).equals(v.get(0)) && data.get(i).get(2).equals(v.get(1))
									&& data.get(i).get(3).equals(v.get(2))){
								flag = true;
								break;
							}
						}

						if (flag) {
							JOptionPane.showMessageDialog(null, "内容已经存在");
						}else {
							v.add(0,DataFrame.data.size() + 1 + "");//添加编号，
							DataFrame.model.addRow(v);//添加到容器中
							bdo.insertData(v);//添加到数据库中
							disJDiolog();//关闭对话框
						}
					}
				}
				
				if(title.equals("修改界面")){
					row = DataFrame.table.getSelectedRow();
					Vector<String> v = getMessage();
					if(v != null){
						//System.out.println(reviseData);
						v.add(0,row + 1 + "");
						if (DataFrame.data.contains(v)) {//判断是否修改
							JOptionPane.showMessageDialog(null, "内容未修改");
						}else {
							for(int i = 0; i < v.size(); i++){//修改容器中内容
								DataFrame.model.setValueAt(v.get(i), row, i);
							}
							//System.out.println(reviseData);
							bdo.updateData(v);//修改数据库中的内容
							disJDiolog();//关闭对话框
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
	
	public void disJDiolog(){//关闭对话框
		this.dispose();
	}
	
	public Vector<String> getMessage(){
		String titleText = bookName.getText();
		String authText = auth.getText();
		String countText = count.getText();
		
		if(titleText.length() >45 || authText.length() > 25 || countText.length() > 20){//判断输入信息是否够长
			JOptionPane.showMessageDialog(null, "输入信息超长");
			return null;
		}
		
		try {
			int i = Integer.parseInt(countText);//判断输入格式是否正确
			if(i < 0){
				JOptionPane.showMessageDialog(null, "藏书不能为负数！");
				return null;
			}
		} catch (Exception e) {		
			JOptionPane.showMessageDialog(null, "藏书必须为数字，输入有误！");
			return null;
		}
		
		Vector<String> al = new Vector<>();
		al.add(titleText);
		al.add(authText);
		al.add(countText);
		if(titleText.equals("") || authText.equals("") || countText.equals("")){
			JOptionPane.showMessageDialog(null,"内容为空！");
			return null;
		}else {
			return al;//返回添加信息	
		}
	}
}
