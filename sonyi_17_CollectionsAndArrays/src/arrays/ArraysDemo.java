package arrays;

import java.util.Arrays;
import java.util.List;

/*
	Arrays:用于操作数组的工具类。里面都是静态方法
		
	asList:将数组变成list集合
 */
public class ArraysDemo {

	public static void main(String[] args) {
		int[] arr = {2,4,5};
		System.out.println(Arrays.toString(arr));

		
		String[] a = {"abc","cc","kkkk"};
		/*
		 * 把数组变成list集合
		 * 好处：可以使用集合的思想和方法来操作数组中的元素
		 * 注意：将数组变成集合，不可以使用集合的增删方法，因为数组的长度是固定的。
		 * 		可以用：contains();get();indexOf();subList();等。。
		 * 		如果增删了，那么会发生UnsupportedOperationException(不支持操作)异常
		 */
		List<String> list = Arrays.asList(a);
		//list.add("qq");//java.lang.UnsupportedOperationException
		System.out.println(list);
		
		
		/*
		 * 如果数组中的元素都是对象，那么变成集合时，数组中的元素就直接转换成集合中的元素
		 * 如果数组中的元素都是基本数据类型，那么会将数组作为集合中的元素存在
		 */
		int[] num = {2,4,5};//数组的元素是基本数据类型
		List<int[]> li = Arrays.asList(num);//注意泛型是int[]
		System.out.println(li);
		
		Integer[] num1 = {2,4,5};//数组的元素是对象
		List<Integer> li1 = Arrays.asList(num1);//注意泛型是Integer
		System.out.println(li1);
		
	}

}
