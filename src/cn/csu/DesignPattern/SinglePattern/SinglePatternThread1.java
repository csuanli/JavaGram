/**
 * SinglePatternThread1.java  
 * @Description  TODO 
 * @author lian
 * @date Aug 19, 2015 2:24:47 PM 
 * @version V1.0  
 */
package cn.csu.DesignPattern.SinglePattern;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * SinglePatternThread1 
 * @Description 单例模式存在的并发问题模拟
 * @author lian
 * @date 2:24:47 PM 
 *
 */
public class SinglePatternThread1 
{

	public static void main(String[] args) 
	{
		/**
		 * 验证单例有效
		 */
/*		SinglePattern singlePattern = SinglePattern.getInstance();
		singlePattern.showCreateDate();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		SinglePattern singlePattern1 = SinglePattern.getInstance();
		singlePattern1.showCreateDate();*/
	
		ThreadTest1 tt1 = new ThreadTest1();
		tt1.start();
		
		ThreadTest1 tt2 = new ThreadTest1();
		tt2.start();
	}

}

class ThreadTest1 extends Thread
{
	SinglePattern singlePattern = null;
	public void run()
	{
		singlePattern = SinglePattern.getInstance();
	}
}

class SinglePattern
{
	private static SinglePattern singlePattern = null;
	
	private Date date;
	
	private SinglePattern()
	{
		date = new Date();
	}
	
	public static SinglePattern getInstance()
	{
		if(null == singlePattern)
		{
			synchronized (SinglePattern.class) 
			{
				if(null == singlePattern)
				{
					singlePattern = new SinglePattern();
				}
			}
		}
		return singlePattern;
	}
	
	public void showCreateDate()
	{
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		System.out.println(sdf.format(date));
	}
	
}
