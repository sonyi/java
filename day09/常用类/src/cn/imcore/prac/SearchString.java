package cn.imcore.prac;

public class SearchString {

	public static void main(String[] args) {
		String str = "he9545hehe05340afdfheejfdkfhhe";
		String substr = "he";
		System.out.println(getCount(str, substr));
	}
	
	public static int getCount(String s, String sub) {
		int count = 0;
		int index = 0;
		index =	s.indexOf(sub,index); //��һ�β���
		System.out.println(index);
		
		while(index != -1) {
			count++;
			index = s.indexOf(sub,index + sub.length());//�ı���ʼλ��
			System.out.println(index);
		}

		return count;
		
	}
}
