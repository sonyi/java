package cn.imcore.prac;

public class Test3 {
	public static void main(String[] args) {
		String str = "123abcd22xyz45"+"#";
		new Test3().f1(str);
	}
	
	public void f1(String s) {
		System.out.println(s);
		String temp = "";
		long sum = 0;//存放求和的结果值
		
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if(ch>='0' && ch<='9') {
				temp = temp + ch;
			} else {
				if(!"".equals(temp)){
					System.out.println(temp);
					sum = sum + Long.parseLong(temp);
				}
				temp = "";
			}
		}
		System.out.println("sum=" + sum);
	}
	
}
