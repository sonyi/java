package string.demo;

/*

---------------------String��------------------------
String�ࣺ
	�ַ�����һ������Ķ���
	�ַ���һ����ʼ���Ͳ����Ա��ı䡣���ַ�������ص㣩
	
String str1 = "abc" ��String str2 = new String("abc")��ʲô���𣿣���
	String str1 = "abc";str1��һ�������ͱ�����"abc"��һ������
	String str2 = new String("abc");String�ิд��object���е�equals������
		�÷��������ж��ַ����Ƿ���ͬ��
	str1��str2����
		str1���ڴ�����һ������str2���ڴ�������������
	
	String str3 = "abc"  �ʣ�
		str1==str2.-----false   ��ͬ����
		str1==str3.-----true   �ַ����Ѿ����ڴ��г������ڴ��ڣ�str3��ʼ��ʱ�����Ѿ�
			���ڣ��Ͳ��ٶ������ٿռ䴴���ַ�����
			
String�������������ַ�������ṩ�˶���������ַ������в�����
�����Ĳ�������Щ��
	1����ȡ��
		1.1�ַ����а������ַ�����Ҳ�����ַ����ĳ��ȡ�int length();
			(�����length�����ԣ��ַ���length();�Ƿ���)
		1.2����λ�û�ȡλ���ϵ�ĳ���ַ���char CharAt(int index);
			�����ʵ��ַ����в����ڵĽǱ�ʱ�ᷢ��StringIndexOfBoundsException��
		1.3�����ַ���ȡ���ַ����ַ����е�λ�á�
			int indexOf(int ch);���ص���ch���ַ����е�һ�γ��ֵ�λ�á�
			int indexOf(int ch,int fromIndex);��fromIndexָ��λ�ÿ�ʼ����ȡch���ַ����г��ֵ�λ�á�
				���û���ҵ�������ֵΪ-1��
			int indexOf(String str);���ص���str���ַ����е�һ�γ��ֵ�λ�á�
			int indexOf(String str,int fromIndex);��fromIndexָ��λ�ÿ�ʼ����ȡstr���ַ����г��ֵ�λ�á�
			
			int lastIndexOf(int ch);���������������������ѯ�����ǽǱ겻�䣩
			int lastIndexOf(int ch, int fromIndex);
			int lastIndexOf(String str);
			int lastIndexOf(String str,int fromIndex);
		
	2���жϣ�
		2.1�ַ������Ƿ����ĳһ���ַ�����
			boolean contains(String str);
			����֮����indexOf(String str):��������str��һ�γ���λ�ã��������-1,��ʾ��
				str�����ַ����д��ڡ����ԣ�Ҳ���������ж϶�ָ�������Ƿ������
				if(str.indexOf("aa"!=-1));
				�÷����ȿ����жϣ��ֿ��Ի�ȡ���ֵ�λ�á�
		2.2�ַ����Ƿ������ݡ�
			boolean isEmpty();ԭ������жϳ����Ƿ�Ϊ�㡣
		2.3�ַ����Ƿ�����ָ�����ݿ�ͷ��
			boolean startWith(String str);
		2.4�ַ����Ƿ�����ָ�����ݽ�β��
			boolean endsWith(String str);
		2.5�ж��ַ��������Ƿ���ͬ������д��object�е�equals������
			boolean equals(String str);
		2.6�ж������Ƿ���ͬ�������Դ�Сд��
			boolean equalsIgnoreCase();
	3������ת����
		3.1���ַ�����ת�����ַ���
			���캯����String(char[])
					  String(char[],offset,count);���ַ������е�һ����ת�����ַ���
			��̬������static String copyValueOf(char[]);
					  static String copyValueOf(char[] data,int offset,int count);
					  
					  static String ValueOf(char[]);
			
		3.2���ַ���ת�����ַ����飨****�ص�******��
			char[] toCharArray();
		3.3���ֽ�����ת�����ַ���
			String(byte[])
			String(byte[],offset,count);���ֽ������е�һ����ת
		3.4���ַ���ת�����ֽ�����
			byte[] getBytes();
		3.5��������������ת�����ַ���
			static String ValueOf(double);
			static String valueOf(int);	
			eg:3+"";  == String.value(3);
		���⣺�ַ������ֽ�������ת�������У��ǿ���ָ��������
		
	4���滻��
		String replace(char oldChar,char newChar);
			(�滻��������ַ�������Ϊ�ַ�����ʼ����Ͳ���ı䡣����滻�����ڣ����ص���ԭ��)
		
	5���и
		String[] split(regex);
		
	6���Ӵ�����ȡ�ַ����е�һ���֡�
		String substring(begin);---��ָ��λ�ÿ�ʼ����β��
		String substring(begin,end); ---����ͷ��������β��
			����Ǳ겻���ڣ�������ַ����Ǳ�Խ���쳣��
			
	7����Сдת����ȥ���ո񡢱Ƚϣ�
		7.1���ַ���ת���ɴ�д����Сд
			String toUpperCase();
			String toLowerCase();	
		7.2���ַ������˵Ķ���ո�ȥ��
			String trim();
		7.3�������ַ���������Ȼ˳��ıȽ�
			int compareTo(String); ����ֵ����ͬΪ0������Ϊ������С��Ϊ������
			
			
-------------------------StringBuffer��StringBuilder-----------------------------

StringBuffer���ַ�����������
	�ص㣺
		1����һ�����������ҳ����ǿɱ仯�ġ�
		2�����Բ�������������͡�
		3�����ջ�ͨ��toString��������ַ�����

CURD:��ɾ�Ĳ�
	����create��update��read��delete

1���洢��
	StringBuffer append(); ��ָ��������Ϊ������ӵ��������ݽ�β����
	StringBuffer insert(int index,����); ���Խ����ݲ��뵽ָ����indexλ�á�
	
2��ɾ����
	StringBuffer delete(int start,int end); ɾ���������е����ݣ�����start��������end��
	StringBuffer deleteCharAt(int index); ɾ��ָ��λ�õ��ַ���
	
3����ȡ��
	Char charAt(int index);
	int indexOf(String str);
	int lastIndexOf(String str);
	int length();
	String substring(int start,int end);  ����start��������end
	
4���޸ģ�
	StringBuffer replace(int start,int end,String str);  ����start��������end
	setCharAt(int index,char ch);

5����ת��
	StringBuffer reverse();
    
6������������ָ�����ݴ洢��ָ�������У�
	void getChars(int srcBegin,int srcEnd,char[] dst,int dstBegin);
	
��JDK1.5�汾֮�������StringBuilder��������StringBuffer��ͬ��
	StringBuffer���߳�ͬ�����߳��ǰ�ȫ�ģ�����ÿ�ζ���Ҫ��������Ч�ʽϵ͡�
	StringBuilder���̲߳�ͬ�����߳��ǲ���ȫ�ģ�����Ҫ��������Ч�ʸߡ����ڶ��̲߳���ȫ��
	���������Ҫ���߳�ͬ��������ʹ��StringBuffer��������Ҫͬ����ʹ��StringBuilder��
	
	�Ժ󿪷�������ʹ��StringBuilder��


Java�������������أ�
	1�����Ч�ʣ�
	2������д��
	3����߰�ȫ�ԡ�


---------------------------�����������Ͷ����װ��----------------------------------

������������	������������
	byte			Byte
	int				Integer
	short			Short
	long			Long
	boolean			Boolean
	float			Float
	double			Double
	char			Character

�����������Ͷ����װ���������ã�
	���ڻ����������ͺ��ַ�������֮����ת����

������������ת�����ַ�����
	������������ + "";
	������������.toString(������������ֵ);  
		eg��Integer.toString(34);  //��34�������"34";
		
�ַ���ת���ɻ����������ͣ�
	��һ�ַ�����(��̬���÷�ʽ)
		xxx�ǻ����������ͣ�
			xxx a = Xxx.parseXxx(String);
			eg:Integer.parseInt("123");
				//���ַ���"123"�������123;���봫���������͵��ַ�������������쳣
			eg:Long.parseLong("123");
		boolean b = Boolean.parseBoolean("true");
	�ڶ��ַ�����(�Ǿ�̬��������÷�ʽ)
		Integer i = new Integer("123");
		int num = i.intValue();
		
ʮ����ת���������ƣ�
	toBinaryString();
	toHexString();
	toOctalString();
	
��������ת��ʮ���ƣ�
	parseInt(String,radix);
		eg:radix���еȼ�����2,8,10,16


JDK1.5�汾�Ժ���ֵ������ԣ�
	
		

 */
