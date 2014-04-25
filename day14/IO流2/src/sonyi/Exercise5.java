package sonyi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Exercise5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("exercise4/print.txt");
		PrintWriter printWriter = null;
		
		try {
			printWriter = new PrintWriter(file);
			printWriter.write(5);
			printWriter.write("hahah");
			
			printWriter.println(true);
			printWriter.println('d');
			printWriter.println(47);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(printWriter != null)
				printWriter.close();
		}
	}

}
