package otherClass;

import java.text.SimpleDateFormat;
import java.util.Date;
public class DateDemo {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);//打印的时间看不懂，希望有格式
		//将模式封装到SimpleDateFormat对象中
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  E hh:mm:ss");
		//调用format方法让模式格式化指定Date对象
		String time = sdf.format(date);
		System.out.println("time = " + time);
	}
}
