package string.test;

/*
Ŀ�ģ�д������ȥ���ַ������˵Ŀո�
˼·��1���ж��ַ�����һ��λ���Ƿ��ǿո�����Ǽ��������жϣ�ֱ�����ǿո�Ϊֹ��
		�������жϿո�Ҳ����ˡ�
	  2������ʼ�ͽ�β���жϵ����ǿո�ʱ������Ҫ��ȡ���ַ�����

���裺1������һ����
	  2������һ���������ж���λ�ǿո񴦡�
	  3������һ�������ӡ������
	  4������һ������������������һ���ַ�������֤�����
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