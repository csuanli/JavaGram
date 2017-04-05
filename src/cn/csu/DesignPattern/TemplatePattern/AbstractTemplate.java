/**
 * 文件名: AbstractTemplate.java  
 * 描述： TODO 
 * 修改人： lian
 * 修改时间： Sep 24, 2015 4:10:50 PM 
 * 版本号： 1.0  
 */
package cn.csu.DesignPattern.TemplatePattern;

/**
 * 模板模式抽象父类，其作用为实现整体的业务逻辑
 * 
 * @author 
 * @version [版本号] 
 * @see [相关类/相关方法]
 * @since [产品/模块版本] 
 */
public abstract class AbstractTemplate 
{
	// operation1、operation2为具体的实现细节，留待子类实现
	public abstract int operation1();
	
	public abstract int operation2();
	
	/**
	 * 算法的整体逻辑
	 * 
	 * @param    
	 * @return void    
	 * @throws
	 */
	public void templateMethod()
	{
		int a = operation1();
		int b = operation2();
		System.out.println("feedback result..." + a*b);
	}
}
