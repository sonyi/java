package sonyi.exercise;
//��ϰ��
//		ͳ��һ���ַ����У���д��ĸ��Сд��ĸ���������ŵĸ�����
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
		System.out.println("�ַ����ĳ���Ϊ��" + s.length());
		System.out.println("�ַ����д�д��ĸ����Ϊ��"  + capitalNum + ",Сд��ĸ����Ϊ��" + lowerNum + ",������ĸ����Ϊ��" + otherNum);
		
	}

}
