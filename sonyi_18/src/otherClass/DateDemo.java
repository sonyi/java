package otherClass;

import java.text.SimpleDateFormat;
import java.util.Date;
public class DateDemo {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);//��ӡ��ʱ�俴������ϣ���и�ʽ
		//��ģʽ��װ��SimpleDateFormat������
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��  E hh:mm:ss");
		//����format������ģʽ��ʽ��ָ��Date����
		String time = sdf.format(date);
		System.out.println("time = " + time);
	}
}
