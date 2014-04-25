package cn.imcre.test;

public class TestString3 {

	public static void main(String[] args) {
		String str = "abdfdfer";
		System.out.println("=====字符串转字节数组=====");
		byte[] b = str.getBytes();
		for(int i=0; i<b.length; i++) {
			System.out.println(b[i]);
		}
//		System.out.println((int)'a');
		System.out.println("=====字符串转字符数组=====");
		char[] c = str.toCharArray();
		for(int i=0; i<c.length; i++) {
			System.out.println(c[i]);
		}
	}
}
