/**
 * Proxy.java  
 * @Description  TODO 
 * @author lian
 * @date Aug 19, 2015 4:14:43 PM 
 * @version V1.0  
 */
package cn.csu.DesignPattern.ProxyPattern;


/**
 * Proxy 
 * @Description TODO 
 * @author lian
 * @date 4:14:43 PM 
 *
 */
public class Proxy {
	
	Subject subject;
	
	public Proxy(Subject subject)
	{
		this.subject = subject;
	}
	
	public void operate()
	{
		System.out.println("do something before real in proxy");
		subject.operate();
		System.out.println("do something after real in proxy");
	}

}
