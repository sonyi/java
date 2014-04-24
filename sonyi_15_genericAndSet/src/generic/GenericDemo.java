package generic;

import java.util.ArrayList;
import java.util.Iterator;
/*
	泛型：JDK1.5版本以后出现的新特性，用于解决安全问题，是一个类型安全机制。
		好处：1、将运行时期出现的问题classCastException，转移到编译时期，方便于程序员解决问题。
				让运行事情问题减少，安全。
			  2、避免了强制类型转换的麻烦。
			  
	泛型格式：通过<>来定义要操作的的引用数据类型。
	在使用java提供的对象时，什么时候写泛型呢？
		通常在集合框架中很常见，只要定义到<>就要定义泛型。
		
	其实<>就是用来接收类型的。
	
	当使用集合时，将集合中要存储的数据类型作为参数传递到<>中即可。
 */
public class GenericDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//<String>泛型，解决数据存储时的数据类型，防止出错
		ArrayList<String> al = new ArrayList<String>();
		al.add("abd01");
		al.add("a01");
		al.add("abd02");
		al.add("ab81");
		al.add("abd0174");
		
		for(Iterator<String> it = al.iterator();it.hasNext();){
			String s = it.next();           //不需要再强制类型转换了
			System.out.println(s + ":" + s.length());
		}		
	}
}
