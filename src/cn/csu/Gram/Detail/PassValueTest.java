/**
 * @Title: PassValueTest.java  
 * @Description: {用一句话描述该文件做什么} 
 * @author lian
 * @date Aug 18, 2015 12:59:31 PM 
 * @version V1.0  
 */
package cn.csu.Gram.Detail;


/**
 * @ClassName PassValueTest 
 * @Description 区别传值和传引用 
 * @author lian
 * @date Aug 18, 2015 12:59:31 PM 
 */
public class PassValueTest 
{

	/**
	 * @Title main 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param args  参数说明 
	 * @return void    返回类型 
	 * @throws 
	 */
	public static void main(String[] args) 
	{
		StringBuilder sb = new StringBuilder("hellow");
		changeString(sb);
		System.out.println(sb.toString());
		
		StringBuilder sb2 = new StringBuilder("hellow");
		changeString2(sb2);
		System.out.println(sb2.toString());
		
		
		StringBuilder sb3 = new StringBuilder("hellow");
		sb3 = changeString3(sb3);
		System.out.println(sb3.toString());
	}
	
	/**
	 * @Title: changeString 
	 * @Description: 传引用，引用所指的内存块值发生变化 
	 * @param @param StringBuilder  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	public static void changeString(StringBuilder StringBuilder)
	{
		StringBuilder.append(" world");
	}
	
	/**
	 * changeString2 
	 * @Description 传引用，引用所指的内存块值没有发生变化，方法内改变了引用所指对象，不影响外部 
	 * @param stringBuilder  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	public static void changeString2(StringBuilder stringBuilder)
	{
		stringBuilder = new StringBuilder("hi");
		stringBuilder.append(" world");
	}
	
	/**
	 * @Description 返回新的对象
	 * @param stringBuilder
	 * @return StringBuilder    
	 * @throws
	 */
	public static StringBuilder changeString3(StringBuilder stringBuilder)
	{
		stringBuilder = new StringBuilder("hi");
		stringBuilder.append(" world");
		return stringBuilder;
	}

}
