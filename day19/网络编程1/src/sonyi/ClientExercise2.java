package sonyi;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
		new FrameDemo();
		Socket s = new Socket("127.0.0.1",20001);	
		
		new Thread(new ReadClientThread(s)).start();
		new Thread(new WriteClientThread(s)).start();	
		
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
				
				FrameDemo.tAreaUp.append(line);
				//System.out.println(Utils.getInString);	
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}


class WriteClientThread implements Runnable{
	private Socket s;
	WriteClientThread(Socket s){
		this.s = s;
	}
	
	@Override
	public void run() {
		try {
			OutputStream osOut = s.getOutputStream();
			while(true){		
				Thread.currentThread().setName("客户端");
				String line = Utils.getOutString;
				if(line != null){
					osOut.write((Thread.currentThread().getName() + line).getBytes());
					if ("over".equals(line)) {
						System.exit(0);
					}
				}
				
			}		
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}	
}

class Utils{
	public static String getInString = null;
	public static String getOutString = null;
	
}

class FrameDemo {
	private Frame frame;
	public static TextArea tAreaUp;
	private TextArea tAreaDown;	
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
		tAreaDown.addKeyListener(new KeyAdapter() {
				@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					Utils.getOutString = tAreaDown.getText();
					tAreaDown.setText("");
					Utils.getOutString = null;
				}
			}
		});
		
	}
}