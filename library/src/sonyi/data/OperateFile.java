package sonyi.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class OperateFile {
	
	public void writeOperate(File f, String s) throws FileNotFoundException{
		PrintWriter ps = new PrintWriter(new FileOutputStream(f,true));
		ps.println(s);
		ps.flush();
		ps.close();
	}
	
	public ArrayList<ArrayList<String>> readOperate(File f) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
		ArrayList<ArrayList<String>> da = new ArrayList<ArrayList<String>>();
		
		String line = null;
		while((line = br.readLine()) != null){
			System.out.println(line);
			String[] s = line.split(",");
			ArrayList<String> dataline = new ArrayList<>();
			for(String str : s){
				dataline.add(str);
			}
			da.add(dataline);
		}
		br.close();
		return da;
	}
}
