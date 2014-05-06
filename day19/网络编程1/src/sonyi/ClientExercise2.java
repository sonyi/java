package sonyi;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientExercise2 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//Socket s = new Socket("192.168.1.106",20001);	
		//new Thread(new ReadClientThread(s)).start();
		//new Thread(new WriteClientThread(s)).start();	
		new FrameDemo();
	}
}

class ReadClientThread implements Runnable{
	private Socket s;
	public ReadClientThread(Socket s) {
		this.s = s;
	}
	
	@Override
	public void run() {
		try {
			InputStream isIn = s.getInputStream();
			while(true){		
				byte[] buf = new byte[1024];
				int len = isIn.read(buf);
				String line = new String(buf,0,len);
				System.out.println(line);	
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}


class WriteClientThread implements Runnable{
	private static int index = 1;
	private Socket s;
	Scanner input = new Scanner(System.in);
	WriteClientThread(Socket s){
		this.s = s;
	}
	
	@Override
	public void run() {
		try {
			int i = index++;
			OutputStream osOut = s.getOutputStream();
			while(true){			
				String line = input.nextLine();
				if ("over".equals(line)) {
					System.exit(0);
				}
				Thread.currentThread().setName("客户端" + i);
				osOut.write((Thread.currentThread().getName() + line).getBytes());
			}		
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}	
}

class FrameDemo {
	private Frame frame;
	private TextArea tAreaUp, tAreaDown;
	private TextField tField;
	public FrameDemo() {
		init();
	}
	
	public void init(){
		frame = new Frame("客户端");
		frame.setBounds(300,100,500,400);
		frame.setLayout(new FlowLayout());
		tAreaUp = new TextArea();
		tAreaDown = new TextArea();
		tAreaUp.setEditable(false);
		frame.add(tAreaUp);
		frame.add(tAreaDown);
		
		myEvent();
		frame.setVisible(true);
	}
	
	private void myEvent(){
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
}
