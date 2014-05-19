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
	
	public void init(){//初始化数据类别界面
		setTitle("数据列表");
		setLayout(null);
		setBounds(200, 100, 400, 300);
		
		model = new DefaultTableModel(getdata(), getHead());//设置表格类型
		table = new JTable(model);
		table.setBounds(8, 5, 370, 180);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(8, 5, 370, 180);
		add(scrollPane);
		
		addButton = new JButton("添加");
		reviseButton = new JButton("修改");
		deleButton = new JButton("删除");
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
	
	public void myEvent(){//设置监听事件
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//开启添加界面
				new AddFrame();
			}
		});
		
		reviseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//开启修改界面
				int row = table.getSelectedRow();//获取当前列表的选中行
				if(row == -1){
					JOptionPane.showMessageDialog(null, "没有选中要修改的信息");
				}else {
					@SuppressWarnings("unchecked")
					Vector<String> v = (Vector<String>)model.getDataVector().get(row);//获取当前行的信息
					new ReviseFrame();//开启修改界面
					ReviseFrame.title.setText(v.get(0));//将当前行信息赋值到修改界面窗口中
					ReviseFrame.auth.setText(v.get(1));
					ReviseFrame.count.setText(v.get(2));	
				}
			}
		});
		
		deleButton.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {//删除信息
				int row = table.getSelectedRow();//获取当前选中行
				if(row == -1){
					JOptionPane.showMessageDialog(null, "没有选中要修改的信息");
				}else {
					int i = JOptionPane.showConfirmDialog(null, "是否确定删除该信息");//返回信息：0代表是，1代表否，2代表取消
					if(i == 0){
						@SuppressWarnings("unchecked")
						Vector<String> getData = (Vector<String>)DataFrame.model.getDataVector().get(row);//获取选中行信息
						DataFrame.model.removeRow(row);//删除后台信息中该行信息
						try {
							new OperateFile().reviseFile(FileLoad.dataFile, getData, null);//删除数据库中该行信息
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
	}
	
	public Vector<Vector<String>> getdata(){//获取数据库中数据信息
		try {
			data = new OperateFile().readOperate(FileLoad.dataFile);//读取文件信息
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public Vector<String> getHead(){//获取表头信息
		names = new Vector<String>();
		names.add("书名");
		names.add("作者");
		names.add("藏书数量");
		return names;
	}
}
