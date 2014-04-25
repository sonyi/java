package cn.imcore.prac;

import java.util.Arrays;

public class Test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "sdfFsfdFGsdLFsdfeoLDK";
		StringBuilder sb = new StringBuilder(s);
		System.out.println(s);
		
		new Test2().f2(sb);
	}

	public void f1(String ss) {
		for(int i=0; i<ss.length(); i++) {
			char ch = ss.charAt(i);
			if(ch >= 'a' && ch <= 'z') {
				ss = ss.replace(ch, (char)(ch-32));
			}
			if(ch >= 'A' && ch <= 'Z') {
				ss = ss.replace(ch, (char)(ch+32));
			}
		}
		
		System.out.println(ss);
	}
	
	public void f2(StringBuilder ss) {
		for(int i=0; i<ss.length(); i++) {
			char ch = ss.charAt(i);
			if(ch >= 'a' && ch <= 'z') {
//				ss = ss.replace(ch, (char)(ch-32));
				ss.setCharAt(i, (char)(ch-32));
			}
			if(ch >= 'A' && ch <= 'Z') {
				ss.setCharAt(i, (char)(ch+32));
			}
		}
		
		System.out.println(ss);
	}
}
