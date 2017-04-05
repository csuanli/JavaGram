package cn.csu.Gram.Detail;

/**
 * static调用问题
 * static方法，无法直接调用非static方法，因为非static方法是与对象关联在一起的，
 * 而static方法调用时，可能没有创建任何对象。
 * 局部变量不能用static或访问修饰符修饰，final可以
 * @author user
 *
 */
public class StaticTest {
	private int i=5;
	private static int j=5;
	public void show(){
		//static int z=6;
		//public int z=6;	//局部变量不能用static或访问修饰符修饰，final可以
		final int z=6;
		System.out.println("show method");
	}
	
	public static void main(String[] args) {
		//show();	//error 无法调用非static方法
		//先创建对象，在调用
		StaticTest st=new StaticTest();
		st.show();
		
		//也无法调用非静态变量
		//i=10;
		j=10;
		
		StaticTest st1=new StaticTest();
		st1=null;
		System.out.println(st1.j);	//j仍然是类的
		
	}

}
