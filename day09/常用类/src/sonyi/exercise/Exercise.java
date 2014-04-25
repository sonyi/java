package sonyi.exercise;
//练习：
//		统计一个字符串中，大写字母、小写字母和其他符号的个数。
public class Exercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "abdJD09145Dadjini";
		int capitalNum = 0;
		int lowerNum = 0;
		int otherNum = 0;
		for(int i = 0; i <s.length();i++){
			if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') lowerNum++;
			if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') capitalNum++;
		}
		otherNum = s.length() - lowerNum - capitalNum;
		System.out.println("字符串的长度为：" + s.length());
		System.out.println("字符串中大写字母个数为："  + capitalNum + ",小写字母个数为：" + lowerNum + ",其他字母个数为：" + otherNum);
		
	}

}
