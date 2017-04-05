package cn.csu.Net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @file TCPTest_Server.java
 * @author 李岸
 * @version 1.0
 * @since Sep 25, 2010
 */
public class UDPTest_Thread_Server extends Thread{

	/**
	 * 接收端，线程的方式
	 */
	DatagramSocket ds;
	
	public UDPTest_Thread_Server(DatagramSocket ds) {
		this.ds = ds;
	}

	public void run(){
		try {			
			byte[] buf=new byte[100];
			DatagramPacket dp=new DatagramPacket(buf,100);
			ds.receive(dp);
			System.out.println("UDP接受到的数据："+new String(buf,0,dp.getLength()));
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		receive();
	}
	
	public static void receive(){
		try {
			DatagramSocket ds = new DatagramSocket(6002);
			while(true){
				new UDPTest_Thread_Server(ds).start();
			}			
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	

}