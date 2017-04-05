package cn.csu.Exception;

import cn.csu.Gram.Detail.SysoutTest;

public class ExpReturn {

	/**
	 * 面试题，该函数的返回值是什么
	 * @return
	 */
	private static int count()
	{
		try
		{
			return 5/0;
		}
		catch (Exception e) 
		{
			System.out.println("enter catch");
			return 2*3;
		}
		finally
		{
			System.out.println("enter finally");
			return 3;
			//若注释return 3则返回6
		}
	}
	
	public static void main(String[] args) {
		System.out.println(count());

	}

}
