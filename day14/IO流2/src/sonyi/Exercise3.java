package sonyi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Exercise3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		FileReader fileReader = null;
		DataInputStream dataInputStream = null;
		DataOutputStream dataOutputStream = null;
		PrintWriter printWriter = null;
		
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("sonyi/fIn.txt")));
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("sonyi/fOut.txt")));
			
			String string = null;
			while((string = bufferedReader.readLine()) != null){
				//System.out.println(string);
				bufferedWriter.write(string);
				bufferedWriter.newLine();
				bufferedWriter.flush();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			if(bufferedReader != null)
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if(bufferedWriter != null)
				try {
					bufferedWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
