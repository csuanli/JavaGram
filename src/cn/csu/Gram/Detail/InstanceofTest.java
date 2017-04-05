package cn.csu.Gram.Detail;

/**
 * @file InstanceofTest.java
 * @author 李岸
 * @version 1.0
 * @since Apr 22, 2010
 */
public class InstanceofTest {

	public static void main(String[] args) {
		String a="instanceof";
		boolean isObject=a instanceof Object;		//instanceof是一个关键字，一个二元操作符
		System.out.println(isObject);
		System.out.println(a.getClass().isInstance(new String()));
	}
}
