package otherClass;

import java.util.Calendar;
/*
 * �κ���ϰ��
 * 		1����ȡ������Ķ��·��ж�����
 * 			˼·��
 * 				����ָ��������һ��ʱ����ǣ�c.set(year,2,1)//ĳ���3��1��
 * 				c.add(Calender.DAY-OF_MONTH,-1)//3��1����ǰ��һ�죬����2�µ����һ��
 * 		2����ȡ������������ʱ�̡�
 * 			c.add(Calendar.DAY_OF_MONTH,-1);
 */
public class CalendarDemo2 {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2012,3,20);
		printCalendar(calendar);
		calendar.add(Calendar.MONTH, 3);
		printCalendar(calendar);//��ʱ������ƫ��	
	}
	
	public static void printCalendar(Calendar c){
		sop(c.get(Calendar.YEAR) + "��" + (c.get(Calendar.MONTH)+1) + "��" 
				+ c.get(Calendar.DAY_OF_MONTH) + "��   "
				+ "����" + c.get(Calendar.DAY_OF_WEEK));
		String[] weeks = {"","������","����һ","���ڶ�","������","������","������","������"};
		int index = c.get(Calendar.DAY_OF_WEEK);
		sop(weeks[index]);
	}
	public static void sop(Object o) {
		System.out.println(o);
	}
}
