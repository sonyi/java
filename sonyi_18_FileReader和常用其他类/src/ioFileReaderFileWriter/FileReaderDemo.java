package ioFileReaderFileWriter;

//ͨ���ַ����ж�ȡ
import java.io.IOException;
import java.io.FileReader;

public class FileReaderDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����һ���ļ���ȡ�����󣬺�ָ�����Ƶ��ļ������
		//Ҫ��֤���ļ����Ѿ����ڵģ���������ڣ��ᷢ���쳣FileNotFoundException
		FileReader fr = null;
		try {
			fr = new FileReader("demo.txt");
				
			//���ö�ȡ�������read������һ��ֻ��һ���ַ�
			int ch =0;
			while((ch = fr.read()) != -1){
				System.out.println((char)ch);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(fr != null)
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}		
	}
}
