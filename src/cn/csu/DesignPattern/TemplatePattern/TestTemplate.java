/**
 * 文件名: TestTemplate.java  
 * 描述： TODO 
 * 修改人： lian
 * 修改时间： Sep 24, 2015 4:36:20 PM 
 * 版本号： 1.0  
 */
package cn.csu.DesignPattern.TemplatePattern;

/**
 * 模板调用测试
 * 
 * @author 
 * @version [版本号] 
 * @see [相关类/相关方法]
 * @since [产品/模块版本] 
 */
public class TestTemplate 
{

	/**
	 * <一句话功能描述> 
	 * <详细功能描述>
	 * @param @param args   
	 * @return void    d
	 * @throws 
	 */
	public static void main(String[] args) 
	{
		AbstractTemplate at = new ConcreteTemplate1();
		at.templateMethod();
		
		AbstractTemplate tt = new ConcreteTemplate2();
		tt.templateMethod();
	}

}
