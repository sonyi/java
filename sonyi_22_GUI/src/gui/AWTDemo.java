package gui;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
	����ͼ�λ����棺
		1������frame����
		2���Դ�����л������á����磺��С��λ�á�����
		3���������
		4�������ͨ�������add������ӵ�������
		5���ô�����ʾ��ͨ��setVisible(true)
		
	�¼��������Ƶ��ص㣺
		1���¼�Դ������awt������swing���е���Щͼ�ν������
		2���¼���ÿһ���¼�Դ�����Լ����еĶ�Ӧ�¼��͹����¼�
		3���������������Դ���ĳһ���¼��Ķ���(��ֹһ������)���Ѿ���װ���˼�������
		4���¼���������Ҫ����������ǶԲ����Ķ������д���
			1��2��3��java��Ӧ��������ˣ�ֱ�ӻ�ȡ��������þͿ���
 */
public class AWTDemo {
	public static void main(String[] args) {
		Frame f = new Frame("my awt");
		f.setSize(500, 400);
		f.setLocation(300,200);
		f.setLayout(new FlowLayout());
		Button b = new Button("����һ����ť");
		f.add(b);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.out.println("�رմ���");
				System.exit(0);
			}
		});
		f.setVisible(true);
	}

}
