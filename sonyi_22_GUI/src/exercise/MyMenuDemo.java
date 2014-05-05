package exercise;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MyMenuDemo {
	private Frame frame;
	private MenuBar mBar;
	private Menu fileMenu,submMenu;
	private MenuItem closeItem,subItem,openItem,saveItem;
	private FileDialog openDialog,saveDialog;
	private TextArea textArea;
	private File file;
	
	public MyMenuDemo() {
		init();
	}
	
	public void init() {
		frame = new Frame("my window");
		frame.setBounds(300,100,650,500);
		//frame.setLayout(new FlowLayout());
		mBar = new MenuBar();
		textArea = new TextArea();
		
		fileMenu = new Menu("文件");
		openItem = new MenuItem("打开");
		saveItem = new MenuItem("保存");
		
		submMenu = new Menu("子菜单");//Menu有子条目
		subItem = new MenuItem("子条目");//MenuItem没有子条目
		closeItem = new MenuItem("退出");
		
		submMenu.add(subItem);
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.add(submMenu);
		fileMenu.add(closeItem);
		mBar.add(fileMenu);
		
		frame.setMenuBar(mBar);
		
		openDialog = new FileDialog(frame,"我要打开",FileDialog.LOAD);
		saveDialog = new FileDialog(frame,"我要保存",FileDialog.SAVE);
		
		frame.add(textArea);
		myEvent();
		frame.setVisible(true);
		
	}
	
	private void myEvent() {
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		closeItem.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		openItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openDialog.setVisible(true);
				String dirPath = openDialog.getDirectory();
				String fileName = openDialog.getFile();
				if(dirPath == null || fileName == null)
					return;
				textArea.setText("");
				File file = new File(dirPath,fileName);
				BufferedReader buf = null;
				try {
					buf = new BufferedReader(new FileReader(file));
					String line = null;
					while ((line = buf.readLine()) != null) {
						textArea.append(line + "\r\n");
						
					}
				} catch (IOException e2) {
					throw new RuntimeException("读取失败");
				}
				finally{
					try {
						buf.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		
		
		saveItem.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				if(file == null){
					saveDialog.setVisible(true);
					String dirPath = saveDialog.getDirectory();
					String fileName = saveDialog.getFile();
					if(dirPath == null || fileName == null)
						return;
					file = new File(dirPath,fileName);
				}
				BufferedWriter bufw = null;
				try {
					bufw = new BufferedWriter(new FileWriter(file));
					String text = textArea.getText();
					bufw.write(text);
					bufw.flush();
				
				} catch (Exception e2) {
					throw new RuntimeException();
				}finally{
					try {
						bufw.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}	
			}
		});
	}
	public static void main(String[] args) {
		new MyMenuDemo();
	}	
}
