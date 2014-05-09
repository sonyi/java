//ServerInterface.java

package chat;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
//主界面类
public class ServerInterface extends JFrame
{
	protected JButton bExit;
	protected JButton bKickOut;
	protected JTextArea taMessages;
	
	DefaultListModel clientList;
	protected JList lstClients;
	
	protected JToolBar tbServer;
	protected JButton btbKickOut;
	protected JButton btbExit;
	protected JButton btbConfigure;
	protected JButton btbHelp;
	
	protected JMenuBar menuBar;
	protected JMenu hlpMenu;
	protected JMenu fileMenu;
	protected JMenuItem exitFMenu;
	protected JMenuItem	webHlpMenu;
	protected JMenuItem helpHlpMenu;
	protected JMenuItem aboutHlpMenu;
	protected JMenuItem configureFMenu;
	
	
	protected JScrollPane scrlClients;
	
	protected ChatServer server;
	
	ServerInterface( ChatServer server )
	{
		super( "Fruit Cha(a)t Piyala" );
		
		this.server = server;
		
		setUpMenu();
		setUpToolBar();
		setUpMainInterface();		
		setVisible( true );
	}
	
	protected void setUpMenu()
	{
		exitFMenu = new JMenuItem("ShutDown",KeyEvent.VK_S);
		webHlpMenu = new JMenuItem("Fruit Cha(a)t on the Web",
				KeyEvent.VK_W);
		helpHlpMenu = new JMenuItem("Help",KeyEvent.VK_H);
		aboutHlpMenu = new JMenuItem("About",KeyEvent.VK_A);
		configureFMenu = new JMenuItem("Configure Server",
				KeyEvent.VK_C);
		
		fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		fileMenu.add(configureFMenu);
		fileMenu.add(exitFMenu);
		
		hlpMenu = new JMenu("Help");
		hlpMenu.setMnemonic(KeyEvent.VK_H);
		hlpMenu.add(helpHlpMenu);
		hlpMenu.addSeparator();
		hlpMenu.add(webHlpMenu);
		hlpMenu.add(aboutHlpMenu);
		
		menuBar = new JMenuBar();
		menuBar.add(fileMenu);
		menuBar.add(hlpMenu);
		setJMenuBar(menuBar);
	}
	
	protected void setUpToolBar()
	{
		tbServer = new JToolBar();
		btbKickOut = new JButton(new ImageIcon(
				"Icons/Bear.gif"));
		btbExit = new JButton(new ImageIcon(
				"Icons/Bear.gif") );
		btbConfigure = new JButton(new ImageIcon(
				"Icons/Bear.gif"));
		btbHelp = new JButton( new ImageIcon(
				"Icons/Bear.gif"));
		
		btbExit.setToolTipText("Exit");
		btbConfigure.setToolTipText("Configure");
		btbHelp.setToolTipText("Help");
		btbKickOut.setToolTipText("KickOut");
		
		tbServer.add( btbConfigure );
		tbServer.add( btbKickOut );
		tbServer.add( btbExit );
		//tbServer.addSeparator();
		
		tbServer.setFloatable(false);
		tbServer.setRollover(true);
		
		tbServer.add( btbHelp );
	}
	
	protected void setUpListeners()
	{
		btbExit.addActionListener(new ExitButton());
		btbConfigure.addActionListener(new ConfigureFMenu());
		btbHelp.addActionListener(new HelpHlpMenu());
		btbKickOut.addActionListener( new KickOutButton());		
		exitFMenu.addActionListener(new ExitButton());
		configureFMenu.addActionListener( new ConfigureFMenu());
		helpHlpMenu.addActionListener( new HelpHlpMenu() );
		webHlpMenu.addActionListener( new WebHlpMenu() );
		aboutHlpMenu.addActionListener( new AboutHlpMenu() );
		
		bExit.addActionListener( new ExitButton() );
		lstClients.addListSelectionListener( 
				new clientSelected() );
		bKickOut.addActionListener( new KickOutButton() );
		
		addWindowListener( new OnExit() );
	}
	
	protected void setUpProperties()
	{
		setSize(570,415);
		setResizable(false);
		
		taMessages.setLineWrap(true);
		taMessages.setEditable(false);
		
		lstClients.setFixedCellWidth(100);
		lstClients.setSelectionMode( ListSelectionModel.
				SINGLE_SELECTION );
		
		bKickOut.setEnabled(false);
		
		scrlClients = new JScrollPane( lstClients );
		scrlClients.setColumnHeaderView( new JLabel(
				"Online Users" ) );
		
		setUpListeners();
	}
	
