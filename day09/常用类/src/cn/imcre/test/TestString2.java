package cn.imcre.test;

public class TestString2 {

	public static void main(String[] args) {
		
		String str = "a,b,c;d,e,g";
		String[] s1 = str.split(";");//String[] s10 = new String[10];
		for(int i=0; i<s1.length; i++) {
			System.out.println(s1[i]);
		}
		
		
		int i1 = 10;
		boolean b = true;
//		String s2 = i1;
		String s2 = String.valueOf(i1);
		String s3 = String.valueOf(b);
		
		System.out.println("s2:" + s2);
		
		String s4 = 10 + "";
	}
}
