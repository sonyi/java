package file;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	打印流：
		该流提供了打印的方法，可以将各种数据类型的数据都原样打印
		
	字节打印流:
		PrintStream:
			构造函数可以直接接受的参数类型：
				1、file对象:File
				2、字符串路径：String
				3、字节输出流：OutputStream
				
	字节打印流：
		PrintWriter:
			构造函数可以直接接受的参数类型：
				1、file对象:File
				2、字符串路径：String
				3、字节输出流：OutputStream
				4、字符输出流：Writer
 */
public class PrintStreamDemo {
	public static void main(String[] args) {
		BufferedReader br = null;
		br = new BufferedReader(new InputStreamReader(System.in));

	}
}
