package chat;
import java.io.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.*;
public class ClientInterface extends JFrame {
	private ChatClient client;	
	//ÿ�δ���һ���µĶ���	
	JList lstClients;//Ϊ�û������б�	
	//�������д��ڵ�����
	protected Vector messageWindows;	
	//�ṩ��Ӧ��ƥ��
	protected Vector tabToClient;
	//������Ϣ��ť
	protected JButton bSend;
	protected JTextField tfMessage;//�ı���	
	protected JScrollPane scrlClients;
	//�������ø������
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
		//���ò˵���
		setUpMenu();
		setUpMainInterface();		
		setVisible(true);
		this.setSize(480,330);
		tfMessage.requestFocus();
	}	
	//�˺���Ϊ���ò˵���
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
		//�����ļ��˵�������
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
		//���ð����˵���
		hlpMenu = new JMenu("Help");
		hlpMenu.setMnemonic(KeyEvent.VK_H);
		hlpMenu.add(helpHlpMenu);
		hlpMenu.addSeparator();
		hlpMenu.add(aboutHlpMenu);
		hlpMenu.add(webHlpMenu);
		//���ò˵���
		menuBar = new JMenuBar();
		menuBar.add(fileMenu);
		menuBar.add( tabMenu );
		menuBar.add(hlpMenu);
		setJMenuBar(menuBar);
	}	
	protected void setUpListeners()	{
		//����Ϊ�����ϴ��û��˵�
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
		bSend.addActionListener( new SendButton() );//����¼�����
		tfMessage.addActionListener( new SendMessage() );
		//tfMessage.addFocusListener( new FocusMessageField() );		
		lstClients.addMouseListener( new SelectClient() );
		addWindowListener( new OnExit() );
	}	
	protected void setUpProperties(){
		setSize(475,280);//���ô�С�ߴ�
		setResizable(false);//���ɸı��С		
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
		bSend = new JButton("Send");//���÷��Ͱ�ť		
		tfMessage = new JTextField(32);		
		lstClients = new JList();		
		setUpTabs();
		setUpProperties();//��������		
		Box displayBox = Box.createHorizontalBox();
		displayBox.add( tbChatWindows );
		displayBox.add( Box.createHorizontalStrut(3) );
		displayBox.add( scrlClients );//����û�		
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
		//����main room��־. �˱�־�����Ա�ֹͣ
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
	//ָͬ������������
	void openNewTab( int friendId )	{
		//����Ƿ���������Ѿ�����
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
		lstClients.setSelectedIndex( friendId );//������
	tbChatWindows.addTab((String)lstClients.getSelectedValue(),(new
             JScrollPane( (JTextArea)messageWindows.
            		 lastElement() ) ) );		
		tabMenu.setEnabled( true );
		closeTabMenu.setEnabled( true );//�رհ�ť
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
		String str = tfMessage.getText();//��ȡ�ı���Ϣ
		//String str = "aaa";
		int tabSelected = tbChatWindows.getSelectedIndex();		
		if( str.length() != 0 )		{
			try	{
				if( tabSelected == 0 ){
					client.sendPublicMessage( str );//���͹�����Ϣ
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
			tfMessage.setText("");//������Ϣ��
		}
	}	
	//�����������ң��ر�����������
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
	//��ʾ�Ͽ�����
	synchronized void notifyDisconnect(){
		connectFMenu.setEnabled( true );//���Ӱ�ť
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
		//���û���κεı�־��������û�
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
	//�˳���ť��Ϣ
	class OnExit extends WindowAdapter 
	  implements WindowListener {
		public void windowClosing(WindowEvent we){
			client.shutDown();//�ͻ��˹ر�
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
			closeAllTabs();//�ر����е�ѡ��
		}
	}
	//�˳���ť���¼�������
	class ExitButton implements ActionListener {
		public void actionPerformed( ActionEvent e ){
			client.shutDown();
		}
	}
	//������Ϣ��ť���¼�������
	class SendButton implements ActionListener{
		public void actionPerformed( ActionEvent e ){
			sendMessage();
			tfMessage.requestFocus();
		}
	}
	//������Ϣ
	class SendMessage implements ActionListener	{
		public void actionPerformed( ActionEvent e ){
			sendMessage();//������Ϣ
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
	//�����ļ���Ĵ�����
	class ConfigureFMenu implements ActionListener	{
		public void actionPerformed( ActionEvent e ){
			ConfigureServerInfo serverDialog =
				new ConfigureServerInfo();
              //��ȡ���÷�������Ϣ
		}
	}
	//��������¼�������
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
			/* �ṩ����*/
		}
	}
	//web��������¼�������
	class WebHlpMenu implements ActionListener	{
		public void actionPerformed( ActionEvent e ){
			JOptionPane.showMessageDialog( client.window, 
			  "For free source  code visist www.akbani.20m.com.",
			  "Fruit Cha(a)t on the WEB",
             JOptionPane.INFORMATION_MESSAGE );
		}
	}
	//���Ӳ˵��Ĵ�����
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
				connectFMenu.setEnabled( false );//�Ƿ���������
				disconnectFMenu.setEnabled( true );			
				tfMessage.setEnabled( true );
				bSend.setEnabled( true );//������Ϣ
				lstClients.setEnabled( true );
				((JTextArea)messageWindows.elementAt(0)).
				   setText("");
				tfMessage.requestFocus();
			}
		}
	}	
	class DisconnectFMenu implements ActionListener {
		public void actionPerformed( ActionEvent e ){
			client.disconnectFromServer( true );//�ӷ������Ͽ�
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
	//��ʾ����������Ӧ������
	class ConfigureServerInfo extends JDialog {
		JButton bSave = new JButton("Save");
		JButton bCancel = new JButton("Cancel");
		JLabel lbServer = new JLabel("Server Name : ");
		JTextField tfServerName = new JTextField(10);//�����ı�����
		JLabel lbPort = new JLabel("Port No :  ");
		JTextField tfPortNo = new JTextField(6);
		//���÷�������Ϣ
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
			jcp.add( buttonBox );//��Ӱ�ť��			
			bSave.addActionListener(new SaveButton());
			bCancel.addActionListener(new CancelButton());			
	       client.getConfiguration();//���ÿͻ���������Ϣ			
	        tfServerName.setText( client.serverAddress );//�����ı���
           tfPortNo.setText(Integer.toString(client.
        		   serverSocketNumber));
			this.setSize(230,115);
	       //���Ի������������λ��
			Point position = client.window.getLocation();
			position.x = position.x + (client.window.getWidth()/2)
              - (this.getWidth()/2);
			position.y = position.y + (client.window.getHeight()/2)
              - (this.getHeight()/2);
			this.setLocation( position );			
			this.setVisible(true);
			this.setResizable( false );			
		}
		//���水ť�¼�����������
		class SaveButton implements ActionListener{
			public void actionPerformed( ActionEvent e ){
				client.setConfiguration( tfServerName.getText(),
               Integer.parseInt(tfPortNo.getText()) );//����������Ϣ
				dispose();
			}
		}
		//ȡ����ťʱ�䴥��������
		class CancelButton implements ActionListener{
			public void actionPerformed( ActionEvent e ){
				dispose();
			}
		}		
	}
}
