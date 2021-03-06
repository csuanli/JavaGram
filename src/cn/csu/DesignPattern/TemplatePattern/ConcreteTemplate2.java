/**
 * 文件名: ConcreteTemplate2.java  
 * 描述： TODO 
 * 修改人： lian
 * 修改时间： Sep 24, 2015 4:34:40 PM 
 * 版本号： 1.0  
 */
package cn.csu.DesignPattern.TemplatePattern;

/**
 * 子类实现具体的逻辑细节
 * 
 * @author 
 * @version [版本号] 
 * @see [相关类/相关方法]
 * @since [产品/模块版本] 
 */
public class ConcreteTemplate2 extends AbstractTemplate {

	/* (non-Javadoc)
	 * @see cn.csu.DesignPattern.TemplatePattern.AbstractTemplate#operation1()
	 */
	@Override
	public int operation1() {
		System.out.println("template2.operation1...");
		return 21;
	}

	/* (non-Javadoc)
	 * @see cn.csu.DesignPattern.TemplatePattern.AbstractTemplate#operation2()
	 */
	@Override
	public int operation2() {
		System.out.println("template2.operation2...");
		return 22;
	}

}
