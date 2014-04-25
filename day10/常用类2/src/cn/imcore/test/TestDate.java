package cn.imcore.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Date d1 = new Date();
		System.out.println(d1);
		System.out.println("��������" + d1.getTime());
		System.out.println("���µĵڼ��죺" + d1.getDate());
		System.out.println("���ܵĵڼ��죺" + d1.getDay());

		//
		Calendar c = Calendar.getInstance();
		System.out.println("ȡʱ�䣺" + c.getTime());
		System.out.println("ȡ��������" + c.getTimeInMillis());

		System.out.println("���µĵڼ��죺" + c.get(Calendar.DAY_OF_MONTH));
		System.out.println("���ܵĵڼ��죺" + c.get(Calendar.DAY_OF_WEEK));
		System.out.println("����ĵڼ����£�" + (c.get(Calendar.MONTH)+1));
		
		//
		c.set(2013, 3, 5);//�·��Ǵ�0��ʼ��
		System.out.println("�����������ڣ� " + c.getTime());
		
		c.add(Calendar.DAY_OF_MONTH, 10);
		System.out.println("�����������ڣ�+10 " + c.getTime());
		
		c.add(Calendar.DAY_OF_MONTH, -30);
		System.out.println("�����������ڣ�-30 " + c.getTime());
		
		//
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf1.format(c.getTime()));
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		System.out.println(sdf2.format(c.getTime()));
	}

}
