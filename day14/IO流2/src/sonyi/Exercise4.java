package sonyi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Exercise4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File fIn = new File("exercise4/utf-8.txt");
		File fOut = new File("exercise4/gbk.txt");
		//第一步：将utf-8的内容复制到gbk中
		copy(fIn, fOut);
		
		//第二步：在gbk末尾追加内容
//		append(fOut, "你好，很高兴见到你！");
//		append(fOut, "欢迎光临，下次再来!");
		
		//第三步：将gbk追加后的内容复制到utf-8中
//		cover(fOut, fIn);
	}
	
	//用一个文件覆盖另一个文件
	public static void cover(File from,File to){
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		try {
			bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(from),"gbk"));//在第二层声明转码格式
			bufferedWriter = new BufferedWriter(
					new OutputStreamWriter(
							new FileOutputStream(to),"utf-8"));
			
			String string = null;
			while((string = bufferedReader.readLine()) != null){
				System.out.println(string);
				bufferedWriter.write(string + "\n");	
				bufferedWriter.flush();//刷新缓冲区，将信息传入到指定文件中
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(bufferedReader != null)
				try {
					bufferedReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(bufferedWriter != null)
				try {
					bufferedWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}	
	}
	
	//在一个文件末尾追加内容
	public static void append(File file,String string){
		
		OutputStreamWriter outputStreamWriter = null;
		
		try {
			outputStreamWriter = new OutputStreamWriter(
					new FileOutputStream(file,true),"gbk");//在第一层内声明true，即在末尾追加
			outputStreamWriter.write(string + "\n");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(outputStreamWriter != null)
			try {
				outputStreamWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//将一个文件内容复制到另一个文件的内容
	public static void copy(File fIn,File fOut){
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		try {
			bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(fIn),"utf-8"));
			bufferedWriter = new BufferedWriter(
					new OutputStreamWriter(
							new FileOutputStream(fOut),"gbk"));
			
			String string = null;
			while((string = bufferedReader.readLine()) != null){
				System.out.println(string);
				bufferedWriter.write(string + "\n");	
				bufferedWriter.flush();
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(bufferedReader != null)
				try {
					bufferedReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(bufferedWriter != null)
				try {
					bufferedWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
