package io.BufferWriter;

import java.io.FileReader;
import java.io.IOException;

/*
	自定义一个类，包含一个功能和readLine一致的方法。
	来模拟一个BufferedReader
	
	装饰设计模式：
		当想要对已有的对象进行功能增强时，可以定义类，将已有对象传入，基于已有的功能，
		并提供增强功能，那么自定义的该类成为装饰类。
	
		装饰类通常会通过构造方法接收被装饰的对象。
		并居于被装饰的对象的功能，提供更强的功能。
		
		装饰模式比继承要灵活，避免了继承体系臃肿，而且降低了类与类之间的关系。
		装饰类因为增强已有对象，具备的功能和已有的是相同的，只不过提供了更强功能，
		所以装饰类和被装饰类通常都是属于一个体系中的。
 */
class MyBufferedReader {
	private FileReader reader;
	MyBufferedReader(FileReader reader){
		this.reader = reader;
	}
	//可以一次读取一行数据的方法
	public String myReadLine() throws IOException{
		//定义一个临时容器，原BufferReader封装的是字符数组
		//为了演示方便，定义一个StringBuilder容器，因为最终还是要将数据变成字符串
		StringBuilder sb = new StringBuilder();
		int ch = 0;
		while((ch = reader.read()) != -1){
			if(ch == '\r')
				continue;
			if(ch == '\n')
				return sb.toString();
			else {
				sb.append((char)ch);
			}
		}
		if(sb.length() != 0){//判断最后一行
			return sb.toString();
		}
		else{
			return null;
		}
	}
	public void myClose() throws IOException{
		reader.close();
	}
}

class MyBufferedReaderDemo{
	public static void main(String[] args){
		FileReader fr = null;
		MyBufferedReader myBuf = null;
		try {
			fr = new FileReader("buf.txt");
			myBuf = new MyBufferedReader(fr);
			String line = null;
			while((line = myBuf.myReadLine()) != null){
				System.out.println(line);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(myBuf != null)
				try {
					myBuf.myClose();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}		
	}
}

