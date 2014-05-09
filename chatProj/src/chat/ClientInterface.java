package chat;
import java.io.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.*;
public class ClientInterface extends JFrame {
	private ChatClient client;	
	//每次创建一个新的对象	
	JList lstClients;//为用户生成列表	
	//保存所有窗口的引用
	protected Vector messageWindows;	
	//提供相应的匹配
	protected Vector tabToClient;
	//发送信息按钮
	protected JButton bSend;
	protected JTextField tfMessage;//文本框	
	protected JScrollPane scrlClients;
	//以下设置各种组件
	protected JMenuBar menuBar;
	protected JMenu hlpMenu;
	protected JMenu tabMenu;
	protected JMenu fileMenu;
	protected JMenuItem exitFMenu;
	protected JMenuItem webHlpMenu;
	protected JMenuItem	helpHlpMenu;
	protected JMenuItem aboutHlpMenu;
	protected JMenuItem closeTabMenu;
	protected JMenuItem connectFMenu;
	protected JMenuItem configureFMenu;
	protected JMenuItem	disconnectFMenu;
	protected JMenuItem closeAllTabsMenu;	
	protected JTabbedPane tbChatWindows;	
	ClientInterface( ChatClient client ){
		super( "Fruit Cha(a)t Plate" );		
		this.client = client;
		//设置菜单栏
		setUpMenu();
		setUpMainInterface();		
		setVisible(true);
		this.setSize(480,330);
		tfMessage.requestFocus();
	}	
	//此函数为设置菜单栏
	protected void setUpMenu(){
		exitFMenu = new JMenuItem("Exit",KeyEvent.VK_X);
		webHlpMenu = new JMenuItem("Fruit Cha(a)t on the WEB");
		helpHlpMenu = new JMenuItem("Help",KeyEvent.VK_H);
		connectFMenu = new JMenuItem("Connect",KeyEvent.VK_C);
		aboutHlpMenu = new JMenuItem("About",KeyEvent.VK_A);
		closeTabMenu = new JMenuItem( "Close Tab",KeyEvent.VK_C );
		configureFMenu = new JMenuItem("Configure Connection");
		disconnectFMenu = new JMenuItem("Disconnect",KeyEvent.VK_D);
		closeAllTabsMenu = new JMenuItem( "Close All Tabs",
				KeyEvent.VK_A );
		//设置文件菜单项，并添加
		fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		fileMenu.add(connectFMenu);
		fileMenu.add(disconnectFMenu);
		fileMenu.add(configureFMenu);
		fileMenu.addSeparator();
		fileMenu.add(exitFMenu);		
		tabMenu = new JMenu( "Tabs" );
		tabMenu.setMnemonic( KeyEvent.VK_T );
		tabMenu.add( closeTabMenu );
		tabMenu.add( closeAllTabsMenu );
		//设置帮助菜单项
		hlpMenu = new JMenu("Help");
		hlpMenu.setMnemonic(KeyEvent.VK_H);
		hlpMenu.add(helpHlpMenu);
		hlpMenu.addSeparator();
		hlpMenu.add(aboutHlpMenu);
		hlpMenu.add(webHlpMenu);
		//设置菜单项
		menuBar = new JMenuBar();
		menuBar.add(fileMenu);
		menuBar.add( tabMenu );
		menuBar.add(hlpMenu);
		setJMenuBar(menuBar);
	}	
	protected void setUpListeners()	{
		//以下为设置上传用户菜单
		configureFMenu.addActionListener(
				new ConfigureFMenu() );
		exitFMenu.addActionListener( new ExitButton() );
		helpHlpMenu.addActionListener( new HelpHlpMenu() );
		aboutHlpMenu.addActionListener( new AboutHlpMenu() );
		webHlpMenu.addActionListener( new WebHlpMenu() );
		connectFMenu.addActionListener( new ConnectFMenu() );
		disconnectFMenu.addActionListener( 
				new DisconnectFMenu() );
		closeTabMenu.addActionListener( new CloseTabButton() );
		closeAllTabsMenu.addActionListener(
				new CloseAllTabsMenu() );		
		bSend.addActionListener( new SendButton() );//添加事件触发
		tfMessage.addActionListener( new SendMessage() );
		//tfMessage.addFocusListener( new FocusMessageField() );		
		lstClients.addMouseListener( new SelectClient() );
		addWindowListener( new OnExit() );
	}	
	protected void setUpProperties(){
		setSize(475,280);//设置大小尺寸
		setResizable(false);//不可改变大小		
		bSend.setEnabled( false );
		tfMessage.setEnabled( false );		
		disconnectFMenu.setEnabled( false );
		tabMenu.setEnabled( false );
		closeTabMenu.setEnabled( false );
		closeAllTabsMenu.setEnabled( false );		
		lstClients.setFixedCellWidth(101);
	    lstClients.setSelectionMode( ListSelectionModel
            .SINGLE_SELECTION );		
		scrlClients = new JScrollPane( lstClients );
		scrlClients.setColumnHeaderView(
				new JLabel("Online Users" ) );	
		setUpListeners();
	}	
	protected void setUpMainInterface()	{
		bSend = new JButton("Send");//设置发送按钮		
		tfMessage = new JTextField(32);		
		lstClients = new JList();		
		setUpTabs();
		setUpProperties();//设置属性		
		Box displayBox = Box.createHorizontalBox();
		displayBox.add( tbChatWindows );
		displayBox.add( Box.createHorizontalStrut(3) );
		displayBox.add( scrlClients );//添加用户		
		Box commandBox = Box.createHorizontalBox();
		commandBox.add( tfMessage );
		commandBox.add( Box.createHorizontalStrut(3) );
		commandBox.add(bSend);	
		Container cp = this.getContentPane();		
		cp.setLayout( new FlowLayout(FlowLayout.LEFT) );
		cp.add( displayBox );
		cp.add( commandBox );
	
	}	
	protected void setUpTabs(){
		messageWindows = new Vector(5,2);
		tabToClient = new Vector(5,2);
		tbChatWindows = new JTabbedPane(JTabbedPane.TOP,
				JTabbedPane.SCROLL_TAB_LAYOUT );		
		//设置main room标志. 此标志不可以被停止
		messageWindows.addElement( new JTextArea(10,30) );
		((JTextArea)messageWindows.elementAt(0))
		     .setLineWrap(true);
		 ((JTextArea)messageWindows.elementAt(0))
		    .setEditable(false);				
		tbChatWindows.addTab( "Main Room",
				new JScrollPane((JTextArea)
						messageWindows.elementAt(0),
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));	
	}	
	//同指定的朋友聊天
	void openNewTab( int friendId )	{
		//检测是否聊天服务已经开启
		int index = tabToClient.indexOf(
				new Integer( friendId ) );
		if( index != -1 )
		{
			tbChatWindows.setSelectedIndex( index );
			return;
		}		
		messageWindows.addElement( new JTextArea(10,30) );
		tabToClient.addElement( new Integer(friendId) );
		((JTextArea)messageWindows.lastElement())
		.setLineWrap(true);
		((JTextArea)messageWindows.lastElement())
		.setEditable(false);		
		lstClients.setSelectedIndex( friendId );//添加组件
	tbChatWindows.addTab((String)lstClients.getSelectedValue(),(new
             JScrollPane( (JTextArea)messageWindows.
            		 lastElement() ) ) );		
		tabMenu.setEnabled( true );
		closeTabMenu.setEnabled( true );//关闭按钮
		closeAllTabsMenu.setEnabled( true );
	}	
	private void showMessage(int tabSelected,
			String message){
	   ((JTextArea)messageWindows.elementAt(tabSelected))
            .append( message );
	}	
	void showMessage(Message userMsg ){
		int tabIndex = 0;		
		if( ((Message)userMsg).audience == true ){
	        ((JTextArea)messageWindows.elementAt(tabIndex))
            .append(((Message)userMsg).message + "\n");
		}
		else {
			tabIndex = tabToClient.indexOf( new
             Integer(((Message)userMsg).senderId));						
	       ((JTextArea)messageWindows.elementAt(tabIndex+1)).
	       append(((Message)userMsg).message + "\n");
		}	
	}	
	protected void sendMessage(){
		String str = tfMessage.getText();//获取文本信息
		//String str = "aaa";
		int tabSelected = tbChatWindows.getSelectedIndex();		
		if( str.length() != 0 )		{
			try	{
				if( tabSelected == 0 ){
					client.sendPublicMessage( str );//发送公共信息
				}
				else {
					Integer clientIndex = (Integer)tabToClient
                   .elementAt( tabSelected-1 );
					client.sendPrivateMessage( 
							clientIndex.intValue(),str );
	               ((JTextArea)messageWindows.elementAt( 
	    		   tabSelected )) .append(client.Name + " says > "+
	    			str + "\n");
				}
			}
			catch( IOException io_ex ){
				showMessage(tabSelected,
				"\n\nCannot Send Message...\n\n" );
			}
			tfMessage.setText("");//设置消息框
		}
	}	
	//除了主聊天室，关闭其他的聊天
	protected void closeAllTabs(){
		int index = 1;
		while( index != tbChatWindows.getTabCount()){
			tbChatWindows.removeTabAt( index );
			messageWindows.removeElementAt(index);
		}
		tabToClient.clear();		
		tabMenu.setEnabled( false );
		closeTabMenu.setEnabled( false );
		closeAllTabsMenu.setEnabled( false );
	}	
	//表示断开连接
	synchronized void notifyDisconnect(){
		connectFMenu.setEnabled( true );//连接按钮
		disconnectFMenu.setEnabled( false );
		tfMessage.setEnabled( false );
		bSend.setEnabled( false );
		closeAllTabs();
		//lstClients.updateUI();
		lstClients.setEnabled( false );
	}	
	void notifyUserLeft(String clientName){
		int friendId = client.clientList.
		    indexOf(clientName);
		int index = tabToClient.indexOf( 
				new Integer( friendId ));		
		//如果没有任何的标志对于这个用户
		if( index == -1 )
			return;		
		JOptionPane.showMessageDialog(client.window,
				clientName+ "Has Logged Out","User Left",
				JOptionPane.INFORMATION_MESSAGE);
		tbChatWindows.removeTabAt( index+1 );
		messageWindows.removeElementAt( index+1);
		tabToClient.removeElementAt( index );		
		if(tbChatWindows.getTabCount()== 1){
			tabMenu.setEnabled( false );
			closeTabMenu.setEnabled( false );
			closeAllTabsMenu.setEnabled(false);
		}					
	}
	//退出按钮信息
	class OnExit extends WindowAdapter 
	  implements WindowListener {
		public void windowClosing(WindowEvent we){
			client.shutDown();//客户端关闭
		}		
		public void windowActivated(WindowEvent e){
			tfMessage.requestFocus();
		}
	}
	class CloseTabButton implements 
	ActionListener {
		public void actionPerformed(ActionEvent e){
			int index = tbChatWindows.getSelectedIndex();
			if( index !=0 )	{
				tbChatWindows.removeTabAt( index );
				messageWindows.removeElementAt( index );
				tabToClient.removeElementAt( index-1 );				
				if( tbChatWindows.getTabCount() == 1 ){
					tabMenu.setEnabled( false );
					closeTabMenu.setEnabled( false );
					closeAllTabsMenu.setEnabled( false );
				}					
			}
		}
	}	
	class CloseAllTabsMenu implements 
	ActionListener{
		public void actionPerformed( ActionEvent e ){
			closeAllTabs();//关闭所有的选项
		}
	}
	//退出按钮的事件处理函数
	class ExitButton implements ActionListener {
		public void actionPerformed( ActionEvent e ){
			client.shutDown();
		}
	}
	//发送信息按钮的事件处理函数
	class SendButton implements ActionListener{
		public void actionPerformed( ActionEvent e ){
			sendMessage();
			tfMessage.requestFocus();
		}
	}
	//发送信息
	class SendMessage implements ActionListener	{
		public void actionPerformed( ActionEvent e ){
			sendMessage();//发送信息
		}
	}	
	class SelectClient extends MouseAdapter
	implements MouseListener{
		public void mouseClicked(MouseEvent e){
			if( !lstClients.isSelectionEmpty() ){
				if ( e.getClickCount() == 2 &&
					e.getButton() ==MouseEvent.BUTTON1 ){
					openNewTab( lstClients.getSelectedIndex() );
					client.sendChatRequest(
							lstClients.getSelectedIndex() );
				}
			}
		}
	}
	//配置文件项的处理函数
	class ConfigureFMenu implements ActionListener	{
		public void actionPerformed( ActionEvent e ){
			ConfigureServerInfo serverDialog =
				new ConfigureServerInfo();
              //获取配置服务器信息
		}
	}
	//关于项的事件处理函数
	class AboutHlpMenu implements ActionListener{
		public void actionPerformed( ActionEvent e ){
			JOptionPane.showMessageDialog(client.window, 
			"Fruit Cha(a)t Server" +
					"\nVersion 0.7 \nThis software is" +
					" distributed under the GPL Liscence",	
					"About Fruit Cha(a)t", 
					JOptionPane.INFORMATION_MESSAGE );
		}
	}	
	class HelpHlpMenu implements ActionListener {
		public void actionPerformed(ActionEvent e){
			/* 提供帮助*/
		}
	}
	//web帮助项的事件处理函数
	class WebHlpMenu implements ActionListener	{
		public void actionPerformed( ActionEvent e ){
			JOptionPane.showMessageDialog( client.window, 
			  "For free source  code visist www.akbani.20m.com.",
			  "Fruit Cha(a)t on the WEB",
             JOptionPane.INFORMATION_MESSAGE );
		}
	}
	//连接菜单的处理函数
	class ConnectFMenu implements ActionListener{
		public void actionPerformed(ActionEvent e){
			do{
			client.Name = JOptionPane.showInputDialog(
				client.window, "Enter Login Name ?");
			}
			while((client.Name==null || 
					client.Name.length()==0));
			if( client.connectToServer())	{
				client.window.setTitle("Fruit Cha(a)t Plate <-->"
              + client.Name );				
				if(lstClients.getModel() != 
					client.clientList){
					lstClients.setModel(client.clientList);
				}				
				connectFMenu.setEnabled( false );//是否设置连接
				disconnectFMenu.setEnabled( true );			
				tfMessage.setEnabled( true );
				bSend.setEnabled( true );//发送信息
				lstClients.setEnabled( true );
				((JTextArea)messageWindows.elementAt(0)).
				   setText("");
				tfMessage.requestFocus();
			}
		}
	}	
	class DisconnectFMenu implements ActionListener {
		public void actionPerformed( ActionEvent e ){
			client.disconnectFromServer( true );//从服务器断开
			notifyDisconnect();
		}
	}
	class FocusMessageField extends 
	  FocusAdapter implements  FocusListener	{
	  public void focusLost( FocusEvent fe ) {
	      if(!( fe.getOppositeComponent() 
			instanceof JMenuItem ))	{
				tfMessage.requestFocus();
			}
		}
	}
	//显示并且设置相应的配置
	class ConfigureServerInfo extends JDialog {
		JButton bSave = new JButton("Save");
		JButton bCancel = new JButton("Cancel");
		JLabel lbServer = new JLabel("Server Name : ");
		JTextField tfServerName = new JTextField(10);//设置文本区域
		JLabel lbPort = new JLabel("Port No :  ");
		JTextField tfPortNo = new JTextField(6);
		//配置服务器信息
		ConfigureServerInfo(){
			super(client.window,"Configure Connection",true);			
			Box buttonBox = Box.createHorizontalBox();
			buttonBox.add( Box.createHorizontalStrut(50) );
			buttonBox.add(bSave);
			//buttonBox.add( Box.createHorizontalStrut(10) );
			buttonBox.add(bCancel);			
			Container jcp = this.getContentPane();
			jcp.setLayout( new FlowLayout(FlowLayout.LEFT) );
			jcp.add(lbServer);
			jcp.add(tfServerName);
			jcp.add(lbPort);
			jcp.add(tfPortNo);
			//jcp.add( commandBox );
			jcp.add( buttonBox );//添加按钮框			
			bSave.addActionListener(new SaveButton());
			bCancel.addActionListener(new CancelButton());			
	       client.getConfiguration();//设置客户的配置信息			
	        tfServerName.setText( client.serverAddress );//设置文本框
           tfPortNo.setText(Integer.toString(client.
        		   serverSocketNumber));
			this.setSize(230,115);
	       //将对话框放置在中心位置
			Point position = client.window.getLocation();
			position.x = position.x + (client.window.getWidth()/2)
              - (this.getWidth()/2);
			position.y = position.y + (client.window.getHeight()/2)
              - (this.getHeight()/2);
			this.setLocation( position );			
			this.setVisible(true);
			this.setResizable( false );			
		}
		//保存按钮事件触发处理函数
		class SaveButton implements ActionListener{
			public void actionPerformed( ActionEvent e ){
				client.setConfiguration( tfServerName.getText(),
               Integer.parseInt(tfPortNo.getText()) );//设置配置信息
				dispose();
			}
		}
		//取消按钮时间触发处理函数
		class CancelButton implements ActionListener{
			public void actionPerformed( ActionEvent e ){
				dispose();
			}
		}		
	}
}
