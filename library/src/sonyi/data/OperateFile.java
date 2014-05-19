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

	public void writeOperate(File f, Vector<String> v,boolean flag) throws FileNotFoundException{//���ļ���д������
		PrintWriter ps = new PrintWriter(new FileOutputStream(f,flag));//�������������flag�����׷�����ݻ��Ǹ�������
		String line = null;
		if(v != null){//�ж�д��������Ƿ�Ϊ��
			line = v.get(0);
			if(v.size() > 1){
				for(int i = 1; i < v.size(); i++){
					line += "@@" + v.get(i);//�á�@@����Ϊ���ݷָ���
				}
			}
			ps.println(line);
			ps.flush();
		}
		ps.close();
	}
	

	public Vector<Vector<String>> readOperate(File f) throws IOException{//��ȡ�ļ�������
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
		Vector<Vector<String>> da = new Vector<Vector<String>>();
		String line = null;
		while((line = br.readLine()) != null){
			Vector<String> al = new Vector<>();
			String[] str = line.split("@@");//�á�@@���и����ݣ�����
			for(String string : str){
				al.add(string);
			}
			da.add(al);		
		}
		br.close();
		return da;
	}
	

	public void reviseFile(File f,Vector<String> oldData,Vector<String> newData) throws IOException{//�޸��ļ������ݲ�����
		Vector<Vector<String>> data = readOperate(f);//��ȡ�ļ���Ϣ
		int index = data.indexOf(oldData);//Ѱ���Ƿ�����Ҫ�޸ĵ�����
		data.remove(index);//�Ƴ�Ҫ�޸ĵ�����
		if(newData != null){
			data.add(index, newData);//����޸ĵ�����
		}
		writeOperate(f, null, false);//����ļ�����
		for(Vector<String> v : data){//���޸ĺ������д���ļ�
			writeOperate(f, v,true);
		}
	}
}
