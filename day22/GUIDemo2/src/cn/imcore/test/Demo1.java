package cn.imcore.test;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Demo1 extends JFrame implements ActionListener{
	static Demo1 frame;
	
	private JButton welcome,dat;
	private JLabel jl1;
	private JTextField jTextField;
	
	public Demo1() {
		JPanel northPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		JPanel southPanel = new JPanel();
		
		jl1 = new JLabel("等待中。。。。。");
		jTextField = new JTextField(15);
		
		welcome = new JButton("欢迎");
		dat = new JButton("显示时间");
		
		//给按钮加监听
		welcome.addActionListener(this);
		dat.addActionListener(this);
//		dat.setActionCommand("日期");
		
		centerPanel.add(jl1);
		northPanel.add(jTextField);
		
		southPanel.add(welcome);
		southPanel.add(dat);
		
		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		
		setBounds(200, 200, 400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		frame = new Demo1();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == welcome) {
			if("".equals(jTextField.getText())) {
				JOptionPane.showMessageDialog(null, "请填写信息");
				
			} else {
				jl1.setText(jTextField.getText() + "欢迎光临");
			}
		}
		
		if(e.getSource() == dat) {
			Calendar cal = Calendar.getInstance();
			jl1.setText(cal.getTime().toString());
		}
		
//		if("日期".equals(e.getActionCommand())) {
//			System.out.println("date........");
//		}
	}

}
