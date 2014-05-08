package chat_udp;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Chat {
	public static void main(String[] args) {
		MainFrame mf = new MainFrame();
		new Thread(new receive(mf.textAreaReceive)).start();
	}

}

class MainFrame {
	private Frame frame;
	private TextArea textAreaSend;
	public TextArea textAreaReceive;
	
	public MainFrame() {
		init();
	}
	
	public void init(){
		frame = new Frame("¡ƒÃÏ “");
		textAreaReceive = new TextArea();
		textAreaSend = new TextArea();
		
		frame.setBounds(400,100,500,400);
		frame.setLayout(new FlowLayout());
		
		textAreaReceive.setEditable(false);
		
		frame.add(textAreaReceive);
		frame.add(textAreaSend);
		
		myEvent();
		frame.setVisible(true);
	}
	
	public void myEvent() {
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		textAreaSend.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e){
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					String line = textAreaSend.getText();
					if(line != null){
						try {
							send(line);
							textAreaSend.setText("");
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});	
	}
	
	public void send(String s) throws IOException {
		DatagramSocket ds = new DatagramSocket();
		byte[] buf = s.getBytes();
		DatagramPacket dp = new DatagramPacket(buf, buf.length,InetAddress.getByName("127.0.0.1"),21000);		
		ds.send(dp);	
		ds.close();	
	}	
}

class receive implements Runnable {
	private TextArea textArea;
	public receive(TextArea textArea) {
		this.textArea = textArea;
	}
	public void run() {
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket(21000);
			while(true){
				byte[] buf = new byte[1024];
				DatagramPacket dp = new DatagramPacket(buf, buf.length);
				ds.receive(dp);
				String line = new String(dp.getData(),0,dp.getLength());
				textArea.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
