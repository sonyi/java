package map.test;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*
	��ϰ��
		"abhdehodahbdodscndhwhshdls"��ȡ���ַ����е���ĸ���ִ�����
			ϣ����ӡ�Ľ���ǣ�a(1) c(2).......
	˼·��
		ͨ��������֣�ÿ����ĸ���ж�Ӧ�Ĵ�����˵����ĸ�ʹ���֮�䶼��ӳ���ϵ��
		ע�⣺��������ӳ���ϵʱ������ѡ��map���ϡ���Ϊmap�����д�ŵľ���ӳ���ϵ��
		
	ʲôʱ��ʹ��map�����أ�
		������֮�����ӳ���ϵʱ�����Ⱦ�Ҫ�뵽map���ϡ�
		
	˼·��
		1�����ַ���ת�����ַ����飬��ΪҪ��ÿһ����ĸ���в�����
		2������һ��map���ϣ���Ϊ��ӡ�������ĸ��˳������ʹ��TreeMap���ϡ�
		3�������ַ����飬��ÿһ����ĸ��Ϊ��ȥ��map���ϣ�������ؿգ��ͽ�����ĸ��1���뵽map�����У�������ز��ǿգ�
			˵������ĸ��map�������Ѿ����ڣ����ж�Ӧ�Ĵ�������ô�ͻ�ȡ�ô���������������Ȼ�󽫸���ĸ��������Ĵ�������
			�������У����ǵ�ԭ������Ӧ��ֵ��
		4����map�����е����ݱ��ָ�����ַ������ء�
		
 */
public class MapTest3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = charCount("abhdeh78odahbd51odscndhwh/.,shdls");
		System.out.println(s);
	}
	
	public static String charCount(String str){
		char[] ch = str.toCharArray();//���ַ���ת�����ַ�����
		TreeMap<Character,Integer> map = new TreeMap<Character,Integer>();//����һ��TreeMap���ϣ��洢�ַ�������
		int count = 0;
		
		//�����ַ�����
		for(int i = 0; i < ch.length; i++){		
			//�ж��Ƿ����ַ���������ǣ������˴�ѭ����������һ���ַ������ַ�������
			if(!(ch[i] >= 'a' && ch[i] <= 'z' || ch[i] >='A' && ch[i] <= 'Z'))
				continue;
			
			Integer value = map.get(ch[i]);
			
			//�ж��ַ����洢����ʽ����
			if(value != null)
				count = value;
			count++;
			map.put(ch[i], count);
			count = 0;
			
			
			/*//�ж��ַ����洢����ʽһ��
			if(value == null)
				map.put(ch[i], 1);
			else
				map.put(ch[i], value + 1);
			*/
		}
		//System.out.println(map);//��ӡ��������
		
		//�޸ļ�����Ԫ�ص������ʽ
		StringBuilder sb = new StringBuilder();//����һ��StringBuilder�������洢�ַ������ڵ�ÿ��Ԫ��
		Set<Map.Entry<Character,Integer>> entrySet = map.entrySet();//����һ������
		Iterator<Map.Entry<Character,Integer>> it = entrySet.iterator();//����һ��������
		while(it.hasNext()){//��ȡ��������������ݣ�����ӵ�StringBuilder��
			Map.Entry<Character,Integer> me = it.next();
			Character c = me.getKey();
			Integer i = me.getValue();
			sb.append(c + "(" + i + ") ");	
		}
		
		return sb.toString();//�����ַ���
	}
}
