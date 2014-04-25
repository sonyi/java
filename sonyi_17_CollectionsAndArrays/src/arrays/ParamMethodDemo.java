package arrays;

import java.util.Arrays;

/*
	JDK1.5版本出现的新特性：
		方法的可变参数新特性：
			注意：在使用时，可变参数一定要定义在参数列表的最后面。
		
 */
public class ParamMethodDemo {
	public static void main(String[] args) {
		//方式一：
//		show(2,3);
//		show(2,3,4);
		
		//方式二：虽然少定义了多个方法。但是每次都有定义一个数组，作为实际参数
//		int[] arr = {3,4};
//		show(arr);
//		System.out.println();
//		int[] arr1 = {3,4,5};
//		show(arr1);
		
		
		//方式三：可变参数，其实就是上一种数组参数的简写形式。不用每次都手动建立数组对象。
		//	只要将要操作的元素作为参数传递即可，隐式将这些参数封装成数组。
		show(1);
		System.out.println();
		show(1,2,3);
		System.out.println();
		show("hehehe",2,3);
	}
	
	
	//方式三：
	public static void show(int... arr){
		for(int i : arr){
			System.out.print(i + ", ");
		}
	}
	//注意：在使用时，可变参数一定要定义在参数列表的最后面。
	public static void show(String s, int... arr){
		System.out.print(s + " ");
		System.out.println(Arrays.toString(arr));
	}
	
	
	//方式二：
	/*
	public static void show(int[] arr){
		for(int i : arr){
			System.out.print(i + ", ");
		}
	}
	*/
	
	//方式一：
	/*
	public static void show(int a ,int b){
		System.out.println(a + ":" + b);
	}
	public static void show(int a ,int b, int c){
		System.out.println(a + ":" + b + ":" + c);
	}
	*/

}
