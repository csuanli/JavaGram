/**
 * ProxyTest.java  
 * @Description  TODO 
 * @author lian
 * @date Aug 19, 2015 4:09:35 PM 
 * @version V1.0  
 */
package cn.csu.DesignPattern.ProxyPattern;

/**
 * ProxyTest 
 * @Description 客户端调用代理执行 
 * @author lian
 * @date 4:09:35 PM 
 *
 */
public class ProxyTest 
{

	public static void main(String[] args) 
	{
		Subject subject =  new RealSubject();
		Proxy proxy = new Proxy(subject);
		proxy.operate();
	}

}
