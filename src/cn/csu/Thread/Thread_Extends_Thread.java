package cn.csu.Thread;

/**
 * @file Thread_Extends_Thread.java
 * @author 李岸
 * @version 1.0
 * @since Sep 25, 2010
 */
public class Thread_Extends_Thread {
	/**
	 * 将类声明为 Thread 的子类。该子类应重写 Thread 类的 run 方法。接下来可以分配并启动该子类的实例
	 */
	public static void main(String[] args) {
		ThreadTest1 tt1=new ThreadTest1("a");
		tt1.start();		//线程启动方法
		ThreadTest1 tt2=new ThreadTest1("bb");
		tt2.start();		//线程启动方法
		
		System.out.println("dddddd");
	}
}

class ThreadTest1 extends Thread{
	private String str;
	
	public ThreadTest1(String str){
		this.str=str;
	}
	
	public void run(){
		System.out.println("启动线程...");
		for(int i=1;i<1000;i++){
			System.out.println(str +" "+i);
			try {
                sleep(100);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
		}
		
	}
}