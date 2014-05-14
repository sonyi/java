package sonyi.frame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Windows {
	JFrame window;
	JButton[][] button;
	JTextField upView,downView;
	double sum;
	String oldOperator = "",newOperator = "";
	public static void main(String[] args) {
		new Windows();
	}
	
	public Windows() {
		init();
	}
	
	public void init(){
		window = new JFrame("计算器");
		window.setResizable(false);
		window.setLayout(null);
		window.setBounds(200, 200, 316, 330);
		
		JPanel view = new JPanel();
		view.setLayout(null);
		view.setBounds(7, 10, 285, 60);
		upView = new JTextField();
		upView.setBounds(0, 0, 285, 30);
		upView.setText("");
		downView = new JTextField();
		downView.setBounds(0, 29, 285, 30);
		downView.setText("0");
		view.add(upView);
		view.add(downView);
		
		JPanel operate = new JPanel(new GridLayout(5,5,4,3));
		operate.setBounds(5, 80, 290, 200);
		
		//operate.setBackground(Color.cyan);
		button = new JButton[5][5];
		String[][] lable = {{"←","CE","C","±","√"},{"7","8","9","/","%"},{"4","5","6","*","1/x"},{"1","2","3","-",""},{"0","",".","+","="}};
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 5; j++){
				button[i][j] = new JButton(lable[i][j]);
				operate.add(button[i][j]);
			}
		}
		
		
		window.add(view);
		window.add(operate);
		myEvent();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
	
	public void myEvent(){
		button[0][0].addActionListener(new ActionListener() {//退格键
			public void actionPerformed(ActionEvent e) {
				String line = downView.getText();
				if(line != null && line.length() != 0){
					downView.setText(line.substring(0,line.length() - 1));
				}
			}
		});
		
		button[0][1].addActionListener(new ActionListener() {//情况输入框信息
			public void actionPerformed(ActionEvent e) {
				downView.setText("0");
			}
		});
		
		button[0][2].addActionListener(new ActionListener() {//情况所有信息
			public void actionPerformed(ActionEvent e) {
				downView.setText("0");
				upView.setText("");
				sum = 0;
			}
		});
		
		button[0][3].addActionListener(new ActionListener() {//切换正负数
			public void actionPerformed(ActionEvent e) {
				String line = downView.getText();
				char c = line.charAt(0);
				if(c == '-'){
					downView.setText(line.substring(1,line.length()));
				}else {
					downView.setText("-" + line);
				}
			}
		});
		
		
		button[1][0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addDownText("7");
			}
		});
		
		button[1][1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addDownText("8");
			}
		});
		
		button[1][2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addDownText("9");
			}
		});
		
		button[2][0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addDownText("4");
			}
		});
		
		button[2][1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addDownText("5");
			}
		});
		
		button[2][2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addDownText("6");
			}
		});
		
		button[3][0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addDownText("1");
			}
		});
		
		button[3][1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addDownText("2");
			}
		});
		
		button[3][2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addDownText("3");
			}
		});
		
		button[4][0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				addDownText("0");
			}
		});
		
		button[4][2].addActionListener(new ActionListener() {//小数点
			public void actionPerformed(ActionEvent e) {
				String line = downView.getText();
				if(line.indexOf(".") == -1){
					downView.setText(line + ".");
				}
			}
		});
		
		button[4][3].addActionListener(new ActionListener() {//加法运算
			public void actionPerformed(ActionEvent e) {
				count("+");
			}
		});
		
		button[3][3].addActionListener(new ActionListener() {//减法运算
			public void actionPerformed(ActionEvent e) {
				count("-");
			}
		});
	
		
		button[2][3].addActionListener(new ActionListener() {//乘法运算
			public void actionPerformed(ActionEvent e) {
				count("*");
			}
		});
	
		button[1][3].addActionListener(new ActionListener() {//除法运算
			public void actionPerformed(ActionEvent e) {
				count("/");
			}
		});
		
		button[4][4].addActionListener(new ActionListener() {//等号
			public void actionPerformed(ActionEvent e) {
				count(oldOperator);
				upView.setText("");
				downView.setText(sum + "");
				sum = 0;
			}
		});
		
		button[0][4].addActionListener(new ActionListener() {//根号
			public void actionPerformed(ActionEvent e) {
				count("√");
			}
		});
	
		button[1][4].addActionListener(new ActionListener() {//百分号
			public void actionPerformed(ActionEvent e) {
				count("/");
			}
		});
		
		button[2][4].addActionListener(new ActionListener() {//分数
			public void actionPerformed(ActionEvent e) {
				count(oldOperator);
				upView.setText("");
				downView.setText(sum + "");
				sum = 0;
			}
		});
		
		
	}
	
	public void count(String operator){//运算方法
		
		String line = downView.getText();
		double record = Double.parseDouble(line);
		if((sum + "").equals(line)){
			if(!oldOperator.equals(operator)){
				upView.setText(upView.getText().substring(0,upView.getText().length() -1) + operator);
				oldOperator = operator;
			}
		}else if("√".equals(operator)){
			upView.setText(upView.getText() + "sqrt(" + line + ")");
			double rec = Math.sqrt(record);
			downView.setText(rec + "");

		}else{
			upView.setText(upView.getText() + line + operator);
			if("+".equals(oldOperator)){
				sum += record;
			}
			if("-".equals(oldOperator)){
				sum -= record;
			}
			if("*".equals(oldOperator)){
				sum *= record;
			}
			if("/".equals(oldOperator)){
				sum /= record;
			}
			if("".equals(oldOperator)){
				sum = record;
			}
			downView.setText(sum + "");
			oldOperator = operator;
		}
		
		
		
		if("%".equals(operator)){
			
		}
		
		if("1/x".equals(operator)){
			
		}
	}
	
	public void addDownText(String s){//输入框输入信息
		String line = downView.getText();
		if("0".equals(line)){
			if(!("0".equals(s))){
				downView.setText(s);
			}
		}else if((sum + "").equals(line)){
			downView.setText(s);
		}else {
			downView.setText(line + s);
		}
	}
}


