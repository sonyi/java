package cn.imcore.test;

public class TestStringBuffer {

	public static void main(String[] args) {
		String s = "123456789";
		StringBuffer sb1 = new StringBuffer(s);
		StringBuffer sb2 = new StringBuffer();
		
		System.out.println(sb2);
		sb2.append("Good morning,I am studying java.");//β��׷��
		System.out.println(sb2);
		sb2.insert(sb2.indexOf("I am"), "everyone.");//ָ��λ�ò����ַ���
		System.out.println(sb2);
		
		int start = sb2.indexOf("everyone");
		int end = start + "everyone".length();
		sb2.replace(start, end, "everybody");
		System.out.println(sb2);
		
		System.out.println("sb1:" + sb1);
		sb1.reverse();
		System.out.println("sb1 ����:" + sb1);
	}
}
