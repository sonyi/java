package arrays;

import java.util.Arrays;

/*
	JDK1.5�汾���ֵ������ԣ�
		�����Ŀɱ���������ԣ�
			ע�⣺��ʹ��ʱ���ɱ����һ��Ҫ�����ڲ����б������档
		
 */
public class ParamMethodDemo {
	public static void main(String[] args) {
		//��ʽһ��
//		show(2,3);
//		show(2,3,4);
		
		//��ʽ������Ȼ�ٶ����˶������������ÿ�ζ��ж���һ�����飬��Ϊʵ�ʲ���
//		int[] arr = {3,4};
//		show(arr);
//		System.out.println();
//		int[] arr1 = {3,4,5};
//		show(arr1);
		
		
		//��ʽ�����ɱ��������ʵ������һ����������ļ�д��ʽ������ÿ�ζ��ֶ������������
		//	ֻҪ��Ҫ������Ԫ����Ϊ�������ݼ��ɣ���ʽ����Щ������װ�����顣
		show(1);
		System.out.println();
		show(1,2,3);
		System.out.println();
		show("hehehe",2,3);
	}
	
	
	//��ʽ����
	public static void show(int... arr){
		for(int i : arr){
			System.out.print(i + ", ");
		}
	}
	//ע�⣺��ʹ��ʱ���ɱ����һ��Ҫ�����ڲ����б������档
	public static void show(String s, int... arr){
		System.out.print(s + " ");
		System.out.println(Arrays.toString(arr));
	}
	
	
	//��ʽ����
	/*
	public static void show(int[] arr){
		for(int i : arr){
			System.out.print(i + ", ");
		}
	}
	*/
	
	//��ʽһ��
	/*
	public static void show(int a ,int b){
		System.out.println(a + ":" + b);
	}
	public static void show(int a ,int b, int c){
		System.out.println(a + ":" + b + ":" + c);
	}
	*/

}
