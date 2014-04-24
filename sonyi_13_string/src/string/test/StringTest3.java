package string.test;

/*
目的：获取一个字符串在另一个字符串中出现的次数.
"abkkcdkkefkkskk"
思路：
	1、定义个计数器。
	2、获取kk第一次出现的位置。
	3、从第一个出现位置后剩余的字符串中继续获取kk出现的位置。
	4、当获取不到时，计数完成。
*/

class StringTest3{
	public static void main(String[] args){
		String s = "abkkcdkkefkkskk";
		int count = getSubCount(s,"kk");
		System.out.println("kk出现的次数为：" + count);
	}
	
	public static int getSubCount(String s, String key){
		int count = 0;
		int index = s.indexOf("kk");
		while(index != -1){
			count++;
			index = s.indexOf("kk",index + key.length());
		}
		return count;
	}
}