package arrays;

/*
	StaticImport:静态导入：
		当类名重名时，需要指定具体的包名。
		当方法重名时，需要指定所属的对象或者类。
 */
import java.util.Arrays;
import static java.util.Arrays.*;//导入的是Arrays这个类中的所有静态成员。
import static java.lang.System.*;//导入System类中的所有静态成员

public class StaticImport {
	public static void main(String[] args) {
		//未静态导入时的操作
		int[] arr = {3,1,5};
		Arrays.sort(arr);
		int index = Arrays.binarySearch(arr, 3);
		System.out.println(Arrays.toString(arr));
		System.out.println("Index:" + index);
		
		//静态导入后的操作
		int[] arr1 = {4,7,3,1,5};
		sort(arr1);//省略Arrays.
		int index1 = binarySearch(arr1, 3);//省略Arrays.
		System.out.println(Arrays.toString(arr1));//不能省略Arrays.因为toString重名。
		out.println("Index1:" + index1);//省略System

	}

}
