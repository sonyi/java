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
	
	public void init(){//初始化修改界面
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void myEvent(){//添加监听信息
		revise.addActionListener(new ActionListener() {//保存监听
			public void actionPerformed(ActionEvent e) {
				int row = DataFrame.table.getSelectedRow();//获取需要修改的当前选中行
				@SuppressWarnings("unchecked")
				Vector<String> getData = (Vector<String>)DataFrame.model.getDataVector().get(row);//获取选中行信息
				Vector<String> reviseData = rev();//获取修改信息
				if(reviseData == null){
					JOptionPane.showMessageDialog(null,"内容为空或未修改");
				}else {
					
					DataFrame.model.removeRow(row);//移除需修改的行
					DataFrame.model.addRow(reviseData);//添加修改后的行
					setVisible(false);//修改界面不可见
					try {
						new OperateFile().reviseFile(FileLoad.dataFile, getData, reviseData);//将修改后的信息写入文件中
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "修改成功");
				}
			}
		});
		
		exit.addActionListener(new ActionListener() {//修改界面不可见
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}
	
	public Vector<String> rev(){//获取修改界面信息
		String titleText = title.getText();
		String authText = auth.getText();
		String countText = count.getText();//未判断输入格式是否正确
		Vector<String> al = new Vector<>();
		al.add(titleText);
		al.add(authText);
		al.add(countText);
		if("".equals(titleText) || "".equals(authText) || "".equals(countText)){//判断信息是否为空
			return null;
		}else if(DataFrame.data.contains(al)){//判断信息是否已经存在内容中（即是否未修改或与其他重复）
			return null;
		}else {
			return al;//返回该添加行信息	
		}
	}
}
