/**
 * 
 */
package cn.csu.Gram.Exception;

/**
 * @author 李岸
 * 测试捕获运行时异常,编译期间可以
 *
 */
public class RunTimeEx {

	public static void main(String[] args) {
		int a=10,b=0,c;
		try{
			c=a/b;
		}catch (Exception e) {
			System.out.println("捕获运行时异常");
		}
	}
}
