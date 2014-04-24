package string.test;

/*
Ŀ�ģ���ȡ�����ַ����������ͬ�Ӵ�����һ�����������̵��Ǹ������г������εݼ����Ӵ���ӡ��
"abcwerthelloyuiodef"   "cvhellobnm"
˼·��
	1�����̵��Ǹ��Ӵ����ճ��ȵݼ��ķ�ʽ��ȡ��
	2����ÿ��ȡ�����Ӵ�ȥ�������ж��Ƿ����������������Ѿ��ҵ���
*/
class StringTest4{
	public static void main(String[] args){
	
		String s1 = "abcwerthelloyuiodef";
		String s2 = "cvhellobnm";
		String s = getLongSubstring(s1, s2);
		if(s == "")
			System.out.println("û�й�ͬ�Ӵ�");
		else
			System.out.println("���ַ��������ͬ�Ӵ��ǣ�" + s);
	}
	
	//��ȡ���ַ��������ͬ�Ӵ�
	private static String getLongSubstring(String s1, String s2){
		//�ж����ַ����ĳ����Ͷ̴�
		String sMax, sMin;
		if(s1.length() <= s2.length()){
			sMin = s1;
			sMax = s2;
		}
		else{
			sMin = s2;
			sMax = s1;
		}
		
		//����ѭ�������ַ��������ж�(�ö��ַ����Ƚϳ��ַ���)
		int end = sMin.length()-1;
		int start = 0;
		for(String sub ; end >= start ; end-- ){//ÿѭ����һ�Σ��ַ������ȼ�һ
			//�ù̶����ȵ��Ӵ�����0λ��ʼ�볤���ַ����бȽϣ�ÿ��ѭ����ǰ����һλ
			for(int i = start,e = end; e <=  sMin.length()-1; i++,e++){
				sub = sMin.substring(i,e+1);
				if(sMax.contains(sub)) return sub;
			}
		}
		return "";
	}
		
}
