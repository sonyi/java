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

	public void writeOperate(File f, Vector<String> v,boolean flag) throws FileNotFoundException{//往文件中写入数据
		PrintWriter ps = new PrintWriter(new FileOutputStream(f,flag));//创建输出流，用flag标记是追加数据还是覆盖数据
		String line = null;
		if(v != null){//判断写入的数据是否为空
			line = v.get(0);
			if(v.size() > 1){
				for(int i = 1; i < v.size(); i++){
					line += "@@" + v.get(i);//用“@@”作为数据分隔符
				}
			}
			ps.println(line);
			ps.flush();
		}
		ps.close();
	}
	

	public Vector<Vector<String>> readOperate(File f) throws IOException{//读取文件中数据
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
		Vector<Vector<String>> da = new Vector<Vector<String>>();
		String line = null;
		while((line = br.readLine()) != null){
			Vector<String> al = new Vector<>();
			String[] str = line.split("@@");//用“@@”切割数据，返回
			for(String string : str){
				al.add(string);
			}
			da.add(al);		
		}
		br.close();
		return da;
	}
	

	public void reviseFile(File f,Vector<String> oldData,Vector<String> newData) throws IOException{//修改文件中数据并保存
		Vector<Vector<String>> data = readOperate(f);//读取文件信息
		int index = data.indexOf(oldData);//寻找是否有需要修改的数据
		data.remove(index);//移除要修改的数据
		if(newData != null){
			data.add(index, newData);//添加修改的数据
		}
		writeOperate(f, null, false);//情况文件数据
		for(Vector<String> v : data){//将修改后的数据写入文件
			writeOperate(f, v,true);
		}
	}
}
