package otherClass;

import java.util.Properties;

/*
	System:���еķ��������Զ��Ǿ�̬�ġ�
		out����׼�����Ĭ���ǿ���̨
		in����׼���룬Ĭ���Ǽ���
		
		����ϵͳһЩ��Ϣ��
			��ȡϵͳ������Ϣ��Properties gerProperties();
 */
public class SysteDemo {
	public static void main(String[] args) {
		
		Properties prop = System.getProperties();
		//��ΪProperties��Hashtable�����࣬Ҳ����Map���ϵ�һ���������
		//��ô����ͨ��map�ķ���ȡ���ü����е�Ԫ�ء�
		//�ü����д洢�����ַ�����û�з��Ͷ���
			
		//�����ϵͳ���Զ���һЩ���е���Ϣ�أ�
		System.setProperty("mykey","myvalue");
		
		//��ȡָ��������Ϣ
		String value = System.getProperty("os.name");
		System.out.println("value = " + value);
		
		//�ɲ����������������ʱ��̬�ļ���һЩ������Ϣ
		String v = System.getProperty("haha");
		System.out.println("v = " + v);
	
		/*��ȡ����������Ϣ
		for(Object obj : prop.keySet()){
			String value = (String)prop.get(obj);
			System.out.println(obj + "::" + value);
		}
		*/
	}
}
