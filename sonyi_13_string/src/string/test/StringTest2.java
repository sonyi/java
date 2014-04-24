package string.test;
/*
目的：将一个字符串进行反转，将字符串中指定部分进行反转。
思路：1、曾经学习过对数组的元素进行反转。
	  2、将字符串变成数组，对数组反转。
	  3、将反转后的数组变成字符串。
	  4、只要将反转的部分的开始和结束位置作为参数传递即可。
*/

class StringTest2{
	public static String turnString(String str,int start,int end){
		char ch;
		String beginString;
		String tranform;
		String endString;
		if(start != 0)
			beginString = str.substring(0,start);
		else beginString ="";
		tranform = str.substring(start,end);
		if(end != str.length())
			endString = str.substring(end,str.length());
		else endString = "";
		char[] cha = tranform.toCharArray();
		for(int i = 0; i<=cha.length/2; i++){
			ch = cha[i];
			cha[i] = cha[cha.length-1-i];
			cha[cha.length-1-i] = ch;
		}
		tranform = new String(cha);
		return beginString + tranform + endString;	
	}
	
	public static void main(String args []){
		String s = "abcdefg";
		System.out.println(s);
		s = turnString(s,2,5);
		System.out.println(s);

	}
}