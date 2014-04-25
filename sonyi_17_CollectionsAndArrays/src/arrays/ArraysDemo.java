package arrays;

import java.util.Arrays;
import java.util.List;

/*
	Arrays:���ڲ�������Ĺ����ࡣ���涼�Ǿ�̬����
		
	asList:��������list����
 */
public class ArraysDemo {

	public static void main(String[] args) {
		int[] arr = {2,4,5};
		System.out.println(Arrays.toString(arr));

		
		String[] a = {"abc","cc","kkkk"};
		/*
		 * ��������list����
		 * �ô�������ʹ�ü��ϵ�˼��ͷ��������������е�Ԫ��
		 * ע�⣺�������ɼ��ϣ�������ʹ�ü��ϵ���ɾ��������Ϊ����ĳ����ǹ̶��ġ�
		 * 		�����ã�contains();get();indexOf();subList();�ȡ���
		 * 		�����ɾ�ˣ���ô�ᷢ��UnsupportedOperationException(��֧�ֲ���)�쳣
		 */
		List<String> list = Arrays.asList(a);
		//list.add("qq");//java.lang.UnsupportedOperationException
		System.out.println(list);
		
		
		/*
		 * ��������е�Ԫ�ض��Ƕ�����ô��ɼ���ʱ�������е�Ԫ�ؾ�ֱ��ת���ɼ����е�Ԫ��
		 * ��������е�Ԫ�ض��ǻ����������ͣ���ô�Ὣ������Ϊ�����е�Ԫ�ش���
		 */
		int[] num = {2,4,5};//�����Ԫ���ǻ�����������
		List<int[]> li = Arrays.asList(num);//ע�ⷺ����int[]
		System.out.println(li);
		
		Integer[] num1 = {2,4,5};//�����Ԫ���Ƕ���
		List<Integer> li1 = Arrays.asList(num1);//ע�ⷺ����Integer
		System.out.println(li1);
		
	}

}
