package cn.csu.Gram.Detail;

/**
 * @file SysoutTest.java 
 * @author 李岸
 * @version 1.0
 * @since Apr 9, 2010
 */
public class SysoutTest {
	public static void main(String[] args) {
		/**
		 * 有符号整数是按照最高位判断正负的(java中的数值除了char都是有符号的，都符合这个规则)，如果x最高位是1，那么该数是负数，其值为 -((~x)+1)，因此
		 * 11111111 11111111 11111111 11111111作为int型的话，因为最高位为1，所以其值为 -(0+1)=-1
		 * 根据上面的理论，~12=-(~(~12)+1)=-13
		 */
		System.out.println(~7);		//输出-8
		
		System.out.println(~100);
	}
}

