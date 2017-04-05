package cn.csu.Gram.Detail;
/**
 * finally中的代码将在程序return之前执行，注意test4
 * @author Administrator
 *
 */
public class FinallyTest {

	public static void main(String[] args) {
		//将返回2，返回finally中的return
		System.out.println(new FinallyTest().test1());
		//将返回2，返回finally中的return
		System.out.println(new FinallyTest().test2());
		//将返回1，而不会返回自增后的i
		System.out.println(new FinallyTest().test3());
		//将返回2，而不会返回自增后的i
		System.out.println(new FinallyTest().test4());
	}
	
	public static int test1(){
		try{
			return 1;
		}catch (Exception e) {
		}finally{
			return 2;
		}
	}
	
	public static int test2(){
		int x=1;
		try{
			return x;
		}catch (Exception e) {
		}finally{
			return ++x;
		}
	}
	
	public static int test3(){
		int x=1;
		try{
			return x;
		}catch (Exception e) {
		}finally{
			++x;
		}
		return 0;
	}
	
	public static int test4(){
		int x=1;
		try{
			return fun1();
		}catch (Exception e) {
		}finally{
			return fun2();
		}
	}
	
	public static int fun1(){
		System.out.println("fun1");
		return 1;
	}
	
	public static int fun2(){
		System.out.println("fun2");
		return 2;
	}
}
