package ÌâÄ¿1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Test {
	public static void main(String[] args) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream("info.txt")));
			String line = null;
			line = br.readLine();
			System.out.println(line);
			String reline = line.replaceAll("jerry@gmail.com","tony@gmail.com");
			
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("info.txt")));
			bw.write(reline, 0, reline.length());
			bw.flush();
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				if(bw != null)
					bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
