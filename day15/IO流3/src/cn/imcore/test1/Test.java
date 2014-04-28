package cn.imcore.test1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File f = new File("io.txt");
		write(f);
		bufread(f);

	}
	
	public static void bufread(File f){
		BufferedReader br=null;
		try {
			br = new BufferedReader(new FileReader(f));
			String str;
			while((str=br.readLine()) != null){
				System.out.print(str);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void write(File f){
		BufferedWriter bw =null;
		try {
			 bw = new BufferedWriter(new FileWriter(f));
			 bw.write(100);
			 bw.newLine();
			 bw.write("sdfsd");
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(bw != null){
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	

}
