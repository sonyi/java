package ��Ŀ2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Test {
	JButton start,end;
	JTextField name;
	public static boolean flag = false;
	public static void main(String[] args) {
		new Test();
	}

	public Test() {
		init();
	}
	
	public void init(){
		JFrame frame = new JFrame("����ϵͳ");
		frame.setBounds(200, 200, 300, 200);
		frame.setLayout(null);
		
		name = new JTextField();
		name.setBounds(100, 20, 90, 40);
		frame.add(name);
		
		start = new JButton("��ʼ����");
		start.setBounds(35, 80, 100, 40);
		frame.add(start);
		
		end = new JButton("�㵽˭��");
		end.setBounds(145, 80, 100, 40);
		frame.add(end);
		
		myEvent();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void myEvent(){
		start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!flag){
					flag = true;
					new GetName().start();
				}
			}
		});
		
		end.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				flag = false;
			}
		});
	}
	
	class GetName extends Thread {
		String[] n = {"����","����","����","����","����","С��","С��","С��","С��","С��","С��"};
		public void run(){
			while(flag){
				for(String s : n){
					System.out.println(s);
					name.setText(s);
					if(!flag){
						break;
					}
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
