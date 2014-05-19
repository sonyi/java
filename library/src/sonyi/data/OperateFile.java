package sonyi.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Vector;

public class OperateFile {
	
	public void writeOperate(File f, Vector<String> v,boolean flag) throws FileNotFoundException{
		PrintWriter ps = new PrintWriter(new FileOutputStream(f,flag));
		String line = null;
		if(v != null){
			line = v.get(0);
			if(v.size() > 1){
				for(int i = 1; i < v.size(); i++){
					line += "," + v.get(i);
				}
			}
			ps.println(line);
			ps.flush();
		}
		ps.close();
	}
	
	public Vector<Vector<String>> readOperate(File f) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
		Vector<Vector<String>> da = new Vector<Vector<String>>();
		String line = null;
		while((line = br.readLine()) != null){
			Vector<String> al = new Vector<>();
			String[] str = line.split(",");
			for(String string : str){
				al.add(string);
			}
			da.add(al);		
		}
		br.close();
		return da;
	}
	
	public void reviseFile(File f,Vector<String> oldData,Vector<String> newData) throws IOException{
		Vector<Vector<String>> data = readOperate(f);
		int index = data.indexOf(oldData);
		data.remove(index);
		if(newData != null){
			data.add(index, newData);
		}
		writeOperate(f, null, false);
		for(Vector<String> v : data){
			writeOperate(f, v,true);
		}
	}
}
