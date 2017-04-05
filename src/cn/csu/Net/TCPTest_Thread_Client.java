package cn.csu.Net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @file TCPTest_Client.java
 * @author 李岸
 * @version 1.0
 * @since Sep 25, 2010
 */
public class TCPTest_Thread_Client extends Thread{
	
	/**
	 * @param args
	 */
	private  Socket s;
	public TCPTest_Thread_Client(Socket s){
		this.s=s;
	}
	public static void main(String[] args) {
		client();
	}
	
	public void run(){		
		try {
			System.out.println("启动客户端线程....");
			OutputStream os;
			os = s.getOutputStream();
			os.write("this is lisi".getBytes()); 			//像服务端发送信息
			
			InputStream is=s.getInputStream();				//接受服务器端发来的信息
			byte[] buf=new byte[100];
			int len=is.read(buf);
			System.out.println(new String(buf,0,len));
			
			os.close();
			is.close();
			s.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void client(){
		try {
			Socket s=new Socket(InetAddress.getByName(null),6000);
			new TCPTest_Thread_Client(s).start();			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}