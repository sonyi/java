package arrays;

/*
	StaticImport:��̬���룺
		����������ʱ����Ҫָ������İ�����
		����������ʱ����Ҫָ�������Ķ�������ࡣ
 */
import java.util.Arrays;
import static java.util.Arrays.*;//�������Arrays������е����о�̬��Ա��
import static java.lang.System.*;//����System���е����о�̬��Ա

public class StaticImport {
	public static void main(String[] args) {
		//δ��̬����ʱ�Ĳ���
		int[] arr = {3,1,5};
		Arrays.sort(arr);
		int index = Arrays.binarySearch(arr, 3);
		System.out.println(Arrays.toString(arr));
		System.out.println("Index:" + index);
		
		//��̬�����Ĳ���
		int[] arr1 = {4,7,3,1,5};
		sort(arr1);//ʡ��Arrays.
		int index1 = binarySearch(arr1, 3);//ʡ��Arrays.
		System.out.println(Arrays.toString(arr1));//����ʡ��Arrays.��ΪtoString������
		out.println("Index1:" + index1);//ʡ��System

	}

}