	protected void setUpMainInterface()
	{
		bExit = new JButton( "Shut Down" );
		bKickOut = new JButton( "Kick Out" );			
		
		taMessages = new JTextArea( 20,40 );			
		
		clientList = new DefaultListModel();
		lstClients = new JList( clientList );			
		
		
		setUpProperties();
		
		Box toolbarBox = Box.createHorizontalBox();
		toolbarBox.add( tbServer );
		
		Box displayBox = Box.createHorizontalBox();
		displayBox.add(  new JScrollPane( taMessages ));
		displayBox.add( scrlClients );
		
		Box buttonBox = Box.createHorizontalBox();
		buttonBox.add( bKickOut );
		buttonBox.add( Box.createHorizontalStrut(10));
		buttonBox.add( bExit );
		
		Container cp = 	this.getContentPane();
		cp.setLayout( new FlowLayout( FlowLayout.CENTER ));
		//cp.add( toolbarBox );
		cp.add( displayBox );
		cp.add( buttonBox );
	}	
	class OnExit  extends WindowAdapter 
	implements WindowListener {
		public void windowClosing(WindowEvent we) {
			server.shutDown();
		}
	}	
	class ExitButton implements ActionListener	{
		public void actionPerformed( ActionEvent e ){
			server.shutDown();
		}
	}	
	class KickOutButton implements ActionListener{
		public void actionPerformed( ActionEvent e ) {
			//获取被剔除的用户的索引号
			ChatServer.ChatHandler client = (ChatServer.ChatHandler)
			server.handlers.elementAt( 
					lstClients.getSelectedIndex());
			try	{
				//通知用户
				client.out.writeObject( new KickedOutNotice() );
			}
			catch( IOException w )
			{}			
			//停止处理
			client.stop();
			bKickOut.setEnabled( false );
			server.onlineUsers--;
		}
	}	
	class clientSelected implements ListSelectionListener {
		public void valueChanged( ListSelectionEvent e ){
			bKickOut.setEnabled(true);
		}
	}
	
	class AboutHlpMenu implements ActionListener {
		public void actionPerformed( ActionEvent e ){
			JOptionPane.showMessageDialog( server.window, 
					"Fruit Cha(a)t Server" 	+
					"\nVersion 0.7 \nThis software is " +
					"distributed under the GPL Liscence",
				"About Fruit Cha(a)t", JOptionPane.
				INFORMATION_MESSAGE );
		}
	}
	
	class HelpHlpMenu implements ActionListener	{
		public void actionPerformed( ActionEvent e ){
			/* 提供一定的帮助*/
		}
	}
	
	class WebHlpMenu implements ActionListener	{
		public void actionPerformed( ActionEvent e ){
			JOptionPane.showMessageDialog( server.window,
					"For free source code visist " +
					"http://akbani.20m.com.", 
					"Fruit Cha(a)t on the WEB", 
					JOptionPane.INFORMATION_MESSAGE );
		}
	}
	
	class ConfigureFMenu implements ActionListener	{
		public void actionPerformed( ActionEvent e ){
			ConfigureServerInfo serverDialog = new
			ConfigureServerInfo();
		}
	}	
	//创建并显示配置信息界面
	class ConfigureServerInfo extends JDialog {
		JButton bSave = new JButton("Save");
		JButton bCancel = new JButton("Cancel");
		JLabel lbPort = new JLabel("Port Number : ");
		JLabel lbLimit = new JLabel("Client Limit :    ");
		JTextField tfLimit = new JTextField(6);
		JTextField tfPortNo = new JTextField(6);		
		ConfigureServerInfo(){
			super(server.window,"Configure Server",true);			
			Box buttonBox = Box.createHorizontalBox();
			buttonBox.add( Box.createHorizontalStrut(15) );
			buttonBox.add(bSave);
			buttonBox.add(bCancel);			
			Container jcp = this.getContentPane();
			jcp.setLayout( new FlowLayout(FlowLayout.LEFT) );
			jcp.add(lbPort);
			jcp.add(tfPortNo);
			jcp.add( lbLimit );
			jcp.add( tfLimit );
			jcp.add( buttonBox );			
			bSave.addActionListener( new SaveButton() );
			bCancel.addActionListener( new CancelButton() );			
			server.getConfiguration();			
			tfPortNo.setText( Integer.toString(
					server.serverPort ) );
			tfLimit.setText( Integer.toString( 
					server.serverLimit ) );			
			this.setSize(180,115);			
			Point position = server.window.getLocation();
			position.x = position.x + (server.window.
					getWidth()/2) - (this.getWidth()/2);
			position.y = position.y + (server.window.
					getHeight()/2) - (this.getHeight()/2);
			this.setLocation( position );			
			this.setVisible(true);
			this.setResizable( false );			
		}
		
		class SaveButton implements ActionListener	{
			public void actionPerformed( ActionEvent e ){
				server.setConfiguration( Integer.parseInt(
						tfPortNo.getText()) ,
						Integer.parseInt(tfLimit.getText()) );
				//setVisible(false);
				dispose();
				
			}
		}		
		class CancelButton implements ActionListener {
			public void actionPerformed( ActionEvent e ) {
				dispose();
			}
		}		
	}
}
