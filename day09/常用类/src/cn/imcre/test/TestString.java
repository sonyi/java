package cn.imcre.test;

public class TestString {

	public static void main(String[] args) {
		String str = "123 abc 456abcrrrr";
		String s1 = "abc";
		String s2 = "Abc";
		
		System.out.println("字符串长度：" + s1.length());
		System.out.println("返回第1个位置的字符：" + s1.charAt(0));
		System.out.println("查找字符q在字符串中出现的位置：" + str.indexOf('q'));
		System.out.println("查找字符6在字符串中出现的位置：" + str.indexOf('6'));
		System.out.println("查找子字符串 abc 在字符串中出现的位置：" + str.indexOf(s1));
		System.out.println("查找子字符串 abc 在字符串中出现的位置：" + str.indexOf(s1,7));
		System.out.println("判断两个字符串是否相等：" + s1.equals(s2)); //false
		System.out.println("判断两个字符串是否相等(忽略大小写)：" + s1.equalsIgnoreCase(s2)); //true
		
		String s3 = "Hellh Whrld.";//不可变的常量
		System.out.println("把字符串中h 替换成 o : " + s3.replace('h', 'o'));
		System.out.println("s3: " + s3);
		s3 = s3.replace('h', 'o');//重新赋值
		
		String s4 = "abcderdfabcgdfaaaaa";
		System.out.println("把字符串中abc 替换成 111 : " + s4.replaceAll("abc", "111"));
		
		String s5 = "kari.zhang";
		System.out.println("判断字符串是否以k开头： " + s5.startsWith("k"));//true
		System.out.println("判断字符串是否以k结尾： " + s5.endsWith("k"));//false
		
		String s6 = "aBcDEfg1234";
		System.out.println("把字符串中小写字母转成大写：" + s6.toUpperCase());
		System.out.println("把字符串中大写字母转成小写：" + s6.toLowerCase());
		
		String s7 = "123456789abcdefgh";
		System.out.println("字符串截取： " + s7.substring(6));
		System.out.println("字符串截取： " + s7.substring(6, 12));//789abc
		
		String s8 = "    abcd    fdfdf    ";//trim, 去掉头尾空格
		System.out.println("s8: " + s8);
		System.out.println("去掉头尾空格:" + s8.trim());

		
	}
}
