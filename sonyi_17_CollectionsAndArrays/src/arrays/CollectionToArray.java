package arrays;

import java.util.ArrayList;
import java.util.Arrays;

/*
	���ϱ����飺
		Collection�ӿ��е�toArray������
 */
public class CollectionToArray {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("abd--1");
		al.add("abd--2");
		al.add("abd--3");
		
		/*
		 * 1��ָ�����͵����鵽��Ҫ����೤�أ�
		 * 		��ָ�����͵����鳤��С���˼��ϵ�size����ô�÷����ڲ��ᴴ��һ���µ����顣
		 * 			����Ϊ���ϵ�size��
		 * 		��ָ�����͵����鳤�ȴ����˼��ϵ�size���Ͳ����´������飬����ʹ�ô��ݽ��������顣
		 * 		���Դ���һ���ոպõ��������š�
		 * 
		 * 2��ΪʲôҪ�����ϱ����飿
		 * 		Ϊ���޶���Ԫ�صĲ���������Ҫ������ɾ��
		 */
		String[] arr = al.toArray(new String[al.size()]);
		System.out.println(Arrays.toString(arr));		
	}
}
