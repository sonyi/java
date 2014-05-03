package gui;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
	创建图形化界面：
		1、创建frame窗体
		2、对窗体进行基本设置。比如：大小、位置、布局
		3、定义组件
		4、将组件通过窗体的add方法添加到窗体中
		5、让窗体显示，通过setVisible(true)
		
	事件监听机制的特点：
		1、事件源：就是awt包或者swing包中的那些图形界面组件
		2、事件：每一个事件源都有自己特有的对应事件和共性事件
		3、监听器：将可以触发某一个事件的动作(不止一个动作)都已经封装到了监听器中
		4、事件处理：我们要做的事情就是对产生的动作进行处理
			1、2、3点java都应经定义好了，直接获取其对象来用就可以
 */
public class AWTDemo {
	public static void main(String[] args) {
		Frame f = new Frame("my awt");
		f.setSize(500, 400);
		f.setLocation(300,200);
		f.setLayout(new FlowLayout());
		Button b = new Button("我是一个按钮");
		f.add(b);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.out.println("关闭窗体");
				System.exit(0);
			}
		});
		f.setVisible(true);
	}

}
