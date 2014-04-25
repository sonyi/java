package cn.imcore.test;

import java.util.Scanner;

public class Login {
	Scanner input = new Scanner(System.in);
	private static String userId = "test";
	private static String userPwd = "123";
	
	public Login() {
		//登陆方法
		getData();
	}
	
	public void getData() {
		System.out.println("*******欢迎进入本系统***********");
		System.out.println("请输入账号:");
		String account = input.nextLine();
		System.out.println("请输入密码:");
		String pwd = input.nextLine();
		checkLogin(account, pwd);
	}
	
	
	public void checkLogin(String account, String pwd) {
		if(account.equals(userId) && pwd.equals(userPwd)) {
			//进入系统
			new Oper();
		} else {
			System.out.println("输入有误，请重新输入");
			getData();
		}
	}
	
}
