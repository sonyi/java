package generic;
/*
	�����ඨ��ķ��ͣ�������������Ч�����������ʹ�ã���ô��������Ķ�����ȷҪ������
		�������ͺ�����Ҫ���������;��Ѿ��̶��ˡ�Ϊ���ò�ͬ�������Բ�����ͬ���ͣ�����
		���ͻ���ȷ������ô���Խ����Ͷ����ڷ����ϡ�
		
	����֮������̬���������Է������϶���ķ��͡������̬���������������������Ͳ�ȷ����
		���Խ����Ͷ����ڷ����ϡ�
	
	����λ�ã����������У��������������棻�����ڷ����У������ڷ���ֵǰ�档(��д��ʽ)
 */

//���Ͷ��������Ϻͷ�����
public class GenericDemo4 {
	public static void main(String[] args) {
		
		/*��ʽһ��
		Demo<Integer> d = new Demo<Integer>();
		d.show(4);
		d.print(new Integer(5));
		
		Demo<String> d1 = new Demo<String>();
		d1.show("hahaha");
		d1.print("hehehe");
		*/
		
		/*��ʽ����
		Demo d = new Demo();
		d.show("hahah");
		d.show(new Integer(4));
		d.print("heihei");
		d.print(5);
		*/
		
		//��ʽ����
		Demo<String> d = new Demo<String>();
		d.show("haha");
		d.print("heihei");
		d.print(9);
		Demo.method("lalalal");
	}
}

//��ʽ�������϶��巺�ͣ�������Ҳ�������ⶨ�巺�͡�
class Demo<T>{
	public void show(T t){
		System.out.println("show:" + t);
	}
	public <Q>void print(Q q){
		System.out.println("print:" + q);
	}
	public static<W> void method(W w){
		System.out.println("method:" + w);
	}
	
	//��̬���������Է������϶���ķ��ͣ����Խ����Ͷ����ڷ�����
//	public static void method(T t){
//		System.out.println("method:" + t);
//	}
}


/*��ʽ��������ֻ�����ڷ�����
class Demo{
	public <T>void show(T t){
		System.out.println("show:" + t);
	}
	public <Q>void print(Q q){
		System.out.println("print:" + q);
	}
}
*/

/*��ʽһ���������������һ��
class Demo<T>{
	public void show(T t){
		System.out.println("show:" + t);
	}
	public void print(T t){
		System.out.println("print:" + t);
	}
}
*/