package string.test;

/*
目的：写个程序，去除字符串两端的空格
思路：1、判断字符串第一个位置是否是空格，如果是继续向下判断，直到不是空格为止。
		结束处判断空格也是如此。
	  2、当开始和结尾都判断到不是空格时，就是要获取的字符串。

步骤：1、创建一个类
	  2、创建一个方法，判断首位非空格处。
	  3、创建一个输出打印方法。
	  4、创建一个主函数，输入任意一个字符串，验证结果。
*/
class StringTest{
	public static void sop(String str){
		System.out.println(str);
	}
	
	public static String myTrim(String str){
		int start = 0;
		int end = str.length()-1;
		while(start <= end && str.charAt(start) ==  ' ')
			start++;
		while(end >= start && str.charAt(end) == ' ' )
			end--;
		return str.substring(start,end +1);
	}
	
	public static void main(String [] args){
		String s = "    dlsj  diid  kds    ";
		sop("(" + s + ")");
		s = myTrim(s);
		sop("(" + s + ")");
	}
}