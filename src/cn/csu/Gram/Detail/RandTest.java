package cn.csu.Gram.Detail;

/**
 * @file RandTest.java
 * 随机值取0到1
 * @author 李岸
 * @version 1.0
 * @since Apr 9, 2010
 */
public class RandTest {

	public static void main(String[] args) {
		double i,j;
		i=Math.random();
		j=Math.random()*10;
		System.out.println("随机数："+i);
		System.out.println("随机数："+j);
	}
}
