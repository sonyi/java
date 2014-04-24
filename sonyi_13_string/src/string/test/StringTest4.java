package string.test;

/*
目的：获取两个字符串中最大相同子串，第一个动作：将短的那个串进行长度依次递减的子串打印。
"abcwerthelloyuiodef"   "cvhellobnm"
思路：
	1、将短的那个子串按照长度递减的方式获取。
	2、将每获取到的子串去长串中判断是否包含，如果包含，已经找到。
*/
class StringTest4{
	public static void main(String[] args){
	
		String s1 = "abcwerthelloyuiodef";
		String s2 = "cvhellobnm";
		String s = getLongSubstring(s1, s2);
		if(s == "")
			System.out.println("没有共同子串");
		else
			System.out.println("两字符串的最大共同子串是：" + s);
	}
	
	//获取两字符串中最大共同子串
	private static String getLongSubstring(String s1, String s2){
		//判断两字符串的长串和短串
		String sMax, sMin;
		if(s1.length() <= s2.length()){
			sMin = s1;
			sMax = s2;
		}
		else{
			sMin = s2;
			sMax = s1;
		}
		
		//定义循环，对字符串进行判断(用短字符串比较长字符串)
		int end = sMin.length()-1;
		int start = 0;
		for(String sub ; end >= start ; end-- ){//每循环完一次，字符串长度减一
			//用固定长度的子串，从0位开始与长串字符进行比较，每次循环向前增加一位
			for(int i = start,e = end; e <=  sMin.length()-1; i++,e++){
				sub = sMin.substring(i,e+1);
				if(sMax.contains(sub)) return sub;
			}
		}
		return "";
	}
		
}
