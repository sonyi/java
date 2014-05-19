package sonyi.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import sonyi.data.OperateFile;
import sonyi.util.FileLoad;

public class ReviseFrame extends JDialog{
	public static JTextField title,auth,count;
	JButton revise,exit;
	private static final long serialVersionUID = 4L;
	
	public ReviseFrame() {
		init();
	}
	
	public void init(){
		setTitle("修改界面");
		setLayout(null);
		setBounds(200, 100, 400, 300);
		
		JLabel nameLabel = new JLabel("书名：");
		nameLabel.setBounds(90, 40, 60, 30);
		title = new JTextField();
		title.setBounds(140, 40, 150, 30);
		add(nameLabel);
		add(title);
		
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
		
		revise = new JButton("修  改");
		exit = new JButton("取  消");
		revise.setBounds(110, 190, 70, 30);
		exit.setBounds(210, 190, 70, 30);
		add(revise);
		add(exit);
		
		myEvent();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	public void myEvent(){	
		revise.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = DataFrame.table.getSelectedRow();
				@SuppressWarnings("unchecked")
				Vector<String> getData = (Vector<String>)DataFrame.model.getDataVector().get(row);
				Vector<String> reviseData = rev();
				if(reviseData == null){
					JOptionPane.showMessageDialog(null,"内容为空或未修改");
				}else {
					DataFrame.model.removeRow(row);
					DataFrame.model.addRow(reviseData);
					setVisible(false);
					try {
						new OperateFile().reviseFile(FileLoad.dataFile, getData, reviseData);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}
	
	public Vector<String> rev(){
		String titleText = title.getText();
		String authText = auth.getText();
		String countText = count.getText();//未判断输入格式是否正确
		Vector<String> al = new Vector<>();
		al.add(titleText);
		al.add(authText);
		al.add(countText);
		if("".equals(titleText) || "".equals(authText) || "".equals(countText)){
			return null;
		}else if(DataFrame.data.contains(al)){
			return null;
		}else {
			return al;//返回该添加行信息	
		}
	}
}
