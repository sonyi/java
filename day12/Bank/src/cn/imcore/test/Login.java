package cn.imcore.test;

import java.util.Scanner;

public class Login {
	Scanner input = new Scanner(System.in);
	private static String userId = "test";
	private static String userPwd = "123";
	
	public Login() {
		//��½����
		getData();
	}
	
	public void getData() {
		System.out.println("*******��ӭ���뱾ϵͳ***********");
		System.out.println("�������˺�:");
		String account = input.nextLine();
		System.out.println("����������:");
		String pwd = input.nextLine();
		checkLogin(account, pwd);
	}
	
	
	public void checkLogin(String account, String pwd) {
		if(account.equals(userId) && pwd.equals(userPwd)) {
			//����ϵͳ
			new Oper();
		} else {
			System.out.println("������������������");
			getData();
		}
	}
	
}
