import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
	读取键盘录入
		System.out:对应的是标准的输出设备，控制台
		System.in:对应的是标准输入设备，键盘
		
	需求：
		通过键盘录入数据，当录入一行数据后，就将该行数据进行打印，
		如果录入的数据是over，那么停止录入
		
	流操作的基本规律：
		最痛苦的就是流对象很多，不知道该用哪一个。
		通过三个明确来完成：
			1、明确源和目的。
				源：输入流。InputStream   Reader
				目的：输出流。 OutputStream   Writer.
			2、操作的数据是否是纯文本。
				是：字符流
				不是：字节流
			3、当体系明确后，在明确要使用哪个具体的对象
				通过设备来进行区分：
					源设备：内存，键盘，硬盘
					目的设备：内存，硬盘，控制台
 */
public class ReaderIn {
	public static void main(String[] args) {
		BufferedReader br = null;
		BufferedWriter bw = null;	
		try {
			//键盘的最常见写法
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			String line = null;
			while ((line = br.readLine()) != null) {
				if("over".equals(line))
					break;
				bw.write(line.toUpperCase());
				bw.newLine();
				bw.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				if(br != null)
					br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(bw != null)
					bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
