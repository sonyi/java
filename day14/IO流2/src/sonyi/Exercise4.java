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
		//��һ������utf-8�����ݸ��Ƶ�gbk��
		copy(fIn, fOut);
		
		//�ڶ�������gbkĩβ׷������
//		append(fOut, "��ã��ܸ��˼����㣡");
//		append(fOut, "��ӭ���٣��´�����!");
		
		//����������gbk׷�Ӻ�����ݸ��Ƶ�utf-8��
//		cover(fOut, fIn);
	}
	
	//��һ���ļ�������һ���ļ�
	public static void cover(File from,File to){
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		try {
			bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(from),"gbk"));//�ڵڶ�������ת���ʽ
			bufferedWriter = new BufferedWriter(
					new OutputStreamWriter(
							new FileOutputStream(to),"utf-8"));
			
			String string = null;
			while((string = bufferedReader.readLine()) != null){
				System.out.println(string);
				bufferedWriter.write(string + "\n");	
				bufferedWriter.flush();//ˢ�»�����������Ϣ���뵽ָ���ļ���
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
	
	//��һ���ļ�ĩβ׷������
	public static void append(File file,String string){
		
		OutputStreamWriter outputStreamWriter = null;
		
		try {
			outputStreamWriter = new OutputStreamWriter(
					new FileOutputStream(file,true),"gbk");//�ڵ�һ��������true������ĩβ׷��
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
	
	//��һ���ļ����ݸ��Ƶ���һ���ļ�������
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
