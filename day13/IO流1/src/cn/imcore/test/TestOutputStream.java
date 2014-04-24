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
			System.out.println("文件创建成功");
		}

		//把我们的信息写到当前文件
		OutputStream os = null;
		try {
			os = new FileOutputStream(f);
			byte[] buf = new byte[]{65,66,67,68,69};
			String s = "fldjfdsjfldsjfls";
			os.write(98);//字符 b
			os.write(buf);
			os.write(s.getBytes());//把字符串转成字节数组 getBytes()
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
