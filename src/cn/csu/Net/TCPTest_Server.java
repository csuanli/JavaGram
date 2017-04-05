package cn.csu.Net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @file TCPTest_Server.java
 * @author 李岸
 * @version 1.0
 * @since Sep 25, 2010
 */
public class TCPTest_Server {

	public static void main(String[] args) {
		server();
	}
	
	public static void server(){
		try {
			ServerSocket ss=new ServerSocket(6000);
			Socket s=ss.accept();
			
			OutputStream os=s.getOutputStream();
			os.write("hello welcome you".getBytes());		//服务器向客户端发送信息
			
			InputStream is=s.getInputStream();				//接受客户端发来的信息
			byte[] buf=new byte[100];
			int len=is.read(buf);
			System.out.println(new String(buf,0,len));		
			
			os.close();
			is.close();
			s.close();
			ss.close();
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	

}
