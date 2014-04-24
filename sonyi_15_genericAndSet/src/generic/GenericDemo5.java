package generic;
/*
	泛型定义在接口上：
 */
public class GenericDemo5 {
	public static void main(String[] args) {
		
		/*方式一：调用者无需再指定类型
		InterImpl i = new InterImpl();
		i.show("hahaha");
		*/
		
		//方式二：由调用者来指定泛型类型
		InterImpl<Integer> i = new InterImpl<Integer>();
		i.show(5);
		
	}
}

//方式二：实现接口时也不知道泛型类型，保持与接口类型一致
class InterImpl<T> implements Inter<T>{
	public void show(T t){
		System.out.println("show:" + t);
	}
}


/*方式一：实现接口时就指定类型
class InterImpl implements Inter<String>{
	public void show(String t){
		System.out.println("show:" + t);
	}
}
*/

interface Inter<T>{
	void show(T t);
}