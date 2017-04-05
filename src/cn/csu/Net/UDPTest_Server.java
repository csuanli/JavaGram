package cn.csu.Net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @file TCPTest_Server.java
 * @author 李岸
 * @version 1.0
 * @since Sep 25, 2010
 */
public class UDPTest_Server {

	/**
	 * 接收端
	 */
	public static void main(String[] args) {
		receive();
	}
	
	public static void receive(){
		try {
			DatagramSocket ds=new DatagramSocket(6001);
			byte[] buf=new byte[100];
			DatagramPacket dp=new DatagramPacket(buf,100);
			ds.receive(dp);
			System.out.println("UDP接受到的数据："+new String(buf,0,dp.getLength()));
			ds.close();
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	

}
