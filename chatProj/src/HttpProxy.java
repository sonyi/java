import java.net.*;
import java.io.*;
public class HttpProxy extends Thread {
	//�趨���ԵĴ���
    static public int CONNECT_RETRIES=5;
   //5ֹͣ��ʱ��
    static public int CONNECT_PAUSE=5;
    static public int TIMEOUT=50;
    static public int BUFSIZ=1024;//��������С
    static public boolean logging = false;
    static public OutputStream log=null;//�����
    // ���������õ�Socket
    protected Socket socket;
    // �ϼ��������������ѡ
    static private String parent=null;
    static private int parentPort=-1;
	 //�趨���������
    static public void setParentProxy(String name, 
    		int pport) {
	  parent=name;
	  parentPort=pport;
    }	
    //�ڸ���Socket�ϴ���һ�������̡߳�
    public HttpProxy(Socket s) {
    	socket=s; 
    	start(); 
    }
   //��¼��Ϣ
    public void writeLog(int c, boolean browser) 
       throws IOException{
		log.write(c);
    }
	 public void writeLog(byte[] bytes,int offset, 
			 int len, boolean
            browser) throws IOException {
		for (int i=0;i<len;i++) 
			writeLog((int)bytes[offset+i],browser);
    }	
    // Ĭ������£���־��Ϣ�������׼����豸����������Ը�����
 public String processHostName(String url, String host, 
		 int port,  Socket sock) {
		java.text.DateFormat cal=java.text.DateFormat
            .getDateTimeInstance();
		System.out.println(cal.format(new
			java.util.Date())+ " \n "+url+"\n "+ 
				sock.getInetAddress()+"\n");
		return host;
    }
	// ִ�в������߳�
  public void run() {
		String line;
		String host;
		int port=80;//�趨�˿ں�
        Socket outbound=null;
		try {
			//�趨ֹͣʱ��
			socket.setSoTimeout(TIMEOUT);
			//���������
			InputStream is=socket.getInputStream();
			OutputStream os=null;
			try {
                // ��ȡ�����е�����
				line="";
				host="";
				int state=0;
				boolean space;
				while (true) {
					int c=is.read();
					if (c==-1) break;//����ѭ��
					if (logging) writeLog(c,true);
					space=Character.isWhitespace((char)c);
					//ͨ����ͬ״̬ѡ�������
					switch (state) {
					case 0:
						if (space) continue; 
						state=1;
					case 1:
						if (space) {
							state=2;
							continue;
						}
						line=line+(char)c;
						break;
					case 2:
						if (space) continue; //��������հ��ַ�
						state=3;
					case 3:
						if (space) {
							state=4; 
                           //ֻȡ���������Ʋ���
							String host0=host;
							int n;
							n=host.indexOf("//");
							if (n!=-1) host=host.substring(n+2);
							n=host.indexOf('/');
							if (n!=-1) host=host.substring(0,n);
                            // �������ܴ��ڵĶ˿ں�
							n=host.indexOf(":");
							if (n!=-1) { 
								port=Integer.parseInt(
										host.substring(n+1));
								host=host.substring(0,n);
							}
							host=processHostName(host0,host,port,socket);
							if (parent!=null) {
								host=parent;
								port=parentPort;
							}
							int retry=CONNECT_RETRIES;
							while (retry--!=0) {
								try {
									//���»���׽���
									outbound=new Socket(host,port);
									break;
			                	} catch (Exception e) { }
				                // �ȴ�
				                Thread.sleep(CONNECT_PAUSE);
							}
							if (outbound==null) break;
							//�趨ͣ��ʱ��
							outbound.setSoTimeout(TIMEOUT);
							os=outbound.getOutputStream();
							//ͨ��д����ķ�ʽ
							os.write(line.getBytes());
							os.write(' ');//���ͱ�Ƿ�
							os.write(host0.getBytes());
							os.write(' ');
		                    pipe(is,outbound.getInputStream(),
		                    		os,socket.getOutputStream());
							break;//����ѭ��
						}
						host=host+(char)c;
						break;//����ѭ��
					}
				}
			}
			catch (IOException e) { }			
    } catch (Exception e) { }
    finally {
		try { socket.close();} catch (Exception e1) {}//�ر��׽���
		try { outbound.close();} catch (Exception e2) {}
	  }
    }	
	//ͨ���ܵ��ķ�ʽ����
    void pipe(InputStream is0, InputStream is1,
		OutputStream os0,  OutputStream os1) 
    		throws IOException {
		try {
			int ir;
			byte bytes[]=new byte[BUFSIZ];//�趨������
			while (true) {
				try {
					if ((ir=is0.read(bytes))>0) {
						os0.write(bytes,0,ir);//д����ķ�ʽ
						if (logging) writeLog(bytes,0,ir,true);
					}
					else if (ir<0)
						break;//����ѭ��
		} catch (InterruptedIOException e) { }
		try {
			if ((ir=is1.read(bytes))>0) {
				os1.write(bytes,0,ir);//ͨ��д����
				if (logging) writeLog(bytes,0,ir,false);
			}
			else if (ir<0) 
				break;//����ѭ��
		} catch (InterruptedIOException e) { }
			}
		} catch (Exception e0) {
			System.out.println("Pipe�쳣: " + e0);
		}
    }
	static public void startProxy(int port,Class clobj) {
		ServerSocket ssock;//�������׽���
		//Socket sock;
        try {
			ssock=new ServerSocket(port);//ʵ�����������׽���
			while (true) {
				Class [] sarg = new Class[1];
				Object [] arg= new Object[1];
				sarg[0]=Socket.class;
				try {
					java.lang.reflect.Constructor cons = clobj
                .getDeclaredConstructor(sarg);
					arg[0]=ssock.accept();
					//����HttpProxy�����������ʵ��
					cons.newInstance(arg); 
				}
				catch (Exception e) { 
					Socket esock = (Socket)arg[0];
					try { 
						esock.close(); 
						} 
					catch (Exception ec) {}//���������Ϣ
				}
			}
		} catch (IOException e) {
		}
    }
	    // �����õļ�main����
    static public void main(String args[]) {
		System.out.println("�ڶ˿�808�������������\n");
		HttpProxy.log=System.out;//��¼��Ϣ
		HttpProxy.logging=false;
		HttpProxy.startProxy(808,HttpProxy.class);
	}
}
