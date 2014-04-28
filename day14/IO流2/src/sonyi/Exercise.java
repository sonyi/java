package sonyi;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//×Ö·ûÁ÷Á·Ï°
public class Exercise {

	public static void main(String[] args) {
		File fIn = new File("sonyi/fIn.txt");
		File fOut = new File("sonyi/fOut.txt");
		
		if(!fIn.exists()){
			try {
				fIn.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(!fOut.exists()){
			try {
				fOut.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		readAndWrite(fIn, fOut);
	}
	
	public static void readAndWrite(File fIn,File fOut){
		FileReader fileReader = null;
		FileWriter fileWriter = null;
		
		try {
			fileReader = new FileReader(fIn);
			fileWriter = new FileWriter(fOut);
			char[] temp = new char[1024];
			while((fileReader.read(temp)) != -1){
				fileWriter.write(temp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(fileReader != null)
				try {
					fileReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(fileWriter != null){
				try {
					fileWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}	
	}
}
