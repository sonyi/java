package chatDemo;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;


public class FrameDemo {
	private Socket s;
	private Frame frame;
	public static TextArea tAreaUp;
	private TextArea tAreaDown;	
	private String write = null;
	public FrameDemo(Socket s) {
		this.s = s;
		init();
	}

	public void init(){
		frame = new Frame("¿Í»§¶Ë");
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
					write = tAreaDown.getText();
					tAreaDown.setText("");
					try {
						writeOut();
						readIn();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
				}
			}
		});
		
	}
	
	public void writeOut() throws IOException{
		PrintWriter pwOut = new PrintWriter(s.getOutputStream());
		pwOut.println(write);
		write = null;
		pwOut.close();
	}
	
	public void readIn() throws IOException{
		InputStream isIn = s.getInputStream();
		byte[] buf = new byte[1024];
		int len = isIn.read(buf);
		String line = new String(buf,0,len);
		tAreaUp.append(line);
		isIn.close();
	}

}
