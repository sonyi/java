package cn.imcore.prac;

public class TestCharCount {

	public static void main(String[] args) {
		String str = "fjdfj@@dfdAAdfdfERER55";//下标从0开始，到 length()-1结束
		int num1 = 0; //统计大写字母
		int num2 = 0; //统计小写字母
		int num3 = 0; //统计非字母
		
		for(int index = 0; index < str.length(); index++) {
			char c = str.charAt(index);
//			System.out.println(c);
			if(c>='A' && c<='Z') {//A-Z
				num1++;
			} else if(c>='a' && c<='z') {
				num2++;
			} else {
				num3++;
			}
			
		}
		
		System.out.println("大写字母个数：" + num1 + ", 小写字母个数：" + num2 + ", 其他：" + num3);
	}
}
