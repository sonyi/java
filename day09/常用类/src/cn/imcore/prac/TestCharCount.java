package cn.imcore.prac;

public class TestCharCount {

	public static void main(String[] args) {
		String str = "fjdfj@@dfdAAdfdfERER55";//�±��0��ʼ���� length()-1����
		int num1 = 0; //ͳ�ƴ�д��ĸ
		int num2 = 0; //ͳ��Сд��ĸ
		int num3 = 0; //ͳ�Ʒ���ĸ
		
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
		
		System.out.println("��д��ĸ������" + num1 + ", Сд��ĸ������" + num2 + ", ������" + num3);
	}
}
