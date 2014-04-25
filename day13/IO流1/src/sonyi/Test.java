package sonyi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		File fileOut = new File("test/textOut.txt");
		File fileIn = new File("test/textIn.txt");
		System.out.println(fileOut.exists());
		if(!fileOut.exists()){
			try {
				fileOut.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(!fileIn.exists()){
			try {
				fileIn.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		fileStream(fileOut, fileIn);
		
	}
	
	public static void fileStream(File fileOut,File fileIn){
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(fileOut);
			fileInputStream = new FileInputStream(fileIn);
			byte[] temp = new byte[1024];
			int len = 0;
			while(len != -1){
				len = fileInputStream.read(temp);
				fileOutputStream.write(temp);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				fileOutputStream.close();
				fileInputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
