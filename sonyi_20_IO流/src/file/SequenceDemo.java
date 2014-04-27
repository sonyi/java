package file;
/*
	Sequence:将多个流合并成一个流(将多个文件合并成一个文件)
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class SequenceDemo {
	public static void main(String[] args) {
		Vector<FileInputStream> v = new Vector<FileInputStream>();		
		SequenceInputStream sis = null;
		FileOutputStream fos = null;
		try {	
			v.add(new FileInputStream("1.txt"));
			v.add(new FileInputStream("2.txt"));
			v.add(new FileInputStream("3.txt"));
			Enumeration<FileInputStream> en = v.elements();
			sis = new SequenceInputStream(en);
			
			fos = new FileOutputStream("4.txt");
			byte[] buf = new byte[1024];
			int len = 0;
			while((len = sis.read(buf)) != -1){
				fos.write(buf,0,len);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				if(fos != null)
					fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(sis != null)
					sis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
