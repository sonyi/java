package generic;
/*
	���Ͷ����ڽӿ��ϣ�
 */
public class GenericDemo5 {
	public static void main(String[] args) {
		
		/*��ʽһ��������������ָ������
		InterImpl i = new InterImpl();
		i.show("hahaha");
		*/
		
		//��ʽ�����ɵ�������ָ����������
		InterImpl<Integer> i = new InterImpl<Integer>();
		i.show(5);
		
	}
}

//��ʽ����ʵ�ֽӿ�ʱҲ��֪���������ͣ�������ӿ�����һ��
class InterImpl<T> implements Inter<T>{
	public void show(T t){
		System.out.println("show:" + t);
	}
}


/*��ʽһ��ʵ�ֽӿ�ʱ��ָ������
class InterImpl implements Inter<String>{
	public void show(String t){
		System.out.println("show:" + t);
	}
}
*/

interface Inter<T>{
	void show(T t);
}