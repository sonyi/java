package cn.imcore.prac;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class Test2 {


	public static void main(String[] args) {
		Test2 t = new Test2();
		File utf = new File("data/utf8.txt");
		File gbk = new File("data/gbk.txt");//默认空内容

		t.utf8ToGbk(utf, gbk);//把utf8.txt复制到gbk.txt
		t.append(gbk);//gbk.txt追加3行内容
		t.GbkToutf8(utf, gbk);//gbk.txt覆盖utf8.txt
	}

	
	public void utf8ToGbk(File utf, File gbk) {
		BufferedReader br = null;//
		BufferedWriter bw = null;
		try {
			br = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(utf)
							,"utf-8")
					);
			bw = new BufferedWriter(
					new OutputStreamWriter(
							new FileOutputStream(gbk)
							,"gbk")
					);
			
			String str;
			while((str = br.readLine()) != null) {
				bw.write(str);
				bw.newLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	//=======================
	
	public void append(File f) {
		Writer w = null;
		try {
			w = new FileWriter(f, true);
			w.write("字节流通向字符流的桥梁 \r\n");
			w.write("字节流通向字符流的桥梁 \r\n");
			w.write("字节流通向字符流的桥梁 \r\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(w != null) {
				try {
					w.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	//===================
	public void GbkToutf8(File utf, File gbk) {
		BufferedReader br = null;//
		BufferedWriter bw = null;
		try {
			br = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(gbk)
							,"gbk")
					);
			bw = new BufferedWriter(
					new OutputStreamWriter(
							new FileOutputStream(utf)
							,"utf-8")
					);
			
			String str;
			while((str = br.readLine()) != null) {
				bw.write(str);
				bw.newLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(bw != null) {
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
