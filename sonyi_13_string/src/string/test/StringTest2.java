package string.test;
/*
Ŀ�ģ���һ���ַ������з�ת�����ַ�����ָ�����ֽ��з�ת��
˼·��1������ѧϰ���������Ԫ�ؽ��з�ת��
	  2�����ַ���������飬�����鷴ת��
	  3������ת����������ַ�����
	  4��ֻҪ����ת�Ĳ��ֵĿ�ʼ�ͽ���λ����Ϊ�������ݼ��ɡ�
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