package cn.imcre.test;

public class TestString {

	public static void main(String[] args) {
		String str = "123 abc 456abcrrrr";
		String s1 = "abc";
		String s2 = "Abc";
		
		System.out.println("�ַ������ȣ�" + s1.length());
		System.out.println("���ص�1��λ�õ��ַ���" + s1.charAt(0));
		System.out.println("�����ַ�q���ַ����г��ֵ�λ�ã�" + str.indexOf('q'));
		System.out.println("�����ַ�6���ַ����г��ֵ�λ�ã�" + str.indexOf('6'));
		System.out.println("�������ַ��� abc ���ַ����г��ֵ�λ�ã�" + str.indexOf(s1));
		System.out.println("�������ַ��� abc ���ַ����г��ֵ�λ�ã�" + str.indexOf(s1,7));
		System.out.println("�ж������ַ����Ƿ���ȣ�" + s1.equals(s2)); //false
		System.out.println("�ж������ַ����Ƿ����(���Դ�Сд)��" + s1.equalsIgnoreCase(s2)); //true
		
		String s3 = "Hellh Whrld.";//���ɱ�ĳ���
		System.out.println("���ַ�����h �滻�� o : " + s3.replace('h', 'o'));
		System.out.println("s3: " + s3);
		s3 = s3.replace('h', 'o');//���¸�ֵ
		
		String s4 = "abcderdfabcgdfaaaaa";
		System.out.println("���ַ�����abc �滻�� 111 : " + s4.replaceAll("abc", "111"));
		
		String s5 = "kari.zhang";
		System.out.println("�ж��ַ����Ƿ���k��ͷ�� " + s5.startsWith("k"));//true
		System.out.println("�ж��ַ����Ƿ���k��β�� " + s5.endsWith("k"));//false
		
		String s6 = "aBcDEfg1234";
		System.out.println("���ַ�����Сд��ĸת�ɴ�д��" + s6.toUpperCase());
		System.out.println("���ַ����д�д��ĸת��Сд��" + s6.toLowerCase());
		
		String s7 = "123456789abcdefgh";
		System.out.println("�ַ�����ȡ�� " + s7.substring(6));
		System.out.println("�ַ�����ȡ�� " + s7.substring(6, 12));//789abc
		
		String s8 = "    abcd    fdfdf    ";//trim, ȥ��ͷβ�ո�
		System.out.println("s8: " + s8);
		System.out.println("ȥ��ͷβ�ո�:" + s8.trim());

		
	}
}
