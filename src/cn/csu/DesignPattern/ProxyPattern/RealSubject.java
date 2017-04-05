/**
 * RealSubject.java  
 * @Description  TODO 
 * @author lian
 * @date Aug 19, 2015 4:13:07 PM 
 * @version V1.0  
 */
package cn.csu.DesignPattern.ProxyPattern;

/**
 * RealSubject 
 * @Description 实际主题，具体实现 
 * @author lian
 * @date 4:13:07 PM 
 *
 */
public class RealSubject implements Subject {

	public void operate() {
		System.out.println("the real operation!");
	}

}
