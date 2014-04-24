package cn.imcore.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class TestOutputStream {


	public static void main(String[] args) {
		File f = new File("data/out.txt");
		if(!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("�ļ������ɹ�");
		}

		//�����ǵ���Ϣд����ǰ�ļ�
		OutputStream os = null;
		try {
			os = new FileOutputStream(f);
			byte[] buf = new byte[]{65,66,67,68,69};
			String s = "fldjfdsjfldsjfls";
			os.write(98);//�ַ� b
			os.write(buf);
			os.write(s.getBytes());//���ַ���ת���ֽ����� getBytes()
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(os!=null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
