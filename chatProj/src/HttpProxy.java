import java.net.*;
import java.io.*;
public class HttpProxy extends Thread {
	//设定重试的次数
    static public int CONNECT_RETRIES=5;
   //5停止的时间
    static public int CONNECT_PAUSE=5;
    static public int TIMEOUT=50;
    static public int BUFSIZ=1024;//缓冲区大小
    static public boolean logging = false;
    static public OutputStream log=null;//输出流
    // 传入数据用的Socket
    protected Socket socket;
    // 上级代理服务器，可选
    static private String parent=null;
    static private int parentPort=-1;
	 //设定代理服务器
    static public void setParentProxy(String name, 
    		int pport) {
	  parent=name;
	  parentPort=pport;
    }	
    //在给定Socket上创建一个代理线程。
    public HttpProxy(Socket s) {
    	socket=s; 
    	start(); 
    }
   //记录信息
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
    // 默认情况下，日志信息输出到标准输出设备，派生类可以覆盖它
 public String processHostName(String url, String host, 
		 int port,  Socket sock) {
		java.text.DateFormat cal=java.text.DateFormat
            .getDateTimeInstance();
		System.out.println(cal.format(new
			java.util.Date())+ " \n "+url+"\n "+ 
				sock.getInetAddress()+"\n");
		return host;
    }
	// 执行操作的线程
  public void run() {
		String line;
		String host;
		int port=80;//设定端口号
        Socket outbound=null;
		try {
			//设定停止时间
			socket.setSoTimeout(TIMEOUT);
			//获得输入流
			InputStream is=socket.getInputStream();
			OutputStream os=null;
			try {
                // 获取请求行的内容
				line="";
				host="";
				int state=0;
				boolean space;
				while (true) {
					int c=is.read();
					if (c==-1) break;//跳出循环
					if (logging) writeLog(c,true);
					space=Character.isWhitespace((char)c);
					//通过不同状态选择处理过程
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
						if (space) continue; //跳过多个空白字符
						state=3;
					case 3:
						if (space) {
							state=4; 
                           //只取出主机名称部分
							String host0=host;
							int n;
							n=host.indexOf("//");
							if (n!=-1) host=host.substring(n+2);
							n=host.indexOf('/');
							if (n!=-1) host=host.substring(0,n);
                            // 分析可能存在的端口号
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
									//重新获得套接字
									outbound=new Socket(host,port);
									break;
			                	} catch (Exception e) { }
				                // 等待
				                Thread.sleep(CONNECT_PAUSE);
							}
							if (outbound==null) break;
							//设定停顿时间
							outbound.setSoTimeout(TIMEOUT);
							os=outbound.getOutputStream();
							//通过写缓冲的方式
							os.write(line.getBytes());
							os.write(' ');//发送标记符
							os.write(host0.getBytes());
							os.write(' ');
		                    pipe(is,outbound.getInputStream(),
		                    		os,socket.getOutputStream());
							break;//跳出循环
						}
						host=host+(char)c;
						break;//跳出循环
					}
				}
			}
			catch (IOException e) { }			
    } catch (Exception e) { }
    finally {
		try { socket.close();} catch (Exception e1) {}//关闭套接字
		try { outbound.close();} catch (Exception e2) {}
	  }
    }	
	//通过管道的方式处理
    void pipe(InputStream is0, InputStream is1,
		OutputStream os0,  OutputStream os1) 
    		throws IOException {
		try {
			int ir;
			byte bytes[]=new byte[BUFSIZ];//设定缓冲区
			while (true) {
				try {
					if ((ir=is0.read(bytes))>0) {
						os0.write(bytes,0,ir);//写缓冲的方式
						if (logging) writeLog(bytes,0,ir,true);
					}
					else if (ir<0)
						break;//跳出循环
		} catch (InterruptedIOException e) { }
		try {
			if ((ir=is1.read(bytes))>0) {
				os1.write(bytes,0,ir);//通过写缓冲
				if (logging) writeLog(bytes,0,ir,false);
			}
			else if (ir<0) 
				break;//跳出循环
		} catch (InterruptedIOException e) { }
			}
		} catch (Exception e0) {
			System.out.println("Pipe异常: " + e0);
		}
    }
	static public void startProxy(int port,Class clobj) {
		ServerSocket ssock;//服务器套接字
		//Socket sock;
        try {
			ssock=new ServerSocket(port);//实例化服务器套接字
			while (true) {
				Class [] sarg = new Class[1];
				Object [] arg= new Object[1];
				sarg[0]=Socket.class;
				try {
					java.lang.reflect.Constructor cons = clobj
                .getDeclaredConstructor(sarg);
					arg[0]=ssock.accept();
					//创建HttpProxy或其派生类的实例
					cons.newInstance(arg); 
				}
				catch (Exception e) { 
					Socket esock = (Socket)arg[0];
					try { 
						esock.close(); 
						} 
					catch (Exception ec) {}//输出错误信息
				}
			}
		} catch (IOException e) {
		}
    }
	    // 测试用的简单main方法
    static public void main(String args[]) {
		System.out.println("在端口808启动代理服务器\n");
		HttpProxy.log=System.out;//记录信息
		HttpProxy.logging=false;
		HttpProxy.startProxy(808,HttpProxy.class);
	}
}
