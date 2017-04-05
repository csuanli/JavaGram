package cn.csu.Thread;

/**
 * @file Thread_Impl_Runable.java
 * @author 李岸
 * @version 1.0
 * @since Sep 25, 2010
 */
public class Thread_Impl_Runable {
	/**
	 *创建线程的另一种方法是声明实现 Runnable 接口的类。该类然后实现 run 方法。
	 *然后可以分配该类的实例，在创建 Thread 时作为一个参数来传递并启动。
	 */
	public static void main(String[] args) {
		ThreadTest t1=new ThreadTest();
		new Thread(t1).start();		//启动线程
		
		ThreadTest t2=new ThreadTest();
		new Thread(t2).start();		//启动线程
	}
}

class ThreadTest implements Runnable {
	public void run() {
		System.out.println("启动线程....");
		System.out.println(this.toString());
	}
}