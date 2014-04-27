package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
//Ŀ�ģ���һmp3�ļ��и�ɼ��ݴ洢��Ȼ���ٽ��⼸���ļ��ϲ���һ��mp3�ļ���
public class SplitFile {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//splitFile();
		merge();
	}
	
	//�ϲ��ļ�
	public static void merge(){
		ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();
		int count = 1;
		
		try {
			for(int x = 0; x < 6; x++){
				al.add(new FileInputStream("�и�" + (count++) + ".part"));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final Iterator<FileInputStream> it = al.iterator();
		Enumeration<FileInputStream> en = new Enumeration<FileInputStream>() {

			public boolean hasMoreElements() {
				// TODO Auto-generated method stub
				return it.hasNext();
			}
			public FileInputStream nextElement() {
				// TODO Auto-generated method stub
				return it.next();
			}		
		};
		SequenceInputStream sis = null;
		FileOutputStream fos = null;
		try {
			sis = new SequenceInputStream(en);
			fos = new FileOutputStream("����1.mp3");
			byte[] buf = new byte[1024];
			int len = 0;
			while ((len = sis.read(buf)) != -1) {
				fos.write(buf,0,len);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				if(sis != null)
					sis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(fos != null)
					fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		
	}
	
	//�и��ļ�
	public static void splitFile(){
		FileInputStream fis = null;
		FileOutputStream fos = null;
		File f = null;
		try {
			f = new File("1.mp3");
			System.out.println(f.exists());
			fis = new FileInputStream(f);
			
			byte[] buf = new byte[1024*1024];
			int len = 0;
			int count = 1;
			while((len = fis.read(buf)) != -1){
				System.out.println(buf.toString());
				fos = new FileOutputStream("�и�" + (count++) + ".part");
				fos.write(buf,0,len);
				fos.close();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				if(fis != null)
					fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(fos != null)
					fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
