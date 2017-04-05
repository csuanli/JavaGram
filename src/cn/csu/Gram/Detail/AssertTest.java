package cn.csu.Gram.Detail;

/**
 * 在运行参数中开启-es，断言开启 
 * 程序将报错java.lang.AssertionError
 * @author Administrator
 *
 */
public class AssertTest {

	public static void main(String[] args) {
		int i=0;
		for(;i<5;i++){
			System.out.print(i);
		}
		i--;
		System.out.println("\n"+i);
		assert i==5;
	}

}
