package otherClass;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarDemo {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		sop(calendar);
		sop(calendar.get(Calendar.YEAR) + "��" + (calendar.get(Calendar.MONTH)+1) + "��" 
				+ calendar.get(Calendar.DAY_OF_MONTH) + "��   "
				+ "����" + calendar.get(Calendar.DAY_OF_WEEK));
		
		String[] weeks = {"","������","����һ","���ڶ�","������","������","������","������"};
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
