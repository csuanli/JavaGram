package cn.csu.Thread;

/**
 * 测试线程wait的用法：
 * 实现同步有两种方式：
 * synchronized:
 * 	锁定对象锁，当出了synchronized之后释放对象锁
 * wait/notify:
 * 	或者在synchronized内通过wait方法释放对象锁，sleep方法不释放对象锁
 */
public class Thread_Wait {
	public static void main(String[] args) {
		new Thread(new Thread1()).start();
		new Thread(new Thread2()).start();
	}
}

class Thread1 implements Runnable{
	public void run(){
		synchronized(Thread_Wait.class){
			System.out.println("enter thread1... ");
			try {
				Thread.sleep(2000);
				System.out.println("thread1 before wait() runing ...");
				Thread_Wait.class.wait();		//wait()将释放对象锁
				System.out.println("thread1 after wait() runing ...");
				Thread.sleep(9000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Thread2 implements Runnable{
	public void run(){
		synchronized(Thread_Wait.class){
			System.out.println("enter thread2... ");
			System.out.println("thread2 before notify() run...");
			try {
				Thread.sleep(9000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Thread_Wait.class.notify();			//notify()将唤醒进程
			System.out.println("thread2 after notify() run...");
		}
	}
}
