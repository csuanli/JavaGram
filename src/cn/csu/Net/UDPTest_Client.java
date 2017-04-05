package cn.csu.Net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * @file TCPTest_Client.java
 * @author 李岸
 * @version 1.0
 * @since Sep 25, 2010
 */
public class UDPTest_Client {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		send();
	}
	
	public static void send(){
		try {
			DatagramSocket ds=new DatagramSocket();
			byte[] buf="this is the message".getBytes();
			int len=buf.length;
			DatagramPacket dp=new DatagramPacket(buf,len,InetAddress.getByName("127.0.0.1"),6001);
			ds.send(dp);
			ds.close();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
