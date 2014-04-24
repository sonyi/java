package generic;

import java.util.ArrayList;
import java.util.Iterator;
/*
	���ͣ�JDK1.5�汾�Ժ���ֵ������ԣ����ڽ����ȫ���⣬��һ�����Ͱ�ȫ���ơ�
		�ô���1��������ʱ�ڳ��ֵ�����classCastException��ת�Ƶ�����ʱ�ڣ������ڳ���Ա������⡣
				����������������٣���ȫ��
			  2��������ǿ������ת�����鷳��
			  
	���͸�ʽ��ͨ��<>������Ҫ�����ĵ������������͡�
	��ʹ��java�ṩ�Ķ���ʱ��ʲôʱ��д�����أ�
		ͨ���ڼ��Ͽ���кܳ�����ֻҪ���嵽<>��Ҫ���巺�͡�
		
	��ʵ<>���������������͵ġ�
	
	��ʹ�ü���ʱ����������Ҫ�洢������������Ϊ�������ݵ�<>�м��ɡ�
 */
public class GenericDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//<String>���ͣ�������ݴ洢ʱ���������ͣ���ֹ����
		ArrayList<String> al = new ArrayList<String>();
		al.add("abd01");
		al.add("a01");
		al.add("abd02");
		al.add("ab81");
		al.add("abd0174");
		
		for(Iterator<String> it = al.iterator();it.hasNext();){
			String s = it.next();           //����Ҫ��ǿ������ת����
			System.out.println(s + ":" + s.length());
		}		
	}
}
