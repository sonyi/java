package cn.imcore.test;

public class TestStringBuffer {

	public static void main(String[] args) {
		String s = "123456789";
		StringBuffer sb1 = new StringBuffer(s);
		StringBuffer sb2 = new StringBuffer();
		
		System.out.println(sb2);
		sb2.append("Good morning,I am studying java.");//尾部追加
		System.out.println(sb2);
		sb2.insert(sb2.indexOf("I am"), "everyone.");//指定位置插入字符串
		System.out.println(sb2);
		
		int start = sb2.indexOf("everyone");
		int end = start + "everyone".length();
		sb2.replace(start, end, "everybody");
		System.out.println(sb2);
		
		System.out.println("sb1:" + sb1);
		sb1.reverse();
		System.out.println("sb1 逆序:" + sb1);
	}
}
