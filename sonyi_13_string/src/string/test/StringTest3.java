package string.test;

/*
Ŀ�ģ���ȡһ���ַ�������һ���ַ����г��ֵĴ���.
"abkkcdkkefkkskk"
˼·��
	1���������������
	2����ȡkk��һ�γ��ֵ�λ�á�
	3���ӵ�һ������λ�ú�ʣ����ַ����м�����ȡkk���ֵ�λ�á�
	4������ȡ����ʱ��������ɡ�
*/

class StringTest3{
	public static void main(String[] args){
		String s = "abkkcdkkefkkskk";
		int count = getSubCount(s,"kk");
		System.out.println("kk���ֵĴ���Ϊ��" + count);
	}
	
	public static int getSubCount(String s, String key){
		int count = 0;
		int index = s.indexOf("kk");
		while(index != -1){
			count++;
			index = s.indexOf("kk",index + key.length());
		}
		return count;
	}
}