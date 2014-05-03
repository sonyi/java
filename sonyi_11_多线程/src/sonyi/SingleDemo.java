package sonyi;
/*
//�������ģʽ��

 */
public class SingleDemo {
	public static void main(String[] args) {
		Single s = Single.getInstance();
	}
}

//����ʽ��ʵ��ͬʱ����
/*
class Single {
	private static final Single s = new Single();
	private Single(){//���캯��˽�У��ⲿ�����Խ�������
		
	}
	public static Single getInstance(){
		return s;
	}
}
*/

//����ʽ��ʵ�����ӳټ���
class Single{
	private static Single s = null;
	private Single(){//���캯��˽�У��ⲿ�����Խ�������
		
	}
	
	public static Single getInstance(){
		//˫���жϣ��ڶ��߳��У�ֻҪ�д���һ������֮��֮��������߳�ֱ���ж�����(s == null),
		//���������ж�ͬ�����������Ч�ʡ�ͬ������֤�˶����Ψһ�ԡ�
		if(s == null){
			synchronized (Single.class) {//��̬�в�������this��Ϊ���������ø�����ֽ��������Ϊ��
				if(s == null)
					s = new Single();
			}		
		}
		return s;
	}
}





