package otherClass;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarDemo {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		sop(calendar);
		sop(calendar.get(Calendar.YEAR) + "年" + (calendar.get(Calendar.MONTH)+1) + "月" 
				+ calendar.get(Calendar.DAY_OF_MONTH) + "日   "
				+ "星期" + calendar.get(Calendar.DAY_OF_WEEK));
		
		String[] weeks = {"","星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
		int index = calendar.get(Calendar.DAY_OF_WEEK);
		sop(weeks[index]);
		/*
		Date date = new Date();
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy");
		String year = sdf.format(date);
		System.out.println(year);
		*/
	}
	public static void sop(Object o) {
		System.out.println(o);
	}
}
