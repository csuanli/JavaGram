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
public class TCPTest_Client {

	public static void main(String[] args) {
		client();
	}
	
	public static void client(){
		try {
			Socket s=new Socket(InetAddress.getByName(null),6000);
			
			OutputStream os=s.getOutputStream();
			os.write("this is client".getBytes()); 			//像服务端发送信息
			
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
			e.printStackTrace();
		}
	}
}