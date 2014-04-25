package otherClass;

import java.util.Calendar;
/*
 * 课后练习：
 * 		1、获取任意年的二月份有多少天
 * 			思路：
 * 				根据指定年设置一个时间就是：c.set(year,2,1)//某年的3月1日
 * 				c.add(Calender.DAY-OF_MONTH,-1)//3月1日往前推一天，就是2月的最后一天
 * 		2、获取昨天的现在这个时刻。
 * 			c.add(Calendar.DAY_OF_MONTH,-1);
 */
public class CalendarDemo2 {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2012,3,20);
		printCalendar(calendar);
		calendar.add(Calendar.MONTH, 3);
		printCalendar(calendar);//对时间量的偏移	
	}
	
	public static void printCalendar(Calendar c){
		sop(c.get(Calendar.YEAR) + "年" + (c.get(Calendar.MONTH)+1) + "月" 
				+ c.get(Calendar.DAY_OF_MONTH) + "日   "
				+ "星期" + c.get(Calendar.DAY_OF_WEEK));
		String[] weeks = {"","星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
		int index = c.get(Calendar.DAY_OF_WEEK);
		sop(weeks[index]);
	}
	public static void sop(Object o) {
		System.out.println(o);
	}
}
