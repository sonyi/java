package sonyi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
		
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
		String s = "sclsjd15s4faadf¿≤¿≤";
		try {
			fileOutputStream = new FileOutputStream(fileOut);
			fileOutputStream.write(s.getBytes());
			fileInputStream.read();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				fileOutputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		

	}

}
