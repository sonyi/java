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
		System.out.println("毫秒数：" + d1.getTime());
		System.out.println("本月的第几天：" + d1.getDate());
		System.out.println("本周的第几天：" + d1.getDay());

		//
		Calendar c = Calendar.getInstance();
		System.out.println("取时间：" + c.getTime());
		System.out.println("取毫秒数：" + c.getTimeInMillis());

		System.out.println("本月的第几天：" + c.get(Calendar.DAY_OF_MONTH));
		System.out.println("本周的第几天：" + c.get(Calendar.DAY_OF_WEEK));
		System.out.println("本年的第几个月：" + (c.get(Calendar.MONTH)+1));
		
		//
		c.set(2013, 3, 5);//月份是从0开始算
		System.out.println("重新设置日期： " + c.getTime());
		
		c.add(Calendar.DAY_OF_MONTH, 10);
		System.out.println("重新设置日期：+10 " + c.getTime());
		
		c.add(Calendar.DAY_OF_MONTH, -30);
		System.out.println("重新设置日期：-30 " + c.getTime());
		
		//
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf1.format(c.getTime()));
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		System.out.println(sdf2.format(c.getTime()));
	}

}
