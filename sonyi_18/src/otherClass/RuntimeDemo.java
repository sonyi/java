package otherClass;
/*
	Runtime����
		���ಢû���ṩ���캯����˵��������new������ô��ֱ���뵽�����еķ������Ǿ�̬�ġ�
		���Ƿ��ָ����л��зǾ�̬������˵������϶����ṩ������ȡ������󡣶��Ҹ÷�����
			��̬�ġ�������ֵ�����Ǳ������͡����������ģʽ��
		�÷�����static getRuntime();
		������ص���Կ�������ʹ���˵������ģʽ��ɡ�
 */
public class RuntimeDemo {

	public static void main(String[] args) throws Exception{//������쳣
		Runtime r = Runtime.getRuntime();
		Process p = r.exec("D:\\Program Files (x86)\\Tencent\\QQ\\QQProtect\\Bin\\QQProtect.exe");//����һ���ӽ���
		Thread.sleep(400);
		p.destroy();//�������߳�
	}
}
